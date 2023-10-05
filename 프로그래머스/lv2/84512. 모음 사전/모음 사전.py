from itertools import product

def solution(word):
    answer = 0
    alpha = ['A', 'E', 'I', 'O', 'U']
    words = []
    for i in range(1, 6):
        for c in product(alpha, repeat = i):
            words.append("".join(list(c)))
    words.sort()
    print(words)
    answer = words.index(word) + 1
    return answer