class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;
        StringBuilder[] arr = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }

        int index = 0;
        int n = s.length();
        while (index < n) {
            for (int i = 0; i < numRows && index < n; i++) {
                arr[i].append(s.charAt(index++));
            }

            for (int i = numRows - 2; i > 0 && index < n; i--) {
                arr[i].append(s.charAt(index++));
            }
        }
        StringBuilder res = new StringBuilder();

        for (StringBuilder str : arr) {
            res.append(str);
        }

        return res.toString();
    }
}