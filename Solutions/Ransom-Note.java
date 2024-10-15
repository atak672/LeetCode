// https://leetcode.com/problems/ransom-note

class RansomNoteSolution {
    public boolean canConstruct(String ransomNote, String magazine) {


        // Anagramish --> Need final hashmap to be 0 or negative 


        int[] counts = new int[26];

        for (char ch : ransomNote.toCharArray()){
            counts[ch - 97] += 1; 
        }

        for (char ch : magazine.toCharArray()){
            counts[ch - 97] -= 1; 
        }

        for (int num : counts){
            if (num > 0){
                return false; 
            }
        }
        return true; 
















        // HashMap<Character, Integer> counts = new HashMap<>(); 

        // for (char ch : ransomNote.toCharArray()){
        //     counts.putIfAbsent(ch, 0); 
        //     counts.put(ch, counts.get(ch) + 1);
        // }
        
        // for (char ch : magazine.toCharArray()){
        //     counts.putIfAbsent(ch, 0); 
        //     counts.put(ch, counts.get(ch) - 1);
        // }

        // for (int num : counts.values()){
        //     if (num > 0){
        //         return false; 
        //     }
        // }

        // return true; 
    }
}