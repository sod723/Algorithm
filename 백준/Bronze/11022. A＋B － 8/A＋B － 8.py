a = int(input())
for i in range(a):
    A,B = map(int, input().split())
    sum = A+B
    print("Case #%d: %d + %d = %d"%(i+1, A, B, sum ))