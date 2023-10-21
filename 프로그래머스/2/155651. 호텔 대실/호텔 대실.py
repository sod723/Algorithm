def solution(book_time):
    answer = 0
    book_time.sort(key = lambda x: x[0])
    #print(book_time)
    
    for i in range(len(book_time)):
        for j in range(2):
            book_time[i][j] = int(book_time[i][j][0:2])*60 + int(book_time[i][j][3:5])
        book_time[i][1] += 10
    #print(book_time)
    
    events = []
    for start, end in book_time:
        events.append((start, 1)) 
        events.append((end, -1))   

    events.sort()

    max_overlap = 0
    current_overlap = 0
    for _, val in events:
        current_overlap += val
        max_overlap = max(max_overlap, current_overlap)
    

    return max_overlap