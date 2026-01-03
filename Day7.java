import java.util.ArrayList;
import java.util.HashSet;

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

    // get index of the first laser
    int counter = 0;

    int idx = strings.get(0).indexOf("S");
    Set<Integer> set = new HashSet<>();
    List<Integer> history = new ArrayList<>();
    set.add(idx);

    strings = strings.subList(1, strings.size());

    for (String s : strings) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '^') {
                if (set.contains(i)) {
                    set.remove(i);
                    counter++;
                    set.add(i + 1);
                    set.add(i - 1);
                    history.add(i + 1);
                    history.add(i - 1);
                }
            }
        }
    }

    System.out.println(history.size());
}
