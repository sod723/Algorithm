n = int(input())
arr = list(map(int, input().split()))
m = int(input())

arr.sort()
start = 0
end = arr[-1]

while start<=end:
    sum = 0
    mid = (start + end) // 2
    for i in range(n):
        if arr[i] > mid: sum += mid
        else: sum += arr[i]


    if sum > m:
        end = mid-1
    else:
        start = mid+1

print(end)