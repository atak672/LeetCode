// https://leetcode.com/problems/rotate-string

class RotateStringSolution {
    public boolean rotateString(String s, String goal) {
        if (goal.length() == 0){
            return true; 
        }
        else if (goal.length() != s.length()){
            return false; 
        }

        s = s + s; 

        int[] lps = new int[goal.length()]; 
        Arrays.fill(lps, 0);
        int prevLPS = 0;
        int k = 1; 

        while (k < goal.length()){
            if (goal.charAt(k) == goal.charAt(prevLPS)){
                lps[k] = prevLPS + 1; 
                prevLPS += 1; 
                k += 1; 
            }
            else{
                if (prevLPS == 0){
                    lps[k] = 0; 
                    k += 1; 
                    //prevLPS alr at beginning of array (index 0)
                }
                else {
                    prevLPS = lps[prevLPS - 1]; //Set to value at prev of prevLPS value 

                }
            }
        }

        int i = 0;  //Index for s
        int j = 0; //index for goal
        while (i < s.length()){
            if (s.charAt(i) == goal.charAt(j)){   //Characters at respective positions equal
                i += 1; 
                j += 1; 
            }
            else{   //Character at respective positions not equal -- this is to not reset pointer as in brute force method
                if (j == 0){
                    i += 1; 
                }
                else{
                    j = lps[j - 1]; //How many characters were matching 
                }
            }
            if (j == goal.length()){
                return true; 
            }
        }
        return false; 

    }
}