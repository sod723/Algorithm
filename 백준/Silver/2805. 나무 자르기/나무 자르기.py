n, m = map(int, input().split())
arr = list(map(int, input().split()))

low = 0
high = max(arr)
ans = 0
while low<=high:
    mid = (low+high) // 2
    sum = 0
    for tree in arr:
        if tree>mid:
            sum += tree - mid

    if sum < m:
        high = mid -1
    else:
        ans = mid
        low = mid + 1

print(ans)