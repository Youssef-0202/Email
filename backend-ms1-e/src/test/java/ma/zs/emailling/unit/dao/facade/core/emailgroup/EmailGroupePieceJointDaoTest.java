package ma.zs.emailling.unit.dao.facade.core.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.EmailGroupePieceJoint;
import ma.zs.emailling.dao.facade.core.emailgroup.EmailGroupePieceJointDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.emailling.bean.core.commun.TypeContenu ;
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EmailGroupePieceJointDaoTest {

@Autowired
    private EmailGroupePieceJointDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        EmailGroupePieceJoint entity = new EmailGroupePieceJoint();
        entity.setId(id);
        underTest.save(entity);
        EmailGroupePieceJoint loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EmailGroupePieceJoint entity = new EmailGroupePieceJoint();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EmailGroupePieceJoint loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EmailGroupePieceJoint> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EmailGroupePieceJoint> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EmailGroupePieceJoint given = constructSample(1);
        EmailGroupePieceJoint saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EmailGroupePieceJoint constructSample(int i) {
		EmailGroupePieceJoint given = new EmailGroupePieceJoint();
        given.setPath("path-"+i);
        given.setTaille(i*1L);
        given.setTypecontenu(new TypeContenu(1L));
        given.setGroupeEmail(new GroupeEmail(1L));
        return given;
    }

}
