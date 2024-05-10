package ma.zs.emailling.unit.dao.facade.core.commun;

import ma.zs.emailling.bean.core.commun.TypeContenu;
import ma.zs.emailling.dao.facade.core.commun.TypeContenuDao;

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
public class TypeContenuDaoTest {

@Autowired
    private TypeContenuDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        TypeContenu entity = new TypeContenu();
        entity.setCode(code);
        underTest.save(entity);
        TypeContenu loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        TypeContenu entity = new TypeContenu();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        TypeContenu loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TypeContenu entity = new TypeContenu();
        entity.setId(id);
        underTest.save(entity);
        TypeContenu loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypeContenu entity = new TypeContenu();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypeContenu loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypeContenu> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypeContenu> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypeContenu given = constructSample(1);
        TypeContenu saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypeContenu constructSample(int i) {
		TypeContenu given = new TypeContenu();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
