def solution(board):
    answer = 1

    first, last = 0, 0
    for i in range(3):
        for j in range(3):
            if board[i][j] == 'O':
                first += 1
            if board[i][j] == 'X':
                last += 1
    
    if last > first or abs(last-first) > 1: return 0
    
    def win(mark):
        for i in range(3):
            for j in range(3):
                if board[0][0] == mark:
                    if board[0][1] == mark and board[0][2] == mark: return True
                    if board[1][1] == mark and board[2][2] == mark: return True
                    if board[1][0] == mark and board[2][0] == mark: return True
                if board[0][1] == mark:
                    if board[1][1] == mark and board[2][1] == mark: return True
                if board[0][2] == mark:
                    if board[1][1] == mark and board[2][0] == mark: return True
                    if board[1][2] == mark and board[2][2] == mark: return True
                if board[1][0] == mark:
                    if board[1][1] == mark and board[1][2] == mark: return True
                if board[2][0] == mark:
                    if board[2][1] == mark and board[2][2] == mark: return True
        return False
    
    if win('O') and win('X'): return 0
    if win('O') and first == last : return 0
    if win('X') and first != last : return 0
    
    
            
    return answer