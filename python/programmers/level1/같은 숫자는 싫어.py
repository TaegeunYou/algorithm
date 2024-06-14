def solution(arr):
    li = []
    before = -1
    for i in arr:
        if i not in li or before != i:
            li.append(i)
            before = i
    return li