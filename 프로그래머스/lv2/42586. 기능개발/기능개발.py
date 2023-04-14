def solution(progresses, speeds):
    answer = []
    work = []
    for i in range(len(progresses)):
        time = 1
        progress = progresses[i]
        while progress <100:
            time += 1
            progress = progresses[i] + speeds[i] * time
        work.append(time)
    idx = 0
    while idx < len(work):
        cnt = 1
        for j in range(idx + 1, len(work)):
            if work[j] > work[idx]:
                break
            cnt += 1
        answer.append(cnt)
        idx += cnt

    return answer