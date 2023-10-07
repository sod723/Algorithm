def solution(wallpaper):
    answer = []
    lux, luy = int(1e9), int(1e9)
    rdx, rdy = 0, 0
    tmp = []
    
    
    for idx, file in enumerate(wallpaper):
        if '#' in file:
            luy = min(luy, file.index('#'))
            rdy = max(rdy, file.rindex('#'))
        
        for i in file:
            if '#' in file:
                tmp.append(idx)
        
    rdy += 1
    lux = min(tmp)
    rdx = max(tmp) + 1
    answer = [lux, luy, rdx, rdy]
    
    return answer