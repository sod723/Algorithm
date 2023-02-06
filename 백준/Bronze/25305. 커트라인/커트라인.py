a,b = map(int, input().split())
n = list(map(int,input().split()))
n.sort(reverse=True)
print(n[b-1])