// https://leetcode.com/problems/lemonade-change

class LemonadeChangeSolution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> counts = new HashMap<>(); 
        counts.put(5, 0);
        counts.put(10, 0);
        counts.put(20, 0);


        for (int i: bills){
            System.out.print(i);
            if (i == 5){
                counts.put(i, counts.get(i) + 1);
            }
            else if (i == 10){
                if (counts.get(5) > 0){
                    counts.put(i, counts.get(i) + 1);
                    counts.put(5, counts.get(5) - 1);
                }
                else{
                    return false;
                }
            }
            else if (i == 20){
                if (counts.get(5) > 0 && counts.get(10) > 0){
                    counts.put(5, counts.get(5) - 1);
                    counts.put(10, counts.get(10) - 1);
                }
                else if (counts.get(5) >= 3){
                    counts.put(5, counts.get(5) - 3);
                }
                else{
                    return false; 
                }
            }
        }

        return true; 
    }
}