def solution(n, lost, reserve):
    answer = 0
    
    temp_lost = set(lost) - set(reserve)
    temp_reserve = set(reserve) - set(lost)
    
    lost = list(temp_lost)
    reserve = list(temp_reserve)
    
    for student in reserve:
        if student - 1 in lost:
            lost.remove(student - 1)
        elif student + 1 in lost:
            lost.remove(student + 1)
            
    answer = n - len(lost)
    return answer
