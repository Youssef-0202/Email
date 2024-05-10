package ma.zs.emailling.unit.dao.facade.core.email;

import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.dao.facade.core.email.EmailDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.emailling.bean.core.commun.EtatEmail ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;
import ma.zs.emailling.bean.core.commun.CategoryEmail ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EmailDaoTest {

@Autowired
    private EmailDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Email entity = new Email();
        entity.setRef(ref);
        underTest.save(entity);
        Email loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Email entity = new Email();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Email loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Email entity = new Email();
        entity.setId(id);
        underTest.save(entity);
        Email loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Email entity = new Email();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Email loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Email> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Email> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Email given = constructSample(1);
        Email saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
        return given;
    }

}
