package dmitry.quiz.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path
 * going from cityAi to cityBi. Return the destination city, that is, the city
 * without any path outgoing to another city.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop,
 * therefore, there will be exactly one destination city.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * Output: "Sao Paulo"
 * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
 * Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 * Example 2:
 * <p>
 * Input: paths = [["B","C"],["D","B"],["C","A"]]
 * Output: "A"
 * Explanation: All possible trips are:
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * Clearly the destination city is "A".
 * Example 3:
 * <p>
 * Input: paths = [["A","Z"]]
 * Output: "Z"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * All strings consist of lowercase and uppercase English letters and the space character.
 *
 * Constraints:
 *
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 **/
public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        // destMap(city) = true, if and only if the city is destination only, not source
        Map<String, Boolean> destMap = new HashMap<String, Boolean>();
        // Go through, put city to destMap
        for (List<String> p : paths) {
            String source = p.get(0);
            String dest = p.get(1);
            // If this destination city is not in map, put it as a destination
            destMap.putIfAbsent(dest, true);
            // If this is source city, put or update it as a source
            destMap.put(source, false);
        }
        // Find the only destination city in destMap
        return destMap.entrySet().stream().filter((Map.Entry<String, Boolean> e) -> e.getValue()).map((Map.Entry<String, Boolean> e) -> e.getKey()).findFirst().get();
    }
}