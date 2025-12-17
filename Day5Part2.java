import java.util.ArrayList;
import java.util.Comparator;
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
    // sort
    list.sort(Comparator.comparing(a -> a.start));

    // merge intervals
    List<Range> mergedList = new ArrayList<>();
    mergedList.add(list.get(0));

    for (int i = 1; i < list.size(); i++) {
        if (list.get(i).start <= mergedList.get(mergedList.size() - 1).end) {
            mergedList.get(mergedList.size() - 1).end = Math.max(mergedList.get(mergedList.size() - 1).end,
                    list.get(i).end);
        } else {
            mergedList.add(new Range(list.get(i).start, list.get(i).end));
        }
    }

    Long total = 0L;
    for (Range r : mergedList) {
        total += (r.end - r.start);
        total += 1;
    }
    System.out.println(total);
}
