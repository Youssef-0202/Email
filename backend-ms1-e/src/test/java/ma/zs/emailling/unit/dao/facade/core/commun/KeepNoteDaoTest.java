package ma.zs.emailling.unit.dao.facade.core.commun;

import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.dao.facade.core.commun.KeepNoteDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.emailling.bean.core.commun.Utilisateur ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class KeepNoteDaoTest {

@Autowired
    private KeepNoteDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        KeepNote entity = new KeepNote();
        entity.setId(id);
        underTest.save(entity);
        KeepNote loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        KeepNote entity = new KeepNote();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        KeepNote loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<KeepNote> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<KeepNote> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        KeepNote given = constructSample(1);
        KeepNote saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private KeepNote constructSample(int i) {
		KeepNote given = new KeepNote();
        given.setBody("body-"+i);
        given.setHeader("header-"+i);
        given.setPersonne(new Utilisateur(1L));
        given.setDateKeepNote(LocalDateTime.now());
        return given;
    }

}
