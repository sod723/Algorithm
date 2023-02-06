N, M= map(int,input().split())
num_list=list(map(int,input().split()))
start, end, sum = 0,0,0
min_=100001
while True:
    if sum>=M:
        sum -= num_list[start]
        start +=1
        min_=min(min_,end-start+1)
    else:
        if end==N:
            break
        else:
            sum += num_list[end]
            end += 1
if min_ == 100001:
    min_= 0
print(min_)