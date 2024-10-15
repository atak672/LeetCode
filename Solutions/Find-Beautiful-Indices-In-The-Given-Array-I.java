// https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i

class FindBeautifulIndicesInTheGivenArrayISolution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> L1 = new ArrayList<>();
        List<Integer> L2 = new ArrayList<>(); 
        List<Integer> ret = new ArrayList<>();

        isBeautiful(s, a, L1);
        isBeautiful(s, b, L2);

        // Map<Integer, Integer> map = new HashMap<>(); 
        // for (int i : L1){
        //     int val = k + i;
        //     map.put(val, i);
        // }

        // for (int j : L2){
        //     if (map.keySet().contains(j)){
        //         ret.add(map.get(j));
        //     }
        // }

        for (int i : L1){
            for (int j : L2){
                if (Math.abs(j - i) <= k){
                    ret.add(i);
                    break;
                }
            }
        }
        return ret;


        
    }

    private void isBeautiful(String s, String other, List<Integer> l){
        int lenOther = other.length(); 
        for (int i = 0; i <= (s.length() - lenOther); i++){
            String substr = s.substring(i, i + lenOther);
            if (substr.equals(other)) {
                l.add(i); 
            }
        }
        return;
    }
}