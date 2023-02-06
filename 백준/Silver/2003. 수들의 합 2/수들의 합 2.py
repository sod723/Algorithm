N, M= map(int,input().split())
num_list=list(map(int,input().split()))
res = 0
sum = 0
end = 0
for i in range(N):
    while sum<M and end<N:
        sum += num_list[end]
        end += 1
    if sum == M:
        res += 1
    sum -=num_list[i]
print(res)