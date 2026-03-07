class Solution {
    class Transaction {
        String name;
        String place;
        int time;
        int amount;

        public Transaction(String line) {
            String[] arr = line.split(",");
            name = arr[0];
            time = Integer.parseInt(arr[1]);
            amount = Integer.parseInt(arr[2]);
            place = arr[3];
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        HashMap<String, List<Transaction>> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }

        for(String transaction : transactions){
            Transaction t = new Transaction(transaction);
            if(!isValid(t,map.get(t.name))){
                res.add(transaction);
            }
        }
        return res;
    }

    public boolean isValid(Transaction t, List<Transaction> transactions){
        if(t.amount > 1000){
            return false;
        }

        for(Transaction transaction : transactions){
            if(Math.abs(t.time - transaction.time) <= 60  && !t.place.equals(transaction.place)){
                return false;
            }
        }

        return true;
    }
}