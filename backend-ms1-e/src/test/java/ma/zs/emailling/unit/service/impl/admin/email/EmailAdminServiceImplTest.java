package ma.zs.emailling.unit.service.impl.admin.email;

import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.dao.facade.core.email.EmailDao;
import ma.zs.emailling.service.impl.admin.email.EmailAdminServiceImpl;

import ma.zs.emailling.bean.core.commun.EtatEmail ;
import ma.zs.emailling.bean.core.email.Email ;
import ma.zs.emailling.bean.core.email.EmailpieceJoin ;
import ma.zs.emailling.bean.core.commun.TypeContenu ;
import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;
import ma.zs.emailling.bean.core.commun.CategoryEmail ;
import ma.zs.emailling.bean.core.email.EmailDetail ;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail ;
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
class EmailAdminServiceImplTest {

    @Mock
    private EmailDao repository;
    private AutoCloseable autoCloseable;
    private EmailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEmail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEmail() {
        // Given
        Email toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEmail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEmailById() {
        // Given
        Long idToRetrieve = 1L; // Example Email ID to retrieve
        Email expected = new Email(); // You need to replace Email with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Email result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Email constructSample(int i) {
		Email given = new Email();
        given.setRef("ref-"+i);
        given.setPersonneSource(new Utilisateur(1L));
        given.setDateEnvoi(LocalDateTime.now());
        given.setCorps("corps-"+i);
        given.setHeader("header-"+i);
        given.setCategoryEmail(new CategoryEmail(1L));
        given.setEtatEmail(new EtatEmail(1L));
        List<EmailDetail> emailDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                EmailDetail element = new EmailDetail();
                                                element.setId((long)id);
                                                element.setEmail(new Email(Long.valueOf(1)));
                                                element.setPersonneDestinataire(new Utilisateur(Long.valueOf(2)));
                                                element.setEtatEmail(new EtatEmail(Long.valueOf(3)));
                                                element.setDateLecture(LocalDateTime.now());
                                                element.setDateReception(LocalDateTime.now());
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setEmailDetails(emailDetails);
        List<EmailpieceJoin> emailpieceJoints = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                EmailpieceJoin element = new EmailpieceJoin();
                                                element.setId((long)id);
                                                element.setEmail(new Email(Long.valueOf(1)));
                                                element.setPath("path"+id);
                                                element.setTaille("taille"+id);
                                                element.setTypeContenu(new TypeContenu(Long.valueOf(4)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setEmailpieceJoints(emailpieceJoints);
        List<EmailDetailGroup> emailDetailGroups = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                EmailDetailGroup element = new EmailDetailGroup();
                                                element.setId((long)id);
                                                element.setEmail(new Email(Long.valueOf(1)));
                                                element.setDestination(new GroupeEmail(Long.valueOf(2)));
                                                element.setDateReception(LocalDateTime.now());
                                                element.setDateLecture(LocalDateTime.now());
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setEmailDetailGroups(emailDetailGroups);
        return given;
    }

}
