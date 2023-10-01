def game(num):
    arr = [list(map(str, input())) for _ in range(num)]
    ans = set(range(num))

    for i in range(len(arr[0])):
    #num개의 로봇이 각 라운드 마다 이기고 지고 판별.
    #진 로봇 바로 아웃
    #승자 없으면 0
    #승자는 i+1
        tmp = [arr[j][i] for j in ans]
        unique = list(set(tmp))


        if len(unique) == 3 or len(unique) == 1:
            continue
        else:
            if 'R' in unique and 'S' in unique:
                ans = {j for j in ans if arr[j][i] == 'R'}
            elif 'S' in unique and 'P' in unique:
                ans = {j for j in ans if arr[j][i] == 'S'}
            elif 'P' in unique and 'R' in unique:
                ans = {j for j in ans if arr[j][i] == 'P'}

        if len(ans) == 1:
            break

    if len(ans) == 1:
        print(list(ans)[0] + 1)
    else:
        print(0)

T = int(input())
for _ in range(T):
    N = int(input())
    game(N)