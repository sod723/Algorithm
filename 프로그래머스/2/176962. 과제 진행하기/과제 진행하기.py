def solution(plans):
    answer = []
    for i in range(len(plans)):
        plans[i][1] = int(plans[i][1][:2]) * 60 + int(plans[i][1][3:])
        plans[i][2] = int(plans[i][2])
    plans.sort(key = lambda x: x[1])
    print(plans)
    stack = []
    for i in range(len(plans)):
        if i == len(plans)-1:
            stack.append(plans[i])
            break
            
            
        if (plans[i][1]) + (plans[i][2]) <= (plans[i+1][1]):
            answer.append(plans[i][0])
            tmp = plans[i+1][1] - (plans[i][1]+plans[i][2])
            while tmp !=0 and stack:
                a, b, c = stack.pop()
                if tmp >= c:
                    answer.append(a)
                    tmp -= c
                else:
                    stack.append([a, b, c-tmp])
                    tmp = 0
        else:
            plans[i][2] = plans[i][2] - plans[i+1][1] + plans[i][1]
            stack.append(plans[i])

            
    for _ in range(len(stack)):
        tmp = stack.pop()
        answer.append(tmp[0])
            
    return answer