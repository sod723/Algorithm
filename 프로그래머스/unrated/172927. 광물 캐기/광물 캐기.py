def solution(picks, minerals):
    answer = int(1e9)
    
    def dfs(idx, piro):
        nonlocal answer
        if idx >= len(minerals) or sum(picks) == 0:
            answer = min(answer, piro)
            return
            
        for i in range(len(picks)):
            if picks[i]>0:
                tmp = 0
                picks[i] -= 1
                
                for j in range(idx, min(idx+5, len(minerals))):
                    if i == 0:
                        tmp += 1
                    elif i == 1:
                        if minerals[j] == 'diamond':
                            tmp += 5
                        else:
                            tmp += 1
                    else:
                        if minerals[j] == 'diamond':
                            tmp += 25
                        elif minerals[j] == 'iron':
                            tmp += 5
                        else:
                            tmp += 1
                dfs(idx+5, piro + tmp)
                picks[i] += 1
            
    dfs(0, 0)
    print(answer)
            
        
    return answer