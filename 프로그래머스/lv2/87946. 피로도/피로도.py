answer = 0
visited = []
def dfs(k, dungeons, cnt):
    global answer, visited
    if cnt > answer:
        answer = cnt
    for i in range(len(dungeons)):
        if k >= dungeons[i][0] and not visited[i]:
            visited[i] = True
            dfs(k-dungeons[i][1], dungeons, cnt + 1)
            visited[i] = False
    
def solution(k, dungeons):
    global answer, visited
    visited = [False for _ in range(len(dungeons))]
    dfs(k, dungeons, 0)
    return answer