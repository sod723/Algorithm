def solution(s):
    answer = len(s)
    length = len(s)
    for i in range(1, length//2 + 1):
        data = ""
        prev = s[0:i]
        cnt = 1
        
        for j in range(i, length, i):
            if prev == s[j:j+i]:
                cnt +=1
            else:
                if cnt>=2:
                    data += str(cnt) +prev
                else:
                    data += prev
                prev = s[j:j+i]
                cnt = 1
                
        data += str(cnt) + prev if cnt >= 2 else prev
        answer = min(len(data), answer)
    return answer