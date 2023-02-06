def findnum(n):
    cnt = 0
    if n<100:
        cnt=n
    else:
        cnt=99
        for i in range(100,n+1):
            n = list(map(int,str(i)))
            if n[0]-n[1] == n[1]-n[2]:            
                cnt+=1
    return cnt
a = int(input())
print(findnum(a))
