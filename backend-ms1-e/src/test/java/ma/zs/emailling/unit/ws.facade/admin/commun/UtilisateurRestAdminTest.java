package ma.zs.emailling.unit.ws.facade.admin.commun;

import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.service.impl.admin.commun.UtilisateurAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.commun.UtilisateurRestAdmin;
import ma.zs.emailling.ws.converter.commun.UtilisateurConverter;
import ma.zs.emailling.ws.dto.commun.UtilisateurDto;
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
public class UtilisateurRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private UtilisateurAdminServiceImpl service;
    @Mock
    private UtilisateurConverter converter;

    @InjectMocks
    private UtilisateurRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllUtilisateurTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<UtilisateurDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<UtilisateurDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveUtilisateurTest() throws Exception {
        // Mock data
        UtilisateurDto requestDto = new UtilisateurDto();
        Utilisateur entity = new Utilisateur();
        Utilisateur saved = new Utilisateur();
        UtilisateurDto savedDto = new UtilisateurDto();

        // Mock the converter to return the utilisateur object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved utilisateur DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<UtilisateurDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        UtilisateurDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved utilisateur DTO
        assertEquals(savedDto.getUsername(), responseBody.getUsername());
        assertEquals(savedDto.getPassword(), responseBody.getPassword());
        assertEquals(savedDto.getEmail(), responseBody.getEmail());
        assertEquals(savedDto.getSignature(), responseBody.getSignature());
    }

}
