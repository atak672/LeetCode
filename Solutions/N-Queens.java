// https://leetcode.com/problems/n-queens

class NQueensSolution {
    public List<List<String>> solveNQueens(int n) {

        boolean[] choices = new boolean[n];
        List<String> list = new ArrayList<>();
        List<List<Integer>> queenPos = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();
        backtrack(n, n, 0, list, ret, choices, queenPos);
        return ret;
    }

    public void backtrack(int n, int queens, int currRow, List<String> list, List<List<String>> ret, boolean[] choices, List<List<Integer>> queenPos){

        if (queens == 0){
            ret.add(new ArrayList<>(list));
            return;
        }
        else if (currRow >= n){
            return;
        }

        // Loop through possible decisions

        for (int i = 0; i < choices.length; i++){
            if (! choices[i] && noDiagonals(queenPos, currRow, i)){

                choices[i] = true;
                queenPos.add(Arrays.asList(currRow, i));
                list.add(markRow(i, n));
                backtrack(n, queens - 1, currRow + 1, list, ret, choices, queenPos);

                choices[i] = false;
                queenPos.remove(queenPos.size() - 1);
                list.remove(list.size() - 1);

            }
        }
        return;
    }

    public boolean noDiagonals(List<List<Integer>> queenPos, int currRow, int currCol){
        for (List<Integer> queen : queenPos){
            if (Math.abs(queen.get(0) - currRow) == Math.abs(queen.get(1) - currCol)){
                return false;
            }
        }
        return true;
    }

   
    public boolean inBounds(int x, int y, int n){
        if (x < 0 || x >= n){
            return false;
        }
        else if (y < 0 || y >= n){
            return false;
        }
        return true;
    }

    public String markRow(int col, int n){
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < col; i++){
            ret.append(".");
        }

        ret.append("Q");

        for (int i = col + 1; i < n; i++){
            ret.append(".");
        }

        return ret.toString();
    }
}