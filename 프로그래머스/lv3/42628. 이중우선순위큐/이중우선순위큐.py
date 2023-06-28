import heapq

def solution(operations):
    heap = []
    maxheap = []
    
    for i in operations:
        current = i.split()
        if current[0] == "I":
            num = int(current[1])
            heapq.heappush(heap, num)
            heapq.heappush(maxheap, (num*-1, num))
        elif current[0] == "D":
            if len(heap) == 0:
                pass
            elif current[1] == "1":
                maxvalue = heapq.heappop(maxheap)[1]
                heap.remove(maxvalue)
            elif current[1] == "-1":
                minvalue = heapq.heappop(heap)
                maxheap.remove((minvalue*-1, minvalue))
    
    if heap:
        return [heapq.heappop(maxheap)[1], heapq.heappop(heap)]
    else:
        return [0,0]