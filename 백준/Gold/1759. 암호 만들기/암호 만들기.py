L, C = map(int, input().split())
arr = list(map(str, input().split()))
arr.sort()
vowel = ['a', 'e', 'i', 'o', 'u']
ans = []

def backTracking(idx, cnt):
    if cnt == L:
        v, c = 0, 0
        for i in range(L):
            if ans[i] in vowel:
                v += 1
            else:
                c += 1
        if v >=1 and c >=2:
            print("".join(ans))
        return

    for i in range(idx, C):
        ans.append(arr[i])
        backTracking(i+1, cnt+1)
        ans.pop()

backTracking(0, 0)
