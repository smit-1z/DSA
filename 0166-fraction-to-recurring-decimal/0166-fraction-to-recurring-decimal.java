class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder res = new StringBuilder();

        if(numerator < 0 ^ denominator < 0){
            res.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long r = num % den;
        res.append(num/den);

        if(r == 0) return res.toString();

        res.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while(r!=0){
            if(map.containsKey(r)){
                res.insert(map.get(r), "(");
                res.append(")");
                break;
            }
                map.put(r, res.length());
                r *=10;
                res.append(r/den);
                r = r%den;
        }
        return res.toString();
    }
}