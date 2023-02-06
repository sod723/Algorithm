n = int(input())
for i in range(n):
    num = list(map(int, input().split()))
    score_sum = sum(num[1:])
    avg = score_sum/num[0]
    cnt = 0
    for j in num[1:]:
        if j>avg:
            cnt +=1
            #퍼센트증가
    per = cnt/num[0]*100
    print("{:.3f}%".format(per))        

