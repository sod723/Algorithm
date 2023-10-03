def solution(sequence, k):
    answer = []
    s_idx, e_idx = 0, 0
    sum = 0
    min_length = float('inf')  
    
    while e_idx < len(sequence):
        sum += sequence[e_idx]
        e_idx += 1

        while sum >= k and s_idx < e_idx:
            
            if sum == k and e_idx - s_idx < min_length:
                answer = [s_idx, e_idx-1]
                min_length = e_idx - s_idx
            sum -= sequence[s_idx]
            s_idx += 1

    return answer
