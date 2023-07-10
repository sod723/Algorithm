from itertools import permutations

def solution(numbers):
    answer = 0
    
    num = []
    for i in range(1, len(numbers)+1) :
        num.append(list(set(map(''.join, permutations(numbers, i)))))
    per = list(set(map(int, set(sum(num, [])))))
    
    for p in per :
        if isPrime(p):
            answer += 1

    return answer

def isPrime(number):
    if number<2:
        return False
    for i in range (2,number):
        if number % i == 0:
            return False
    return True