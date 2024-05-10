package ma.zs.emailling.unit.service.impl.admin.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import ma.zs.emailling.dao.facade.core.emailgroup.EmailGroupePieceJointDao;
import ma.zs.emailling.service.impl.admin.emailgroup.EmailGroupePieceJointAdminServiceImpl;

import ma.zs.emailling.bean.core.commun.TypeContenu ;
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
class EmailGroupePieceJointAdminServiceImplTest {

    @Mock
    private EmailGroupePieceJointDao repository;
    private AutoCloseable autoCloseable;
    private EmailGroupePieceJointAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmailGroupePieceJointAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEmailGroupePieceJoint() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEmailGroupePieceJoint() {
        // Given
        EmailGroupePieceJoint toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEmailGroupePieceJoint() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEmailGroupePieceJointById() {
        // Given
        Long idToRetrieve = 1L; // Example EmailGroupePieceJoint ID to retrieve
        EmailGroupePieceJoint expected = new EmailGroupePieceJoint(); // You need to replace EmailGroupePieceJoint with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EmailGroupePieceJoint result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EmailGroupePieceJoint constructSample(int i) {
		EmailGroupePieceJoint given = new EmailGroupePieceJoint();
        given.setPath("path-"+i);
        given.setTaille(i*1L);
        given.setTypecontenu(new TypeContenu(1L));
        given.setGroupeEmail(new GroupeEmail(1L));
        return given;
    }

}
