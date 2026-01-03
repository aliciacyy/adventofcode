import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public static void main() {
    List<String> strings = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("Day7Input.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            strings.add(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    int idx = strings.get(0).indexOf("S");

    // two maps
    Map<Integer, Long> map1 = new HashMap<>();
    List<Map<Integer, Long>> list = new ArrayList<>();
    map1.put(idx, 1L);
    list.add(map1);

    strings = strings.subList(1, strings.size());
    int row = 1;

    for (int z = 0; z < strings.size(); z++) {
        String s = strings.get(z);
        char[] chars = s.toCharArray();
        Map<Integer, Long> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '^') {
                // find first map that has
                Map<Integer, Long> prev = list.get(0);
                Long amt = prev.get(i);
                if (amt == null) {
                    continue;
                }
                int idx1 = i - 1;
                int idx2 = i + 1;
                System.out.println("doing " + idx1 + " " + idx2);
                // if (m.containsKey(idx1)) {
                // m.put(idx1, m.get(idx1) + amt);
                // } else {
                // m.put(idx1, amt);
                // }
                // if (m.containsKey(idx2)) {
                // m.put(idx2, m.get(idx2) + amt);
                // } else {
                // m.put(idx2, amt);
                // }
                m.merge(idx1, amt, Long::sum);
                m.merge(idx2, amt, Long::sum);
            } else {
                // it passes through
                int col = i;
                Map<Integer, Long> prev = list.get(0);
                Long num = prev.get(col);
                if (num != null) {
                    // m.put(col, num);
                    m.merge(col, num, Long::sum);
                }
            }
        }
        System.out.println("Line: " + row);
        // add any unused from the latest one to the current one
        // Map<Integer, Integer> latest = list.get(0);
        // for (Integer k : latest.keySet()) {
        // if (!m.containsKey(k) && !seen.contains(k)) {
        // m.put(k, latest.get(k));
        // }
        // }
        for (Integer key : m.keySet()) {
            System.out.println(key + ": " + m.get(key));
        }
        list.add(0, m);
        row++;
    }
    Map<Integer, Long> last = list.getFirst();
    Long sum = 0L;
    for (Integer key : last.keySet()) {
        sum += last.get(key);
        // System.out.println(key + ": " + last.get(key));
    }
    System.out.println(sum);

}
