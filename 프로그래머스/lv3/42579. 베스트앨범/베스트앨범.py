import operator
def solution(genres, plays):
    answer = []
    dic = {}
    for i in range(len(genres)):
        if genres[i] in dic:
            dic[genres[i]].append([plays[i], i])
        else:
            dic[genres[i]] = [[plays[i], i]]
    genre_rank = {}
    for i in dic.keys():
        plays_sum = 0
        for song in dic[i]:
            plays_sum += song[0]
        genre_rank[i] = plays_sum
    genre_rank = sorted(genre_rank.items(), key=operator.itemgetter(1) ,reverse = True)
    for genre in genre_rank:
        song_rank = sorted(dic[genre[0]], key = lambda x:(-x[0] , x[1]))
        two = 0
        for song in song_rank:
            answer.append(song[1])
            two += 1
            if two is 2:
                break
        
    return answer