// https://leetcode.com/problems/find-players-with-zero-or-one-losses

class FindPlayersWithZeroOrOneLossesSolution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> counts = new HashMap<>(); 

        for (int[] match : matches){
            counts.putIfAbsent(match[0], 0);
            counts.putIfAbsent(match[1], 0);
            counts.put(match[1], counts.get(match[1]) + 1);
        }

        List<Integer> noLosses = new ArrayList<>(); 
        List<Integer> oneLoss = new ArrayList<>(); 

        for (int key : counts.keySet()){
            int val = counts.get(key); 
            if (val == 0){
                noLosses.add(key);
            }
            else if (val == 1){
                oneLoss.add(key);
            }
        }
        Collections.sort(noLosses);
        Collections.sort(oneLoss);
        List<List<Integer>> ret = new ArrayList<>(); 
        ret.add(noLosses);
        ret.add(oneLoss); 
        return ret; 
        
    }
}