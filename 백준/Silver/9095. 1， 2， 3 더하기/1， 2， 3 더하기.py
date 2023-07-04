n = int(input())
for i in range(n):
    num = int(input())
    dp = [0] * (num+5)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for j in range(4, num+1):
        dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]) % 10007
    print(dp[num]%10007)
