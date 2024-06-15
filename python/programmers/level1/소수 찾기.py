import math


def solution(n):
    count = 0
    for i in range(2, n + 1):
        t = True
        for j in range(2, int(math.sqrt(i)) + 1):
            if i % j == 0:
                t = False
                break
        if t:
            count += 1
    return count
