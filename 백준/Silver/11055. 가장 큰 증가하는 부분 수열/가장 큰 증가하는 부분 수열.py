n = int(input())
arr = list(map(int, input().split()))
dp = [0 for _ in range(len(arr))]
dp[0] = arr[0]
for i in range(n):
    for j in range(i):
        if arr[i]> arr[j]:
            dp[i] = max(dp[i], dp[j] + arr[i])
        else:
            dp[i] = max(dp[i], arr[i])

print(max(dp))