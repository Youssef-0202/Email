package ma.zs.emailling.unit.dao.facade.core.email;

import ma.zs.emailling.bean.core.email.EmailpieceJoin;
import ma.zs.emailling.dao.facade.core.email.EmailpieceJoinDao;

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
import ma.zs.emailling.bean.core.commun.TypeContenu ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EmailpieceJoinDaoTest {

@Autowired
    private EmailpieceJoinDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        EmailpieceJoin entity = new EmailpieceJoin();
        entity.setId(id);
        underTest.save(entity);
        EmailpieceJoin loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EmailpieceJoin entity = new EmailpieceJoin();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EmailpieceJoin loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EmailpieceJoin> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EmailpieceJoin> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EmailpieceJoin given = constructSample(1);
        EmailpieceJoin saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EmailpieceJoin constructSample(int i) {
		EmailpieceJoin given = new EmailpieceJoin();
        given.setEmail(new Email(1L));
        given.setPath("path-"+i);
        given.setTaille("taille-"+i);
        given.setTypeContenu(new TypeContenu(1L));
        return given;
    }

}
