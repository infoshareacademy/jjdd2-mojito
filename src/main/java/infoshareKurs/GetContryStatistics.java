package infoshareKurs;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class GetContryStatistics {

    private Map<String, Integer> stats = new HashMap<>();

    public void add(String name) {
        if (stats.containsKey(name)) {
            int currentValue = stats.get(name);
            stats.put(name, currentValue + 1);
        } else {
            stats.put(name, 1);
        }
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

}