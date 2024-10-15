// https://leetcode.com/problems/encode-and-decode-strings

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        // Put length of word at the beginning of each one that sets a loop on how many iterations/substrings to use
        // Always guaranteed to be (lengh)(word)
        StringBuilder encoded = new StringBuilder();

        for (String s : strs){
            int length = s.length();
            encoded.append(length);
            encoded.append("#");
            encoded.append(s);
        }

        return encoded.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String> ret = new ArrayList<>();
        int i = 0; 
        int n = s.length();

        while (i < n){
            int j = i; 
            while (s.charAt(j) != '#'){
                j += 1; 
            }
            int len = Integer.valueOf(s.substring(i, j));
            i = j + len + 1; 
            ret.add(s.substring(j + 1, i));
        }

        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));