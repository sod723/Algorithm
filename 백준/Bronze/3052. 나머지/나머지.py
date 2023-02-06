num_list = []

for i in range(10):
    N = int(input())
    num_list.append(N%42)
print(len(set(num_list)))
