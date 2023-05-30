N, M = map(int, input().split())
arr = list(map(int, input().split()))
start = max(arr)
end = sum(arr)

while start <= end:
    mid = (start + end) // 2
    sum = 0
    cnt = 0
    for i in range(N):
        if sum + arr[i] > mid:  # 강의 추가 용량초과
            cnt += 1
            sum = 0
        sum += arr[i]
    if sum !=0: #남은강의
        cnt+=1

    if cnt <= M:
        end = mid - 1
    else:
        start = mid + 1
print(start)