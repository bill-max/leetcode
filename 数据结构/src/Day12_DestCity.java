import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day12_DestCity {
    public static void main(String[] args) {
//        List<List<String>> paths ={{"London", "New York"},{"New York", "Lima"},{"Lima", "Sao Paulo"}};
        List<List<String>> paths = new ArrayList<>();
        List<String> e = new ArrayList<>();
        e.add("London");
        e.add("New York");
        paths.add(e);
        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Map map = new HashMap<String, String>();
        String s = paths.get(0).get(0);
        String d = paths.get(0).get(1);
        for (List<String> path :
                paths) {
            map.put(path.get(0), path.get(1));
        }
        while (true) {
            if (map.containsKey(d)) {
                s = d;
                d = (String) map.get(s);
            } else {
                return d;
            }
        }
    }

}
