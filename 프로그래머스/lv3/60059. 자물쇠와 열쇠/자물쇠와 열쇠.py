def rotate(matrix):
    return [list(row) for row in zip(*matrix[::-1])]

def set(N, matrix):
    arr = [[0 for _ in range(3*N)] for _ in range(3*N)]
    for i in range(N):
        for j in range(N):
            arr[N+i][N+j] = matrix[i][j]
    return arr

def solution(key, lock):
    answer = False
    M = len(key)
    N = len(lock)
    arr = set(N, lock)

    for i in range(4):
        key = rotate(key)
        for j in range(N*2):
            for k in range(N*2):
                #열쇠 끼기
                for a in range(M):
                    for b in range(M):
                        arr[j+a][k+b] += key[a][b]

                if all(arr[N+x][N+y] == 1 for x in range(N) for y in range(N)):
                    return True
                else:
                    arr = set(N, lock)

    return answer