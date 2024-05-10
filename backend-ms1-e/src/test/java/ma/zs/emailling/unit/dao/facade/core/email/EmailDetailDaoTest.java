package ma.zs.emailling.unit.dao.facade.core.email;

import ma.zs.emailling.bean.core.email.EmailDetail;
import ma.zs.emailling.dao.facade.core.email.EmailDetailDao;

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
import ma.zs.emailling.bean.core.email.Email ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EmailDetailDaoTest {

@Autowired
    private EmailDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        EmailDetail entity = new EmailDetail();
        entity.setId(id);
        underTest.save(entity);
        EmailDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EmailDetail entity = new EmailDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EmailDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EmailDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EmailDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EmailDetail given = constructSample(1);
        EmailDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EmailDetail constructSample(int i) {
		EmailDetail given = new EmailDetail();
        given.setEmail(new Email(1L));
        given.setPersonneDestinataire(new Utilisateur(1L));
        given.setEtatEmail(new EtatEmail(1L));
        given.setDateLecture(LocalDateTime.now());
        given.setDateReception(LocalDateTime.now());
        return given;
    }

}
