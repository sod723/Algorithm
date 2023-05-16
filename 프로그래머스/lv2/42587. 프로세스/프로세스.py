def solution(priorities, location):
    answer = 0

    num = priorities[location]
    sorted_list = sorted(priorities, reverse=True)
    while True:
        for i in range(len(priorities)):
            if sorted_list[0] == priorities[i]:
                sorted_list.pop(0)
                answer += 1
                if i == location:
                    return answer
