'''
Created on Dec 23, 2014

@author: Chandra Kant
'''
class Solution:
    
    def rowCheck(self, board):
        for arr in board:
            mp = {};
            for item in arr:
                if item in mp and item != '.':
                    return False;
                else :
                    mp[item] = 1;
        return True;            
    
    def columnCheck(self, board):
        if len(board) == 0:
            return True;
        for col in range(len(board[0])):
            mp = {};
            for row in range(len(board)):
                if board[row][col] in mp and board[row][col] != '.':
                    return False;
                else :
                    mp[board[row][col]] = 1;
        return True;
   
    def checkInSubmatrix(self, board):
        row = 0; col = 0;
        for r in range(3):
            col = 0;
            for c in range(3):
                mp = {};
                for i in range(row, row + 3):
                    for j in range(col, col + 3):
                        if board[i][j] in mp and board[i][j] != '.':
                            return False;
                        else:
                            mp[board[i][j]] = 1;
                col += 3;
            row += 3;
        return True;     
    # @param board, a 9x9 2D array
    # @return a boolean
    def isValidSudoku(self, board):
        ans = True;
        ans = ans and self.rowCheck(board);
        ans = ans and self.columnCheck(board);
        ans = ans and self.checkInSubmatrix(board);
        return ans;        
if __name__ == '__main__':
    sol = Solution();
    #board = [[5,3,]]
    board = [   ['5', '3', '.', '.', '7', '.', '.', '.', '.'],
                ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
                ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
                ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
                ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
                ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
                ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
                ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
                ['.', '.', '.', '.', '8', '.', '.', '7', '9']
            ];
             
    print (sol.isValidSudoku(board));