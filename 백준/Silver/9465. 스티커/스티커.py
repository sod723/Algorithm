T = int(input())
for _ in range(T):
    N = int(input())

    graph = []
    dp = [[0 for _ in range(N+1)] for _ in range(2)]
    for _ in range(2):
        graph.append(list(map(int, input().split())))

    dp[0][0] = graph[0][0]
    dp[1][0] = graph[1][0]

    for i in range(1, N):
        dp[0][i] = graph[0][i] + max(dp[1][i-1], dp[1][i-2] if i > 1 else 0)
        dp[1][i] = graph[1][i] + max(dp[0][i-1], dp[0][i-2] if i > 1 else 0)

    print(max(dp[0][N-1], dp[1][N-1]))

