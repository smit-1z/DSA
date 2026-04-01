class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int required = tMap.size();
        int have = 0;

        int start = 0;
        int end = 0;
        int resLen = Integer.MAX_VALUE;
        int res[] = new int[2];
        while (end < s.length()) {
            char c = s.charAt(end);

            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && tMap.get(c).equals(sMap.get(c))) {
                have++;
            }

            while (have == required) {
                if (resLen > (end - start + 1)) {
                    resLen = end - start + 1;
                    res[0] = start;
                    res[1] = end;
                }
                char startChar = s.charAt(start);

                sMap.put(startChar, sMap.get(startChar) - 1);

                start++;
                if (tMap.containsKey(startChar) && sMap.get(startChar) < tMap.get(startChar)) {
                    have--;
                }
            }
            end++;
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}