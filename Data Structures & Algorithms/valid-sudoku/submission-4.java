class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Set datastructure
        // HashMap for row with (row) as key and Set as value
        // hashMap for col with (col) as key and Set as value
        // hashMap for squre key(r/3, c/3) and Set as Value
        // (1, 1) = (1/3, 1/ 3) => (0, 0)

        Map<Integer, Set<Character>> rowSet = new HashMap<>();
        Map<Integer, Set<Character>> colSet = new HashMap<>();
        Map<String, Set<Character>> squareSet = new HashMap<>();

        for(int row = 0; row < board.length; row ++){
            for(int col = 0; col < board[0].length; col ++){
                char val = board[row][col];
                if(val == '.'){
                    continue;
                }
                if(!rowSet.containsKey(row)) {
                    rowSet.put(row, new HashSet<>());
                }
                if(rowSet.get(row).contains(val)) return false;

                if(!colSet.containsKey(col)) {
                    colSet.put(col, new HashSet<>());
                }
                if(colSet.get(col).contains(val)) return false;

                String key = (char)(row / 3) + ":" + (char)(col / 3);
                if(!squareSet.containsKey(key)) {
                    squareSet.put(key, new HashSet<>());
                }
                if(squareSet.get(key).contains(val)) return false;

                rowSet.get(row).add(val);
                colSet.get(col).add(val);
                squareSet.get(key).add(val);

            }
        }
        return true;
    }
}
