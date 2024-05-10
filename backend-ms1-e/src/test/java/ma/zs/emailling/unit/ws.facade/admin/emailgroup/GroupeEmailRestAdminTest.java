package ma.zs.emailling.unit.ws.facade.admin.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import ma.zs.emailling.service.impl.admin.emailgroup.GroupeEmailAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.emailgroup.GroupeEmailRestAdmin;
import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailConverter;
import ma.zs.emailling.ws.dto.emailgroup.GroupeEmailDto;
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
public class GroupeEmailRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private GroupeEmailAdminServiceImpl service;
    @Mock
    private GroupeEmailConverter converter;

    @InjectMocks
    private GroupeEmailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllGroupeEmailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<GroupeEmailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<GroupeEmailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveGroupeEmailTest() throws Exception {
        // Mock data
        GroupeEmailDto requestDto = new GroupeEmailDto();
        GroupeEmail entity = new GroupeEmail();
        GroupeEmail saved = new GroupeEmail();
        GroupeEmailDto savedDto = new GroupeEmailDto();

        // Mock the converter to return the groupeEmail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved groupeEmail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<GroupeEmailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        GroupeEmailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved groupeEmail DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
