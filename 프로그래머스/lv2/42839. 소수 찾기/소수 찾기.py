from itertools import permutations

def solution(numbers):
    answer = 0
    arr = set()  
    for i in range(1, len(numbers) + 1):
        for perm in permutations(numbers, i):
            arr.add(int(''.join(perm)))
    
    for num in arr:
        if isPrime(num):
            answer += 1
            
    return answer

def isPrime(num):
    if num < 2: return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True
