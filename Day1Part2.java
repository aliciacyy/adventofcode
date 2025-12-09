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

            System.out.print("Rotating " + line + "\t");
            if (direction == 'L') {
                int newNum = pointer - rotation;
                System.out.print("Rotated to: " + newNum + "\t");
                if (newNum < 0) {
                    if (pointer != 0) {
                        count++;
                    }
                    pointer = 100 + newNum;
                    while (pointer < 0) {
                        pointer = 100 + pointer;
                        count++;
                    }
                    if (pointer == 0) {
                        count++;
                    }
                } else {
                    if (newNum == 0) {
                        count++;
                    }
                    pointer = newNum;
                }
                System.out.print("Final to: " + pointer + "\t");
            } else if (direction == 'R') {
                int newNum = pointer + rotation;
                System.out.print("Rotated to: " + newNum + "\t");
                if (newNum > 99) {
                    int rounds = newNum / 100;
                    count += rounds;
                    pointer = newNum % 100;
                } else {
                    pointer = newNum;
                }
                System.out.print("Final to: " + pointer + "\t");
            }
            System.out.println("\nTotal count: " + count);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(count);
}
