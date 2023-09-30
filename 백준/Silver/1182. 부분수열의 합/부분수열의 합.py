N, S = map(int, input().split())
arr = list(map(int, input().split()))
ans = 0

def solution(idx, sub):
    global ans
    if idx>= N:
        return
    sub += arr[idx]

    if sub == S:
        ans+= 1

    solution(idx+1, sub)
    solution(idx+1, sub-arr[idx])

solution(0,0)
print(ans)