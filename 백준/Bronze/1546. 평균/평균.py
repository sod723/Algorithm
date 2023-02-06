a = int(input())
b = list(map(int, input().split()))
b_max = max(b)
for i in range(a):
    b[i] = b[i]/b_max*100
avg = sum(b)/a
print("{:.2F}".format(avg))