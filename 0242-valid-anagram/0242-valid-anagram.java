class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] freqMap = new int[26];

        for(int i=0;i<s.length();i++){
            freqMap[s.charAt(i) - 'a']++;
            freqMap[t.charAt(i) - 'a']--;
        }

        for(int num : freqMap){
            if(num != 0){
                return false;
            }
        }

        return true;
    }
}