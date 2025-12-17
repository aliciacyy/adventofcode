import java.util.ArrayList;
import java.util.HashSet;

public static class Range {
    Long start;
    Long end;

    public Range(Long s, Long e) {
        this.start = s;
        this.end = e;
    }
}

public static void main() {
    List<Range> list = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("Day5Input1.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] range = line.split("-");
            Long start = Long.valueOf(range[0]);
            Long end = Long.valueOf(range[1]);
            list.add(new Range(start, end));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    int fresh = 0;
    try (BufferedReader reader = Files.newBufferedReader(Paths.get("Day5Input2.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            Long val = Long.valueOf(line);
            for (Range r : list) {
                if (r.start == val || r.end == val || (r.start < val && r.end > val)) {
                    fresh++;
                    break;
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(fresh);
}
