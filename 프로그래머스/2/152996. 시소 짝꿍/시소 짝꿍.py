def solution(weights):
    answer = 0
    
    dict = {}
    for weight in weights:
        if weight in dict:
            dict[weight] += 1
        else:
            dict[weight] = 1
    print(dict)
    
    for weight in dict:
        if dict[weight] > 1:
            answer += (dict[weight] * (dict[weight]-1)) / 2
        if weight * 2/3 in dict:
            answer += dict[weight] * dict[weight*2/3]
        if weight * 3/4 in dict:
            answer += dict[weight] * dict[weight*3/4]
        if weight * 1/2 in dict:
            answer += dict[weight] * dict[weight*1/2]
    return answer