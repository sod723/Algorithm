K, N = map(int, input().split())
arr = []

for i in range(K):
    arr.append(int(input()))
start, end = 1, max(arr)

while start <= end:
    cnt = 0
    mid = (start + end) // 2
    for i in range(K):
        cnt += arr[i] // mid
    if cnt < N:
        end = mid - 1
    else:
        start = mid + 1
print(end)