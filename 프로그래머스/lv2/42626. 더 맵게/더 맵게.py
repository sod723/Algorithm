import heapq as h
def solution(S, K):
    answer = 0
    S.sort()
    
    while S[0] < K:
        if len(S)>1:
            h.heappush(S, h.heappop(S) + h.heappop(S)*2)
            answer +=1
        else:
            answer = -1
            break
    return answer
    
    
