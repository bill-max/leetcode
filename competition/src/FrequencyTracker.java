import java.util.HashMap;
import java.util.Map;

class FrequencyTracker {

    Map<Integer, Integer> map;
    Map<Integer, Integer> frq;

    public FrequencyTracker() {
        map = new HashMap<Integer, Integer>();
        frq = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
        int cnt = map.getOrDefault(number, 0);
        map.put(number, cnt + 1);
        if (frq.containsKey(cnt) && frq.get(cnt) != 0) {
            frq.put(cnt, frq.get(cnt) - 1);
        }
        frq.put(cnt + 1, frq.getOrDefault(cnt + 1, 0) + 1);
    }

    public void deleteOne(int number) {
        if (!map.containsKey(number)||map.get(number) == 0) {
            return;
        }
        int cnt = map.get(number);
        map.put(number, cnt - 1);
        frq.put(cnt, frq.get(cnt) - 1);
        frq.put(cnt - 1, frq.getOrDefault(cnt - 1, 0) + 1);
    }

    public boolean hasFrequency(int frequency) {
        return frq.containsKey(frequency) && frq.get(frequency) != 0;
    }
}
