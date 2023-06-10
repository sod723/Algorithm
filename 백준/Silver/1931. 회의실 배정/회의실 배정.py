N = int(input())
graph = [[] for _ in range(N)]

for i in range(N):
    a,b = map(int, input().split())
    graph[i].append(a)
    graph[i].append(b)

graph.sort(key= lambda x:(x[1], x[0]))
cnt = 1
end = graph[0][1]
for i in range(1,N):
    if graph[i][0] >= end:
        cnt+=1
        end = graph[i][1]
print(cnt)
