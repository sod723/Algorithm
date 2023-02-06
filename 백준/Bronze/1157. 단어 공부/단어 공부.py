a = input().upper()
b = list(set(a))
t = []
for i in set(a):
    t.append(a.count(i))

if t.count(max(t)) > 1:
    print("?")
else:
    max_index = t.index(max(t)) 
    print(b[max_index])


