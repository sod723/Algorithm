answer = 0

def dfs(numbers, target, idx, num):
    global answer
    
    if idx == len(numbers) and target == num:
        answer += 1
        return
    elif idx == len(numbers):
        return
    dfs(numbers, target, idx+1, num+ numbers[idx])
    dfs(numbers, target, idx+1, num-numbers[idx])
    

def solution(numbers, target):
    global answer
    dfs(numbers, target, 0, 0)
    return answer


