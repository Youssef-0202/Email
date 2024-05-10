package ma.zs.emailling.unit.service.impl.admin.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import ma.zs.emailling.dao.facade.core.emailgroup.GroupeEmailDao;
import ma.zs.emailling.service.impl.admin.emailgroup.GroupeEmailAdminServiceImpl;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;
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
class GroupeEmailAdminServiceImplTest {

    @Mock
    private GroupeEmailDao repository;
    private AutoCloseable autoCloseable;
    private GroupeEmailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new GroupeEmailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllGroupeEmail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveGroupeEmail() {
        // Given
        GroupeEmail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteGroupeEmail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetGroupeEmailById() {
        // Given
        Long idToRetrieve = 1L; // Example GroupeEmail ID to retrieve
        GroupeEmail expected = new GroupeEmail(); // You need to replace GroupeEmail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        GroupeEmail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private GroupeEmail constructSample(int i) {
		GroupeEmail given = new GroupeEmail();
        given.setLibelle("libelle-"+i);
        given.setAdminGroupe(new Utilisateur(1L));
        List<GroupeEmailDetail> groupeEmailDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                GroupeEmailDetail element = new GroupeEmailDetail();
                                                element.setId((long)id);
                                                element.setPersonne(new Utilisateur(Long.valueOf(1)));
                                                element.setDateAjoute(LocalDateTime.now());
                                                element.setDateBlockage(LocalDateTime.now());
                                                element.setGroupeEmail(new GroupeEmail(Long.valueOf(4)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setGroupeEmailDetails(groupeEmailDetails);
        return given;
    }

}
