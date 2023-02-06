from collections import Counter
n = int(input())
list1 = []
mid , range1= 0,0

for i in range(n):
    list1.append(int(input()))

list1.sort()
mid = list1[int((n-1)/2)]

list2 = Counter(list1).most_common()


range1 = list1[-1] - list1[0]


print(round(sum(list1)/n))
print(mid)
if len(list2) > 1:
    if list2[0][1] == list2[1][1]:
        print(list2[1][0])
    else:
        print(list2[0][0])
else:
    print(list2[0][0])
print(range1)