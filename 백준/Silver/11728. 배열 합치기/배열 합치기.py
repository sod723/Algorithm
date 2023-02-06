n,m = map(int, input().split())
alist = list(map(int, input().split()))
blist = list(map(int, input().split()))
clist = alist + blist
clist.sort()
for i in range(n+m):
    print(clist[i],end=" ")
    