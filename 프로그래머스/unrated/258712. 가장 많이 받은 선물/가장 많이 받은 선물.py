def solution(friends, gifts):
    # 선물 기록 분석을 위한 데이터 구조 초기화
    gift_given = {friend: {other: 0 for other in friends if other != friend} for friend in friends}
    gift_received = {friend: 0 for friend in friends}

    # 선물 기록 분석
    for gift in gifts:
        giver, receiver = gift.split(' ')
        gift_given[giver][receiver] += 1
        gift_received[receiver] += 1

    # 선물 지수 계산 (준 선물 수 - 받은 선물 수)
    gift_index = {friend: sum(gift_given[friend].values()) - gift_received[friend] for friend in friends}

    # 다음 달 선물 예측
    next_month_gifts = {friend: 0 for friend in friends}
    for friend1 in friends:
        for friend2 in friends:
            if friend1 != friend2:
                # 두 친구 사이에 선물을 주고받은 기록이 있으면, 더 많은 선물을 준 사람이 선물을 받음
                if gift_given[friend1][friend2] > gift_given[friend2][friend1]:
                    next_month_gifts[friend1] += 1
                # 선물 기록이 없거나 같은 수로 주고받았다면, 선물 지수가 더 높은 사람이 선물을 받음
                elif gift_given[friend1][friend2] == gift_given[friend2][friend1]:
                    if gift_index[friend1] > gift_index[friend2]:
                        next_month_gifts[friend1] += 1
                    elif gift_index[friend1] == gift_index[friend2]:
                        # 두 사람의 선물 지수가 같다면 선물을 주고받지 않음
                        continue

    return max(next_month_gifts.values()) if next_month_gifts else 0
