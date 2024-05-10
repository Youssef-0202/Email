package ma.zs.emailling.unit.dao.facade.core.emailgroup;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import ma.zs.emailling.dao.facade.core.emailgroup.GroupeEmailDao;

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
public class GroupeEmailDaoTest {

@Autowired
    private GroupeEmailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        GroupeEmail entity = new GroupeEmail();
        entity.setId(id);
        underTest.save(entity);
        GroupeEmail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        GroupeEmail entity = new GroupeEmail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        GroupeEmail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<GroupeEmail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<GroupeEmail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        GroupeEmail given = constructSample(1);
        GroupeEmail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private GroupeEmail constructSample(int i) {
		GroupeEmail given = new GroupeEmail();
        given.setLibelle("libelle-"+i);
        given.setAdminGroupe(new Utilisateur(1L));
        return given;
    }

}
