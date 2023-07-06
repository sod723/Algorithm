t = int(input())
for _ in range(t):
    n = int(input())
    dp =[0]+ [1, 1, 1, 2, 2, 3, 4] + [0 for _ in range(n)]

    if n>=8:
        for i in range(8, n+1):
            dp[i] = dp[i-1] + dp[i-5]
    print(dp[n])