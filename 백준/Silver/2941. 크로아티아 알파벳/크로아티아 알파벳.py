alp = ['c=','c-','dz=','d-','lj','nj','s=','z=']
n = input()
cnt = 0
for i in alp:
    n=n.replace(i,"*")
print(len(n))