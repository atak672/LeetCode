// https://leetcode.com/problems/repeated-dna-sequences

class RepeatedDnaSequencesSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        int left = 0; 
        int right = 9;
        Map<String, Integer> map = new HashMap<>();
        List<String> ret = new ArrayList<>();

        while (right < s.length()){
            String temp = s.substring(left, right + 1);
            map.putIfAbsent(temp, 0);
            map.put(temp, map.get(temp) + 1);
            right += 1; 
            left += 1; 
          

        }
        for (String str : map.keySet()){
            if (map.get(str) > 1){
                ret.add(str);
            }
        }
        return ret;
    }
}