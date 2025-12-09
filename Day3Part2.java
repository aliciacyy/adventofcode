public static void main() {
    try (BufferedReader reader = Files.newBufferedReader(Paths.get("Day3Input.txt"))) {
        String line;
        Long total = 0L;
        while ((line = reader.readLine()) != null) {
            // start from 0 until last 12th to find the first biggest, get the idx
            // next round start from idx to last 11th, get the idx
            // next round start from idx ...

            double num = 0L;
            int startIdx = 0;

            for (int j = 12; j > 0; j--) {
                int max = 0;
                int tempIdx = 0;
                for (int i = startIdx; i <= line.length() - j; i++) {
                    int curr = Integer.valueOf(String.valueOf(line.charAt(i)));
                    if (max < curr) {
                        max = curr;
                        tempIdx = i;
                    }
                }
                startIdx = tempIdx + 1;
                double a = Double.valueOf(max) * Math.pow(10, j - 1);
                num += a;
            }
            System.out.println((long) num);
            total += (long) num;
        }
        System.out.println("Total " + total);
    } catch (IOException e) {
        e.printStackTrace();
    }

}
