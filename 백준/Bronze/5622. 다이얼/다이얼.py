n = input()
dial ={"ABC":3,"DEF":4,"GHI":5,"JKL":6,"MNO":7,"PQRS":8,"TUV":9,"WXYZ":10}
cnt =0
for i in n:
    for j in dial.keys():
        if str(i) in j:
            cnt += dial.get(j)
print(cnt)