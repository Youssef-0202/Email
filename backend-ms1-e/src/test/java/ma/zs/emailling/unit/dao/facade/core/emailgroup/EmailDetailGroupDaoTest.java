package ma.zs.emailling.unit.dao.facade.core.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.EmailDetailGroup;
import ma.zs.emailling.dao.facade.core.emailgroup.EmailDetailGroupDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.emailling.bean.core.email.Email ;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EmailDetailGroupDaoTest {

@Autowired
    private EmailDetailGroupDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        EmailDetailGroup entity = new EmailDetailGroup();
        entity.setId(id);
        underTest.save(entity);
        EmailDetailGroup loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EmailDetailGroup entity = new EmailDetailGroup();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EmailDetailGroup loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EmailDetailGroup> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EmailDetailGroup> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EmailDetailGroup given = constructSample(1);
        EmailDetailGroup saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
