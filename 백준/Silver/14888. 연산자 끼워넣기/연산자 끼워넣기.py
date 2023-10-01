N = int(input())
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))
minAns = float('Inf')
maxAns = float('-Inf')

def backTracking(idx, sum):
    global minAns
    global maxAns
    if idx == N - 1:
        if minAns > sum: minAns = sum
        if maxAns < sum: maxAns = sum
        return

    for i in range(4):
        tmp = sum
        if arr2[i] == 0: continue
        if i == 0:
            sum += arr1[idx + 1]
        elif i == 1:
            sum -= arr1[idx + 1]
        elif i == 2:
            sum *= arr1[idx + 1]
        else:
            sum = int(sum / arr1[idx + 1])

        arr2[i] -= 1
        backTracking(idx+1, sum)
        arr2[i] += 1
        sum = tmp

backTracking(0, arr1[0])
print(maxAns)
print(minAns)