n,m = map(int, input().split())
tmplist = list(map(int, input().split()))
tmp = sum(tmplist[:m])
start, end, res = 0,0,tmp
for i in range(m,n):
    tmp += tmplist[i]-tmplist[i-m]
    res = max(res, tmp)
print(res)
