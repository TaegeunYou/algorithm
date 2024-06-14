def solution(d, budget):
    result = 0
    d.sort()
    for i in range(len(d)):
        budget -= d[i]
        if budget >= 0:
            result += 1
        else:
            break
    return result
