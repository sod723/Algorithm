n = int(input())
li = []
for i in range(n):
    li.append(list(map(int,input().split())))

li.sort(key=lambda x: (x[0],x[1]))

for i in li:
    print(i[0],i[1])
