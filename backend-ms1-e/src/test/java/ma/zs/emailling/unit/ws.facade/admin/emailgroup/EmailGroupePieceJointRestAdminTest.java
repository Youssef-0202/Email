package ma.zs.emailling.unit.ws.facade.admin.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import ma.zs.emailling.service.impl.admin.emailgroup.EmailGroupePieceJointAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.emailgroup.EmailGroupePieceJointRestAdmin;
import ma.zs.emailling.ws.converter.emailgroup.EmailGroupePieceJointConverter;
import ma.zs.emailling.ws.dto.emailgroup.EmailGroupePieceJointDto;
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
public class EmailGroupePieceJointRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EmailGroupePieceJointAdminServiceImpl service;
    @Mock
    private EmailGroupePieceJointConverter converter;

    @InjectMocks
    private EmailGroupePieceJointRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEmailGroupePieceJointTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EmailGroupePieceJointDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EmailGroupePieceJointDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEmailGroupePieceJointTest() throws Exception {
        // Mock data
        EmailGroupePieceJointDto requestDto = new EmailGroupePieceJointDto();
        EmailGroupePieceJoint entity = new EmailGroupePieceJoint();
        EmailGroupePieceJoint saved = new EmailGroupePieceJoint();
        EmailGroupePieceJointDto savedDto = new EmailGroupePieceJointDto();

        // Mock the converter to return the emailGroupePieceJoint object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved emailGroupePieceJoint DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EmailGroupePieceJointDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EmailGroupePieceJointDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved emailGroupePieceJoint DTO
        assertEquals(savedDto.getPath(), responseBody.getPath());
        assertEquals(savedDto.getTaille(), responseBody.getTaille());
    }

}
