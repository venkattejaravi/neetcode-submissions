class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowSet = defaultdict(set)
        colSet = defaultdict(set)
        gridSet = defaultdict(set)
	
        for row in range(0, len(board)):
            for col in range(0, len(board[0])):
                val = board[row][col]
                if val == '.':
                    continue
                if val in rowSet[row]:
                    print(row, col, val)
                    # print('val' , val)
                    print(12)
                    return False
                else:
                    rowSet[row].add(val)

                
                if val in colSet[col]:
                    print(19)
                    return False
                else:
                    colSet[col].add(val)


                grid = (row//3, col//3)
                
                if val in gridSet[grid]:
                    print(28)
                    return False
                else:
                    gridSet[grid].add(val)

                
        return True

