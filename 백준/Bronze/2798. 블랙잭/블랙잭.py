n,m = map(int, input().split())
card = list(map(int, input().split()))
card_sum = 0
res= 0
card.reverse()
for i in range(n-2): 
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            card_sum = card[i] + card[j] + card[k]
            if card_sum <=m:
                res= max(res, card_sum)
print(res)
