def solution(numbers):
    s = list(map(str, numbers))
    a = sorted(s, key=lambda x: x*3, reverse = 1)
    answer = str(int("".join(a)))
    
    return answer