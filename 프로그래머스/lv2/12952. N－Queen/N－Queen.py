def solution(n):
    answer = 0
    graph = [-1] * n
    def is_valid(graph, row, col):
        for i in range(row):
            if graph[i] == col:
                return False
            if abs(graph[i]-col) == abs(i-row):
                return False
        return True

    
    def backtrack(graph, row):
        if row == n:
            nonlocal answer
            answer += 1
            return
        for col in range(n):
            if is_valid(graph, row, col):
                graph[row] = col
                backtrack(graph, row + 1)
    backtrack(graph, 0)
    return answer