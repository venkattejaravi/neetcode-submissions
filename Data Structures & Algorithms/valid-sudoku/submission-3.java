class Solution {
    public boolean isValidSudoku(char[][] board) {

        // {0, 9} -> {1, 2, 3, 4 --- 9}
        // {0, 9} -> {1, 9}
        // {(0,0), (0, 1), (0, 2)}
        HashMap<Integer, HashSet<Character>> rowSet = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colSet = new HashMap<>();
        HashMap<String, HashSet<Character>> squareSet = new HashMap<>();
        char val;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                val = board[row][col];
                if(val == '.'){
                    continue;
                }
                String sqrKey = String.valueOf(row/3) + ',' + String.valueOf(col/3);
                if(rowSet.computeIfAbsent(row, k -> new HashSet<>()).contains(val) || 
                   colSet.computeIfAbsent(col, k -> new HashSet<>()).contains(val) || 
                   squareSet.computeIfAbsent(sqrKey, k -> new HashSet<>()).contains(val)) {
                    return false;
                }

                rowSet.get(row).add(val);
                colSet.get(col).add(val);
                squareSet.get(sqrKey).add(val);
            }
        }
        return true;

    }
}
