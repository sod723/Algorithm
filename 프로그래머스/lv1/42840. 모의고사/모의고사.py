def solution(answers):
    answer = []
    arr1 = [1,2,3,4,5]
    arr2 = [2,1,2,3,2,4,2,5]
    arr3 = [3,3,1,1,2,2,4,4,5,5]
    a,b,c = 0,0,0
    length = len(answers)
    for i in range(length):
        if answers[i] == arr1[i%5]:
            a +=1
        if answers[i] == arr2[i%8]:
            b +=1
        if answers[i] == arr3[i%10]:
            c +=1
    arr = [a,b,c]
    max_num = max(arr)
    for i in range(len(arr)):
        if arr[i] == max_num:
            answer.append(i+1)

    return answer