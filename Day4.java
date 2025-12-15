public static void main() {
    List<List<String>> list = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("Day4Input.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            List<String> lineList = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                lineList.add(String.valueOf(line.charAt(i)));
            }
            list.add(lineList);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    int height = list.size();
    int width = list.get(0).size();

    int counter = 0;

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            String character = list.get(i).get(j);
            if (character.equals("@")) {
                if (checkAdjacents(i, j, list)) {
                    counter++;
                }
            }
        }
    }

    System.out.println(counter);
}

public static boolean checkAdjacents(int x, int y, List<List<String>> list) {
    int total = 0;
    // if not top row, check top
    if (x != 0) {
        String a = list.get(x - 1).get(y);
        if (a.equals("@")) {
            total++;
        }
        // if not top row and not most left, check top left
        if (y != 0) {
            String b = list.get(x - 1).get(y - 1);
            if (b.equals("@")) {
                total++;
            }
        }
        // if not top row and not most right, check top right
        if (y != list.get(0).size() - 1) {
            String b = list.get(x - 1).get(y + 1);
            if (b.equals("@")) {
                total++;
            }
        }
    }

    // if not most left, check left
    if (y != 0) {
        String b = list.get(x).get(y - 1);
        if (b.equals("@")) {
            total++;
        }
    }

    // if not most right, check right
    if (y != list.get(0).size() - 1) {
        String b = list.get(x).get(y + 1);
        if (b.equals("@")) {
            total++;
        }
    }

    // if not bottom row, check bottom
    if (x != list.size() - 1) {
        String a = list.get(x + 1).get(y);
        if (a.equals("@")) {
            total++;
        }
        // if not bottom row and not most left, check bottom left
        if (y != 0) {
            String b = list.get(x + 1).get(y - 1);
            if (b.equals("@")) {
                total++;
            }
        }
        // if not bottom row and not most right, check bottom right
        if (y != list.get(0).size() - 1) {
            String b = list.get(x + 1).get(y + 1);
            if (b.equals("@")) {
                total++;
            }
        }
    }

    return total < 4;
}
