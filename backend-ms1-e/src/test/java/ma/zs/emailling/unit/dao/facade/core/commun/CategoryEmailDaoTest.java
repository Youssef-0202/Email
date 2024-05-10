package ma.zs.emailling.unit.dao.facade.core.commun;

import ma.zs.emailling.bean.core.commun.CategoryEmail;
import ma.zs.emailling.dao.facade.core.commun.CategoryEmailDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CategoryEmailDaoTest {

@Autowired
    private CategoryEmailDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        CategoryEmail entity = new CategoryEmail();
        entity.setCode(code);
        underTest.save(entity);
        CategoryEmail loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        CategoryEmail entity = new CategoryEmail();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        CategoryEmail loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        CategoryEmail entity = new CategoryEmail();
        entity.setId(id);
        underTest.save(entity);
        CategoryEmail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CategoryEmail entity = new CategoryEmail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CategoryEmail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CategoryEmail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CategoryEmail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CategoryEmail given = constructSample(1);
        CategoryEmail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CategoryEmail constructSample(int i) {
		CategoryEmail given = new CategoryEmail();
        given.setName("name-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
