from collections import deque
def solution(prices):
    
    answer = []
    prices = deque(prices)
    for _ in range(len(prices)-1):
        q = prices.popleft()
        cnt = 0
        for price in prices:
            if q>price:
                cnt+=1
                break
            cnt+=1
        answer.append(cnt)
    answer.append(0)
            
    return answer