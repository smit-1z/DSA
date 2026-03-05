class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] str = s.toCharArray();
        int open = 0;

        for(int i=0;i<str.length;i++){
            int c = str[i];
            if(c == '('){
                open++;
            }else{
                if(c == ')'){
                    if(open <= 0){
                        str[i] = '0';
                    }else{
                        open--;
                    }
                }
            }
        }


       for(int i = str.length-1;i>=0;i--){
        if(str[i] == '(' && open>0){
            open--;
            str[i] = '0';
        }
       }
        StringBuilder res = new StringBuilder();

        for(char c :str){
            if(c !='0'){
                res.append(c);
            }
        }
        return res.toString();
    }
}