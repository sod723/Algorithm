h, m = map(int,input().split())

if m > 44:
    print(h, m-45)
elif h>=1 and m <= 44:
    print(h-1, 60-abs(m-45))
else:
    print(23, 60-abs(m-45))