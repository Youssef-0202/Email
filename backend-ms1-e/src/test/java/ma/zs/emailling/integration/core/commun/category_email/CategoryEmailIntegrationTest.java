package ma.zs.emailling.integration.core.commun.category_email;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;
public class CategoryEmailIntegrationTest {

    String pathHappy = "src/test/java/ma/zs/emailling/integration/core/commun/category_email/CategoryEmailHappyTest.feature";
    String pathSad = "src/test/java/ma/zs/emailling/integration/core/commun/category_email/CategoryEmailSadTest.feature";


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "dev");
    }

  
    @Karate.Test
    Karate saveHappyTest() {
     return Karate.run(pathHappy).tags("save");


    }
    @Karate.Test
    Karate findAllHappyTest() {
        return Karate.run(pathHappy).tags("findAll");

    }
    @Karate.Test
    Karate deleteHappyTest() {
        return Karate.run(pathHappy).tags("delete");

    }
    @Karate.Test
    Karate putHappyTest() {
        return Karate.run(pathHappy).tags("put");
    }
	
  //Sad Test


    @Karate.Test
    Karate duplicateSadTest() {
        return Karate.run(pathSad).tags("duplicate");
    }

    @Karate.Test
    Karate getByIdNotFoundSadTest() {
        return Karate.run(pathSad).tags("getByIdNotFound");
    }
	
    @Karate.Test
    Karate saveWithoutBodySadTest() {
        return Karate.run(pathSad).tags("saveWithoutBody");
    }
	
    @Karate.Test
    Karate saveWithoutAuthorizationSadTest() {
        return Karate.run(pathSad).tags("saveWithoutAuthorization");
    }
	
    @Karate.Test
    Karate saveWithPatchMethodSadTest() {
        return Karate.run(pathSad).tags("saveWithPatchMethod");
    }

}


