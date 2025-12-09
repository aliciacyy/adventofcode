public static void main() {
    try (BufferedReader reader = Files.newBufferedReader(Paths.get("Day3Input.txt"))) {
        String line;
        Long total = 0L;
        while ((line = reader.readLine()) != null) {
            int max = 0;
            int maxIdx = 0;
            // loop twice, once for the biggest digit and second for the next biggest
            // edge case: if the biggest is at the end, don't take it!
            for (int i = 0; i < line.length(); i++) {
                int curr = Integer.valueOf(String.valueOf(line.charAt(i)));
                if (max < curr) {
                    if (i != line.length() - 1) {
                        max = curr;
                        maxIdx = i;
                    }
                }
            }

            int nextMax = 0;
            for (int j = maxIdx + 1; j < line.length(); j++) {
                int curr = Integer.valueOf(String.valueOf(line.charAt(j)));
                if (nextMax < curr) {
                    nextMax = curr;
                }
            }
            int big = (max * 10) + nextMax;
            System.out.println(big);
            total += big;
        }
        System.out.println("Total " + total);
    } catch (IOException e) {
        e.printStackTrace();
    }

}
