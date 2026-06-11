class Solution {
    public boolean exist(char[][] board, String word) {
        // do backtracking for each[row][col] (We can expect the string to be found not only at 0,0)
        // do backtracking (up, down, left and right)passing index + 1 and 
        // inside the backtracking track the progress with variable index.
        // if this index == word.length() return true;
        // if the character at board[row][col] != word.charAt(index) return false;

        // do backtracking for each[row][col] (We can expect the string to be found not only at 0,0)
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean found = backTracking(0, i, j, board, word);
                if(found) return true;        
            }
        }
        return false;
    }

    public boolean backTracking(int index, int row, int col, char[][] board, String word) {
        if(index == word.length()) return true;

        // false condition
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) return false;

        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = backTracking(index + 1, row , col + 1, board, word) ||
                        backTracking(index + 1, row , col - 1, board, word) ||
                        backTracking(index + 1, row + 1 , col, board, word) ||
                        backTracking(index + 1, row - 1, col, board, word);
        board[row][col] = temp;

        return found;
    }
}
