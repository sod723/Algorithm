def solution(picks, minerals):
    global answer
    answer = int(1e9)
    dfs(picks, minerals, 0, 0)
    return answer

def dfs(picks, minerals, piro, idx):
    global answer
    
    if idx >= len(minerals) or sum(picks) == 0:
        answer = min(answer, piro)
        return
    
    for i in range(len(picks)):
        if picks[i] > 0:
            tmp = 0
            picks[i] -= 1
            for j in range(idx, min(idx+5, len(minerals))):
                if i == 0:
                    tmp += 1
                elif i == 1:
                    if minerals[j] == "diamond":
                        tmp += 5
                    else:
                        tmp += 1
                else:
                    if minerals[j] == "diamond":
                        tmp += 25
                    elif minerals[j] == "iron":
                        tmp += 5
                    else:
                        tmp += 1
            dfs(picks, minerals, piro+tmp, idx+5)
            picks[i] += 1
        
        
        
        