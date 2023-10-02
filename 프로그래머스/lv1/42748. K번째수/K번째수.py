def solution(array, commands):
    answer = []
    for cmd in commands:
        tmp = sorted(array[cmd[0]-1:cmd[1]])
        answer.append(tmp[cmd[2]-1])
    return answer
