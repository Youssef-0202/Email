package ma.zs.emailling.unit.ws.facade.admin.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.service.impl.admin.emailgroup.GroupeEmailDetailAdminServiceImpl;
import ma.zs.emailling.ws.facade.admin.emailgroup.GroupeEmailDetailRestAdmin;
import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailDetailConverter;
import ma.zs.emailling.ws.dto.emailgroup.GroupeEmailDetailDto;
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
public class GroupeEmailDetailRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private GroupeEmailDetailAdminServiceImpl service;
    @Mock
    private GroupeEmailDetailConverter converter;

    @InjectMocks
    private GroupeEmailDetailRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllGroupeEmailDetailTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<GroupeEmailDetailDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<GroupeEmailDetailDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveGroupeEmailDetailTest() throws Exception {
        // Mock data
        GroupeEmailDetailDto requestDto = new GroupeEmailDetailDto();
        GroupeEmailDetail entity = new GroupeEmailDetail();
        GroupeEmailDetail saved = new GroupeEmailDetail();
        GroupeEmailDetailDto savedDto = new GroupeEmailDetailDto();

        // Mock the converter to return the groupeEmailDetail object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved groupeEmailDetail DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<GroupeEmailDetailDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        GroupeEmailDetailDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved groupeEmailDetail DTO
        assertEquals(savedDto.getDateAjoute(), responseBody.getDateAjoute());
        assertEquals(savedDto.getDateBlockage(), responseBody.getDateBlockage());
    }

}
