package ma.zs.emailling.unit.service.impl.admin.commun;

import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.dao.facade.core.commun.CategoryEmailDao;
import ma.zs.emailling.service.impl.admin.commun.CategoryEmailAdminServiceImpl;

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
class CategoryEmailAdminServiceImplTest {

    @Mock
    private CategoryEmailDao repository;
    private AutoCloseable autoCloseable;
    private CategoryEmailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategoryEmailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategoryEmail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCategoryEmail() {
        // Given
        CategoryEmail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCategoryEmail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCategoryEmailById() {
        // Given
        Long idToRetrieve = 1L; // Example CategoryEmail ID to retrieve
        CategoryEmail expected = new CategoryEmail(); // You need to replace CategoryEmail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CategoryEmail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CategoryEmail constructSample(int i) {
		CategoryEmail given = new CategoryEmail();
        given.setName("name-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
