// https://leetcode.com/problems/isomorphic-strings

class IsomorphicStringsSolution {

    public void transform(int[] x, String y){
        Map<Character, Integer> main = new HashMap<>();

        for(int i = 0; i < y.length(); i++){
            main.putIfAbsent(y.charAt(i), i);
            x[i] = main.get(y.charAt(i));
        }

    }
    public boolean isIsomorphic(String s, String t) {
        int[] s_array = new int[s.length()];
        int[] t_array = new int[t.length()];
        transform(s_array, s);
        transform(t_array, t);

        return Arrays.equals(s_array, t_array);
    }
}