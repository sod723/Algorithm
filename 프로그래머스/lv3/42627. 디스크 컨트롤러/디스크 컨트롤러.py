import heapq

def solution(jobs):
    count, last, answer = 0, -1, 0
    heap = []
    jobs.sort()
    time = jobs[0][0]
    
    while count < len(jobs):
        for s in jobs:
            if last < s[0] <= time:
                heapq.heappush(heap, (s[1], s[0]))
        if len(heap) > 0:
            current = heapq.heappop(heap)
            last = time
            time += current[0]
            answer += time - current[1]
            count += 1
        else:
            time += 1
    return int(answer / len(jobs))
