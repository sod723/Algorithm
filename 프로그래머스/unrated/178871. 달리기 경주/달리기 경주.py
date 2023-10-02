def solution(players, callings):

    players_dict = {player: idx for idx, player in enumerate(players)}
    
    for call in callings:
        idx = players_dict[call]
        if idx > 0:
            players[idx-1], players[idx] = players[idx], players[idx-1]
            players_dict[players[idx]], players_dict[call] = idx, idx-1
        
    return players
