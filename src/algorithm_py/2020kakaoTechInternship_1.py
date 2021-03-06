def solution(survey, choices):
    answer = ''
    type = [[0, 0], [0, 0], [0, 0], [0, 0]] #RT, CF, JM, AN
    for i in range(len(survey)):
        score = [3, 2, 1, 0, 1, 2, 3]
        if survey[i] == "RT":
            if choices[i] <= 3:
                type[0][0] += score[choices[i]-1]
            else:
                type[0][1] += score[choices[i]-1]
        elif survey[i] == "TR":
            if choices[i] <= 3:
                type[0][1] += score[choices[i]-1]
            else:
                type[0][0] += score[choices[i]-1]

        elif survey[i] == "CF":
            if choices[i] <= 3:
                type[1][0] += score[choices[i]-1]
            else:
                type[1][1] += score[choices[i]-1]
        elif survey[i] == "FC":
            if choices[i] <= 3:
                type[1][1] += score[choices[i]-1]
            else:
                type[1][0] += score[choices[i]-1]

        elif survey[i] == "JM":
            if choices[i] <= 3:
                type[2][0] += score[choices[i]-1]
            else:
                type[2][1] += score[choices[i]-1]
        elif survey[i] == "MJ":
            if choices[i] <= 3:
                type[2][1] += score[choices[i]-1]
            else:
                type[2][0] += score[choices[i]-1]

        elif survey[i] == "AN":
            if choices[i] <= 3:
                type[3][0] += score[choices[i]-1]
            else:
                type[3][1] += score[choices[i]-1]
        elif survey[i] == "NA":
            if choices[i] <= 3:
                type[3][1] += score[choices[i]-1]
            else:
                type[3][0] += score[choices[i]-1]
        else:
            print("잘못된 값입니다.")  
    if type[0][0] >= type[0][1]:
        answer += "R"
    else:
        answer += "T"
    if type[1][0] >= type[1][1]:
        answer += "C"
    else:
        answer += "F"
    if type[2][0] >= type[2][1]:
        answer += "J"
    else:
        answer += "M"
    if type[3][0] >= type[3][1]:
        answer += "A"
    else:
        answer += "N"

    return answer