class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_set = collections.defaultdict(set)
        col_set = collections.defaultdict(set)
        square = collections.defaultdict(set)


        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col] == '.':
                    continue
                if board[row][col] in row_set[row] or board[row][col] in col_set[col] or board[row][col] in square[(row//3, col//3)]:
                    return False
                row_set[row].add(board[row][col])
                col_set[col].add(board[row][col])
                square[(row//3, col//3)].add(board[row][col])
        return True