import java.util.ArrayList;

public static void main() {
    List<String> fullList = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("Day6Input.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // String[] split = line.trim().split("\\s+");
            fullList.add(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // we know the length of each column by finding distance to next non-space
    String lastLine = fullList.get(fullList.size() - 1);

    // remove last line from fullList
    fullList = fullList.subList(0, fullList.size() - 1);

    Long total = 0L;

    for (int i = 0; i < lastLine.length(); i++) {
        char operator = lastLine.charAt(i);
        if (operator != ' ') {
            Long subtotal = 0L;
            if (operator == '*') {
                subtotal = 1L;
            }

            int startIdx = i;
            int endIdx = i + 1;
            while (lastLine.charAt(endIdx) == ' ') {
                endIdx++;
                if (endIdx == lastLine.length())
                    break;
            }
            if (endIdx != lastLine.length()) {
                endIdx -= 2;
            } else {
                endIdx--;
            }

            // System.out.printf("startIdx: %d, endIdx: %d %n", startIdx, endIdx);

            for (; endIdx >= startIdx; endIdx--) {
                StringBuilder sb = new StringBuilder();
                for (String n : fullList) {
                    char nc = n.charAt(endIdx);
                    if (nc == ' ')
                        continue;
                    sb.append(nc);
                }
                System.out.println("NUM: " + sb.toString());
                switch (operator) {
                    case '+':
                        subtotal += Long.valueOf(sb.toString());
                        break;
                    case '*':
                        subtotal *= Long.valueOf(sb.toString());
                        break;
                }
            }
            // System.out.printf("subtotal: %d%n", subtotal);
            total += subtotal;
        }
    }
    System.out.println(total);
}
