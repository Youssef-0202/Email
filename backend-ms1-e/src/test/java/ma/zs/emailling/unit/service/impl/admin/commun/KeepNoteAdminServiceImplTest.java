package ma.zs.emailling.unit.service.impl.admin.commun;

import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.dao.facade.core.commun.KeepNoteDao;
import ma.zs.emailling.service.impl.admin.commun.KeepNoteAdminServiceImpl;

import ma.zs.emailling.bean.core.commun.Utilisateur ;
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
class KeepNoteAdminServiceImplTest {

    @Mock
    private KeepNoteDao repository;
    private AutoCloseable autoCloseable;
    private KeepNoteAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new KeepNoteAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllKeepNote() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveKeepNote() {
        // Given
        KeepNote toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteKeepNote() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetKeepNoteById() {
        // Given
        Long idToRetrieve = 1L; // Example KeepNote ID to retrieve
        KeepNote expected = new KeepNote(); // You need to replace KeepNote with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        KeepNote result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private KeepNote constructSample(int i) {
		KeepNote given = new KeepNote();
        given.setBody("body-"+i);
        given.setHeader("header-"+i);
        given.setPersonne(new Utilisateur(1L));
        given.setDateKeepNote(LocalDateTime.now());
        return given;
    }

}
