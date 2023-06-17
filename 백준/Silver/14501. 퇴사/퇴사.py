N = int(input())
T = [0] * (N+1)
P = [0] * (N+1)
D = [0] * (N+2)
for i in range(1,N+1):
    a, b = map(int, input().split())
    T[i] = a
    P[i] = b

for i in range(N, 0, -1):
    if i+T[i] > N+1:
        D[i] = D[i+1]
    else:
        D[i] = max(D[i+1], P[i]+D[i+T[i]])
print(D[1])