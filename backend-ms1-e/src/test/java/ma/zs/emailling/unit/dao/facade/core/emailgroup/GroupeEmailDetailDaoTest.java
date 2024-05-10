package ma.zs.emailling.unit.dao.facade.core.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.dao.facade.core.emailgroup.GroupeEmailDetailDao;

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
import ma.zs.emailling.bean.core.emailgroup.GroupeEmail ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GroupeEmailDetailDaoTest {

@Autowired
    private GroupeEmailDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        GroupeEmailDetail entity = new GroupeEmailDetail();
        entity.setId(id);
        underTest.save(entity);
        GroupeEmailDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        GroupeEmailDetail entity = new GroupeEmailDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        GroupeEmailDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<GroupeEmailDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<GroupeEmailDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        GroupeEmailDetail given = constructSample(1);
        GroupeEmailDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private GroupeEmailDetail constructSample(int i) {
		GroupeEmailDetail given = new GroupeEmailDetail();
        given.setPersonne(new Utilisateur(1L));
        given.setDateAjoute(LocalDateTime.now());
        given.setDateBlockage(LocalDateTime.now());
        given.setGroupeEmail(new GroupeEmail(1L));
        return given;
    }

}
