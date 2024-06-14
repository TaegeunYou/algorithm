def solution(s):
    count = 0
    for i in s:
        if i.lower() == 'p':
            count += 1
        elif i.lower() == 'y':
            count -= 1
    return count == 0
