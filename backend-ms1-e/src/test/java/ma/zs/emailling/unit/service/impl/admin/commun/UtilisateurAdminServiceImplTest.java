package ma.zs.emailling.unit.service.impl.admin.commun;

import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.dao.facade.core.commun.UtilisateurDao;
import ma.zs.emailling.service.impl.admin.commun.UtilisateurAdminServiceImpl;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class UtilisateurAdminServiceImplTest {

    @Mock
    private UtilisateurDao repository;
    private AutoCloseable autoCloseable;
    private UtilisateurAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new UtilisateurAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllUtilisateur() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveUtilisateur() {
        // Given
        Utilisateur toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteUtilisateur() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetUtilisateurById() {
        // Given
        Long idToRetrieve = 1L; // Example Utilisateur ID to retrieve
        Utilisateur expected = new Utilisateur(); // You need to replace Utilisateur with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Utilisateur result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Utilisateur constructSample(int i) {
		Utilisateur given = new Utilisateur();
        given.setUsername("username-"+i);
        given.setPassword("password-"+i);
        given.setEmail("email-"+i);
        given.setSignature("signature-"+i);
        return given;
    }

}
