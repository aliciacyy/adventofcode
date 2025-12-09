// hello world java boilerplate

public static void main() {

    String filePath = "Day1Input.txt";
    int count = 0;
    int pointer = 50;

    try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            char direction = line.charAt(0);
            String number = line.substring(1);
            int rotation = Integer.valueOf(number);

            if (rotation > 100) {
                rotation = rotation % 100;
            }

            if (direction == 'L') {
                int newNum = pointer - rotation;
                if (newNum < 0) {
                    pointer = 100 + newNum;
                } else {
                    pointer = newNum;
                }
            } else if (direction == 'R') {
                int newNum = pointer + rotation;
                if (newNum > 99) {
                    pointer = newNum % 100;
                } else {
                    pointer = newNum;
                }
            }
            if (pointer == 0) {
                count++;
            }

        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(count);
}
