package ma.zs.emailling.unit.service.impl.admin.email;

import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.dao.facade.core.email.EmailDetailDao;
import ma.zs.emailling.service.impl.admin.email.EmailDetailAdminServiceImpl;

import ma.zs.emailling.bean.core.commun.EtatEmail ;
import ma.zs.emailling.bean.core.email.Email ;
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
class EmailDetailAdminServiceImplTest {

    @Mock
    private EmailDetailDao repository;
    private AutoCloseable autoCloseable;
    private EmailDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmailDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEmailDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEmailDetail() {
        // Given
        EmailDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEmailDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEmailDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example EmailDetail ID to retrieve
        EmailDetail expected = new EmailDetail(); // You need to replace EmailDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EmailDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EmailDetail constructSample(int i) {
		EmailDetail given = new EmailDetail();
        given.setEmail(new Email(1L));
        given.setPersonneDestinataire(new Utilisateur(1L));
        given.setEtatEmail(new EtatEmail(1L));
        given.setDateLecture(LocalDateTime.now());
        given.setDateReception(LocalDateTime.now());
        return given;
    }

}
