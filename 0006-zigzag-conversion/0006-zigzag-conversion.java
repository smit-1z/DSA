class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] arr = new StringBuilder[numRows];


        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }

        int rowIndex = 0;
        boolean goingDown = false;
        
        for(char c:s.toCharArray()){
            arr[rowIndex].append(c);

            if(rowIndex == 0 || rowIndex == numRows-1){
                goingDown = !goingDown;
            }

            rowIndex += goingDown ? 1 : -1;

        }

        StringBuffer res = new StringBuffer();

        for (StringBuilder str : arr) {
            res.append(str);
        }

        return res.toString();
    }
}