n, k = map(int, input().split())
ans = 0
dp = [[0 for _ in range(k+1)] for _ in range(n+1)]
for i in range(n+1):
    dp[i][1] = 1

for i in range(0, n+1):
    for j in range(1, k+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1]
ans = dp[n][k]
print(ans%1000000000)
