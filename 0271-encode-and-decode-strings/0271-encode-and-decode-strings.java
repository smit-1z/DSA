public class Codec {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(s.substring(i, j));
            i = j + 1;
            j = i + len;
            res.add(s.substring(i, j));
            i=j;
        }

        return res;
    }
}