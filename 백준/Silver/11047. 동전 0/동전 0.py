n,k = map(int, input().split())
coin = []
for i in range(n):
    a = int(input())
    coin.append(a)
coin.reverse()
cnt = 0
for i in range(n):    
     if k//coin[i]<0:
         i +=1
     elif k//coin[i]>0:
         cnt+= k//coin[i]
         k=k-(k//coin[i])*coin[i]
print(cnt)

