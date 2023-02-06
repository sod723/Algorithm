n = int(input())

for i in range(n):
    score=0
    score_sum=0
    t = str(input())

    for j in t:
        if j == "O":
            score +=1
            score_sum += score
        else:
            score=0
    print(score_sum)