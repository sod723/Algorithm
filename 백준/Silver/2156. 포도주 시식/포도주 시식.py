N = int(input())
graph = []
for i in range(N):
    graph.append(int(input()))

dp = [0 for _ in range(N+3)]
if N>0: dp[0] = graph[0]
if N>1: dp[1] = dp[0] + graph[1]
if N>2: dp[2] = max(graph[2]+graph[0], graph[2] + graph[1], dp[1])
if N>3:
    for i in range(3, N):
        dp[i] =max( graph[i] + dp[i-2], graph[i] + graph[i-1] + dp[i-3], dp[i-1])
print(max(dp))