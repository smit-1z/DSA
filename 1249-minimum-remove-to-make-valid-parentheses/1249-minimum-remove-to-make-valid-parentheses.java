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

        StringBuilder res = new StringBuilder();

       for(int i = str.length-1;i>=0;i--){
        char c = str[i];
        if(c == '(' && open>0){
            open--;
            continue;
        }

        if(c == '0'){
            continue;
        }

        res.append(c);
       }
        return res.reverse().toString();
    }
}