class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 1;
        char maxFreqChar = s.charAt(0);

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            if (maxFreq < freqMap.get(c)) {
                maxFreq = freqMap.get(c);
                maxFreqChar = c;
            }
        }

        if(maxFreq > (s.length() + 1)/2){
            return "";
        }

        char[] res = new char[s.length()];
        
        int pos = 0;
        
        for(int i=0;i<maxFreq;i++){
            res[pos] = maxFreqChar;
            pos+=2;
        }

        freqMap.put(maxFreqChar, 0);

        for(char c:freqMap.keySet()){
            for(int i=0;i<freqMap.get(c);i++){
                if(pos >= s.length()){
                    pos = 1;
                }
                res[pos] = c;
                pos+=2;
            }
        }

        return new String(res);
    }
}