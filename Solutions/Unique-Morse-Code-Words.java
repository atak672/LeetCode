// https://leetcode.com/problems/unique-morse-code-words

class UniqueMorseCodeWordsSolution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        
        Map<Character, String> morseDict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            morseDict.put((char) ('a' + i), morseCodes[i]);
        }
        
        Set<String> transformations = new HashSet<>();
        for (String word : words) {
            StringBuilder transformation = new StringBuilder();
            for (char letter : word.toCharArray()) {
                transformation.append(morseDict.get(letter));
            }
            transformations.add(transformation.toString());
        }
        
        return transformations.size();
    }
}