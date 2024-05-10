package ma.zs.emailling.unit.dao.facade.core.commun;

import ma.zs.emailling.bean.core.commun.EtatEmail;
import ma.zs.emailling.dao.facade.core.commun.EtatEmailDao;

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
public class EtatEmailDaoTest {

@Autowired
    private EtatEmailDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        EtatEmail entity = new EtatEmail();
        entity.setCode(code);
        underTest.save(entity);
        EtatEmail loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        EtatEmail entity = new EtatEmail();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        EtatEmail loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        EtatEmail entity = new EtatEmail();
        entity.setId(id);
        underTest.save(entity);
        EtatEmail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EtatEmail entity = new EtatEmail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EtatEmail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EtatEmail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EtatEmail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EtatEmail given = constructSample(1);
        EtatEmail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EtatEmail constructSample(int i) {
		EtatEmail given = new EtatEmail();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
