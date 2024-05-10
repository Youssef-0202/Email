package ma.zs.emailling.unit.service.impl.admin.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.dao.facade.core.emailgroup.GroupeEmailDetailDao;
import ma.zs.emailling.service.impl.admin.emailgroup.GroupeEmailDetailAdminServiceImpl;

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
class GroupeEmailDetailAdminServiceImplTest {

    @Mock
    private GroupeEmailDetailDao repository;
    private AutoCloseable autoCloseable;
    private GroupeEmailDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new GroupeEmailDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllGroupeEmailDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveGroupeEmailDetail() {
        // Given
        GroupeEmailDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteGroupeEmailDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetGroupeEmailDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example GroupeEmailDetail ID to retrieve
        GroupeEmailDetail expected = new GroupeEmailDetail(); // You need to replace GroupeEmailDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        GroupeEmailDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private GroupeEmailDetail constructSample(int i) {
		GroupeEmailDetail given = new GroupeEmailDetail();
        given.setPersonne(new Utilisateur(1L));
        given.setDateAjoute(LocalDateTime.now());
        given.setDateBlockage(LocalDateTime.now());
        given.setGroupeEmail(new GroupeEmail(1L));
        return given;
    }

}
