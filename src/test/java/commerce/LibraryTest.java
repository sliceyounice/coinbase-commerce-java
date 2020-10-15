/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package commerce;

import commerce.model.charge.Charge;
import commerce.model.charge.ChargeRequest;
import commerce.util.JsonMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    String apiKey = "your key";

    @Test
    void testSomeLibraryMethod() {
        ApiClient client = new ApiClient(apiKey);
        Charge charge = client.charges().create(new ChargeRequest("test", "test"));
        System.out.println("created");
    }
}
