// https://leetcode.com/problems/group-anagrams

class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Idea that I had -- use hashmap and alphabetization of String
        // Use key as alphabetized String, value is list of associated values 

        // Map to store anagram groups
        Map<String, List<String>> map = new HashMap<>(); 

        // Loop through each String -- instead of .sort or Arrays.sort -- count 
        // will be 26 letters, if 2 have the same counts i.e. 1002300444.... they r anagrams
        for (String s :strs){
            char[] counts = new char[26];
            for (char c : s.toCharArray()){
                counts[c - 'a'] += 1; 
            }

            String sorted = new String(counts);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}