import sys
from collections import deque
input = sys.stdin.readline
line = list(map(str, input()))
stack = deque()
ans = 0
for i in range(len(line)):
    if line[i] == '(':
        stack.append(line[i])

    elif line[i] == ')':
        if line[i-1] == '(':
            stack.pop()
            ans += len(stack)
        else:
            stack.pop()
            ans += 1
print(ans)

