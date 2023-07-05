def solution(array, commands):
    answer = []
    
    for c in commands:
        arr = []
        for i in range(c[0] - 1, c[1]):
            arr.append(array[i])
        arr.sort()
        answer.append(arr[c[2]-1])

    return answer