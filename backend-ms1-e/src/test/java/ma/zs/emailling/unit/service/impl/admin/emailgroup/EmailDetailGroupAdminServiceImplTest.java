package ma.zs.emailling.unit.service.impl.admin.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.dao.facade.core.emailgroup.EmailDetailGroupDao;
import ma.zs.emailling.service.impl.admin.emailgroup.EmailDetailGroupAdminServiceImpl;

import ma.zs.emailling.bean.core.email.Email ;
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
class EmailDetailGroupAdminServiceImplTest {

    @Mock
    private EmailDetailGroupDao repository;
    private AutoCloseable autoCloseable;
    private EmailDetailGroupAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EmailDetailGroupAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEmailDetailGroup() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEmailDetailGroup() {
        // Given
        EmailDetailGroup toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEmailDetailGroup() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEmailDetailGroupById() {
        // Given
        Long idToRetrieve = 1L; // Example EmailDetailGroup ID to retrieve
        EmailDetailGroup expected = new EmailDetailGroup(); // You need to replace EmailDetailGroup with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EmailDetailGroup result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EmailDetailGroup constructSample(int i) {
		EmailDetailGroup given = new EmailDetailGroup();
        given.setEmail(new Email(1L));
        given.setDestination(new GroupeEmail(1L));
        given.setDateReception(LocalDateTime.now());
        given.setDateLecture(LocalDateTime.now());
        return given;
    }

}
