import java.util.ArrayList;

public static void main() {
    List<List<String>> lists = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("Day6Input.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] split = line.trim().split("\\s+");
            lists.add(Arrays.asList(split));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    Long total = 0L;
    for (int i = 0; i < lists.get(0).size(); i++) {
        List<Long> numbers = new ArrayList<>();
        Long subtotal = 0L;
        for (int j = 0; j < lists.size(); j++) {
            if (j != lists.size() - 1) {
                // it is number
                numbers.add(Long.valueOf(lists.get(j).get(i)));
            } else {
                String operator = lists.get(j).get(i);
                switch (operator) {
                    case "+":
                        for (Long l : numbers) {
                            subtotal += l;
                        }
                        break;
                    case "*":
                        subtotal = 1L;
                        for (Long l : numbers) {
                            subtotal *= l;
                        }
                        break;
                }
            }
        }
        total += subtotal;
    }
    System.out.println(total);
}
