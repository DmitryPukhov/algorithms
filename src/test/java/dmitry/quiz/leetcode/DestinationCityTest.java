package dmitry.quiz.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * We do not test corner cases because of constraints.
 * Constraints:
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 */
class DestinationCityTest {

    private DestinationCity alg = new DestinationCity();

    @Test
    void destCity_singlePath() {
        String dest = alg.destCity(Arrays.asList(Arrays.asList("A", "Z")));
        assertEquals("Z", dest);
    }

    @Test
    void destCity_multiPath() {
        // [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
        String dest = alg.destCity(Arrays.asList(Arrays.asList("London", "New York"),
                Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sao Paulo")));
        assertEquals("Sao Paulo", dest);
    }

}