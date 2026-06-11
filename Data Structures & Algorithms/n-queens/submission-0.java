class Solution {
    List<List<String>> res = new ArrayList<>();
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        backTrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new ArrayList<>());
        return res;

    }

    public void backTrack(int row, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2, List<Integer> state) {
        if(row == n) {
            res.add(generateBoard(state));
            return;
        }

        for(int col = 0; col < n; col++) {
            if(cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) continue;

            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            state.add(col);

            backTrack(row + 1, cols, diag1, diag2, state);

            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
            state.remove(state.size() - 1);
        }
    }

    public List<String> generateBoard(List<Integer> state) {
        List<String> board = new ArrayList<>();

        for(int i = 0; i < n ; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[state.get(i)] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
