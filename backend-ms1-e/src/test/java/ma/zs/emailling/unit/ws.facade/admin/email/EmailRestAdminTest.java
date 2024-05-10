package ma.zs.emailling.unit.ws.facade.admin.email;

import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.service.impl.admin.email.EmailAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.email.EmailRestAdmin;
import ma.zs.emailling.ws.converter.email.EmailConverter;
import ma.zs.emailling.ws.dto.email.EmailDto;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmailRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EmailAdminServiceImpl service;
    @Mock
    private EmailConverter converter;

    @InjectMocks
    private EmailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEmailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EmailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EmailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEmailTest() throws Exception {
        // Mock data
        EmailDto requestDto = new EmailDto();
        Email entity = new Email();
        Email saved = new Email();
        EmailDto savedDto = new EmailDto();

        // Mock the converter to return the email object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved email DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EmailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EmailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved email DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getDateEnvoi(), responseBody.getDateEnvoi());
        assertEquals(savedDto.getCorps(), responseBody.getCorps());
        assertEquals(savedDto.getHeader(), responseBody.getHeader());
    }

}
