from collections import deque
def solution(x, y, n):
    answer = -1
    q = deque()
    q.append((x, 0))
    visited = set()
    while q:
        i, j = q.popleft()
        if i> y or i in visited:
            continue
        visited.add(i)
        if i == y:
            return j
        q.append((i + n, j + 1))
        q.append((i * 2, j + 1))
        q.append((i * 3, j + 1))
            
    return answer