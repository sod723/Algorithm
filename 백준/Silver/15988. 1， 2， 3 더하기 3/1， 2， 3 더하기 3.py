T = int(input())

for i in range(T):
    n = int(input())
    dp = (n+5) * [0]
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    if n>3:
        for num in range(4, n+2):
            dp[num] = (dp[num-1] + dp[num-2] + dp[num-3])%1000000009
    print(dp[n])

