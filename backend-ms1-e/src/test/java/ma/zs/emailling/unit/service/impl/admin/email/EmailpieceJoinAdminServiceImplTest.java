package ma.zs.emailling.unit.service.impl.admin.email;

import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import ma.zs.emailling.dao.facade.core.email.EmailpieceJoinDao;
import ma.zs.emailling.service.impl.admin.email.EmailpieceJoinAdminServiceImpl;

import ma.zs.emailling.bean.core.email.Email ;
import ma.zs.emailling.bean.core.commun.TypeContenu ;
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
class EmailpieceJoinAdminServiceImplTest {

    @Mock
    private EmailpieceJoinDao repository;
    private AutoCloseable autoCloseable;
    private EmailpieceJoinAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmailpieceJoinAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEmailpieceJoin() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEmailpieceJoin() {
        // Given
        EmailpieceJoin toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEmailpieceJoin() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEmailpieceJoinById() {
        // Given
        Long idToRetrieve = 1L; // Example EmailpieceJoin ID to retrieve
        EmailpieceJoin expected = new EmailpieceJoin(); // You need to replace EmailpieceJoin with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EmailpieceJoin result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EmailpieceJoin constructSample(int i) {
		EmailpieceJoin given = new EmailpieceJoin();
        given.setEmail(new Email(1L));
        given.setPath("path-"+i);
        given.setTaille("taille-"+i);
        given.setTypeContenu(new TypeContenu(1L));
        return given;
    }

}
