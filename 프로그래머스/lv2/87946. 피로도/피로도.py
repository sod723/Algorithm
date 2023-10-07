def solution(k, dungeons):
    answer = 0
    visited = [False for _ in range(len(dungeons))]
    
    def dfs(k, depth):
        nonlocal answer
        if depth>answer:
            answer = depth
        for i in range(len(dungeons)):
            if k>= dungeons[i][0] and not visited[i]:
                visited[i] = True
                dfs(k-dungeons[i][1],depth + 1)
                visited[i] = False
    dfs(k, 0)
    
    return answer

