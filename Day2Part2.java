public static void main() {

    String input = "96952600-96977512,6599102-6745632,32748217-32835067,561562-594935,3434310838-3434398545,150-257,864469-909426,677627997-677711085,85-120,2-19,3081-5416,34-77,35837999-36004545,598895-706186,491462157-491543875,5568703-5723454,6262530705-6262670240,8849400-8930122,385535-477512,730193-852501,577-1317,69628781-69809331,2271285646-2271342060,282-487,1716-2824,967913879-967997665,22-33,5722-11418,162057-325173,6666660033-6666677850,67640049-67720478,355185-381658,101543-146174,24562-55394,59942-93946,967864-1031782";

    String[] ranges = input.split(",");
    Long invalid = 0L;

    for (int i = 0; i < ranges.length; i++) {
        String[] nums = ranges[i].split("-");
        Long start = Long.valueOf(nums[0]);
        Long end = Long.valueOf(nums[1]);

        Long num = start;
        while (num <= end) {
            String str = Long.toString(num);

            int limit = str.length() / 2;

            if (num < 10) {
                num++;
                continue;
            }

            Set<Long> dupes = new HashSet<>();

            for (int j = 1; j <= limit; j++) {
                // take the first j nums
                String compare = str.substring(0, j);

                // then get all the subs and compares
                boolean haveDiff = false;
                int nextIdx = j;
                while (nextIdx < str.length()) {
                    if (nextIdx + j > str.length()) {
                        haveDiff = true;
                        break;
                    }
                    String substr = str.substring(nextIdx, nextIdx + j);
                    if (!compare.equals(substr)) {
                        haveDiff = true;
                        break;
                    }
                    nextIdx += j;
                }
                if (!haveDiff) {
                    if (!dupes.contains(num)) {
                        System.out.println("invalid: " + num);
                        invalid += num;
                        dupes.add(num);
                    }
                }
            }
            num++;
        }
    }
    System.out.println(invalid);
}
