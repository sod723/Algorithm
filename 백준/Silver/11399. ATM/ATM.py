n = int(input())
time = list(map(int, input().split()))
time.sort()
time_sum = 0
for i in range(n):
    time_sum += time[i]*(n-i)
print(time_sum)
