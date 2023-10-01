arr1 = [list(map(int, input().split())) for _ in range(5)]
arr2 = [list(map(int, input().split())) for _ in range(5)]
bingo = 0
ans = 0


def check(arr):
    global bingo
    bingo = 0
    tmp = 0
    for i in range(5):
        if arr[i][i] == 0:
            tmp += 1
    if tmp == 5: bingo += 1

    tmp = 0
    for i in range(5):
        if arr[4 - i][i] == 0:
            tmp += 1
    if tmp == 5: bingo += 1

    for i in range(5):
        if sum(arr[i]) == 0:
            bingo += 1

    for i in range(5):
        tmp = 0
        for j in range(5):
            tmp += arr[j][i]
        if tmp == 0: bingo += 1


for a in range(5):
    for b in range(5):
        for i in range(5):
            for j in range(5):
                if arr1[i][j] == arr2[a][b]:
                    arr1[i][j] = 0
                    check(arr1)
                    ans += 1
        if bingo >= 3:
            break
    if bingo >= 3:
        break

print(ans)
