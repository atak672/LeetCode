// https://leetcode.com/problems/battleships-in-a-board

class BattleshipsInABoardSolution {
    public int countBattleships(char[][] board) {
        int numBattleships = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    numBattleships++;
                    sink(board, i, j);
                }
            }
        }
        return numBattleships;
    }

    private void sink(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        sink(board, i + 1, j);
        sink(board, i - 1, j);
        sink(board, i, j + 1);
        sink(board, i, j - 1);
    }
}