class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char maxChar = s.charAt(0);
        int maxCharCount = 0;
        int size = s.length();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) +1);
            if(maxCharCount < map.get(c)){
                maxChar = c;
                maxCharCount = map.get(c);
            }
        }
      
        if(maxCharCount > (size+1)/2){
            return "";
        }

        char[] res = new char[s.length()];
        int pos = 0;

        for(int i=0;i<maxCharCount;i++){
            res[pos] = maxChar;
            pos+=2;
        }

        map.put(maxChar,0);

        for(char c:map.keySet()){
            int freq = map.get(c);

            while(freq-- >0){
                if(pos >= size){
                    pos = 1;
                }
                res[pos] = c;
                pos+=2;
            }
        }

        return new String(res);
    }
}