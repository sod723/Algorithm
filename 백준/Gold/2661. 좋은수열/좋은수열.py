N = int(input())
ans = []
def backTracking(idx):
    for i in range(1, idx//2+1):
        if ans[-i:] == ans[-2*i:-i]:
            return -1

    if idx >= N:
        print(''.join(ans))
        return 0

    for i in range(1,4):
        ans.append(str(i))
        if backTracking(idx+1) == 0:
            return 0
        ans.pop()

backTracking(0)