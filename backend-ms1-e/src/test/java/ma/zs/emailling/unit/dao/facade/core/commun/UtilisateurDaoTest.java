package ma.zs.emailling.unit.dao.facade.core.commun;

import ma.zs.emailling.bean.core.commun.Utilisateur;
import ma.zs.emailling.dao.facade.core.commun.UtilisateurDao;

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
public class UtilisateurDaoTest {

@Autowired
    private UtilisateurDao underTest;

    @Test
    void shouldFindByUsername(){
        String username = "username-1";
        Utilisateur entity = new Utilisateur();
        entity.setUsername(username);
        underTest.save(entity);
        Utilisateur loaded = underTest.findByUsername(username);
        assertThat(loaded.getUsername()).isEqualTo(username);
    }

    @Test
    void shouldDeleteByUsername() {
        String username = "username-1";
        Utilisateur entity = new Utilisateur();
        entity.setUsername(username);
        underTest.save(entity);

        int result = underTest.deleteByUsername(username);

        Utilisateur loaded = underTest.findByUsername(username);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Utilisateur entity = new Utilisateur();
        entity.setId(id);
        underTest.save(entity);
        Utilisateur loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Utilisateur entity = new Utilisateur();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Utilisateur loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Utilisateur> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Utilisateur> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Utilisateur given = constructSample(1);
        Utilisateur saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Utilisateur constructSample(int i) {
		Utilisateur given = new Utilisateur();
        given.setUsername("username-"+i);
        given.setPassword("password-"+i);
        given.setEmail("email-"+i);
        given.setSignature("signature-"+i);
        return given;
    }

}
