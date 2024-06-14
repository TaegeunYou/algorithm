def solution(n, arr1, arr2):
    arr1 = [format(i, "b").zfill(n) for i in arr1]
    arr2 = [format(i, "b").zfill(n) for i in arr2]
    result = ""
    for i in range(len(arr1)):
        for j in range(len(arr1[i])):
            if arr1[i][j] == "1" or arr2[i][j] == "1":
                result += "#"
            else:
                result += " "
        result += "\n"
    return result.split("\n")[:-1]