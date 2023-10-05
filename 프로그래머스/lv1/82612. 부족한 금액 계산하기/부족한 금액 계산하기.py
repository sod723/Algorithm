def solution(price, money, count):
    answer = -1
    tmp = sum([i for i in range(count+1)])
    if money >= price*tmp:
        answer = 0
    else:
        answer = tmp*price -money
    return answer