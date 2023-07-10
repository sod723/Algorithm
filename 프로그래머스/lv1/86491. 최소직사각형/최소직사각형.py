def solution(sizes):
    answer = 0
    a , b = 0 , 0
    for card in sizes:
        card.sort()
        a = max(a, card[0])
        b = max(b, card[1])
    answer = a*b
    return answer