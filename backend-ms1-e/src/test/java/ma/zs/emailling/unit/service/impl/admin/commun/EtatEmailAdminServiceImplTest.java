package ma.zs.emailling.unit.service.impl.admin.commun;

import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.dao.facade.core.commun.EtatEmailDao;
import ma.zs.emailling.service.impl.admin.commun.EtatEmailAdminServiceImpl;

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
class EtatEmailAdminServiceImplTest {

    @Mock
    private EtatEmailDao repository;
    private AutoCloseable autoCloseable;
    private EtatEmailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EtatEmailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEtatEmail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEtatEmail() {
        // Given
        EtatEmail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEtatEmail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEtatEmailById() {
        // Given
        Long idToRetrieve = 1L; // Example EtatEmail ID to retrieve
        EtatEmail expected = new EtatEmail(); // You need to replace EtatEmail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EtatEmail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EtatEmail constructSample(int i) {
		EtatEmail given = new EtatEmail();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
