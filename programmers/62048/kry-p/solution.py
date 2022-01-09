import math

def solution(w,h):
    x = 0
    y = 0

    # w = 100000000, h = 1인 경우와 같이
    # 한 축이 너무 길 때 시간 초과 방지
    if w == 1 or h == 1:
        return 0
    
    # 나누어 떨어지는 단위를 찾음
    while y <= h:
        x += 1
        y = h * x / w
        
        if y.is_integer():  # x 좌표와 y 좌표가 모두 정수이면 하나의 단위가 됨
            break
        
    pieces = int(h / y)  # 나누어 떨어지는 조각 수 (예시 입력에서는 4개 조각)
    ''' 
    하나의 단위공간에서 쓸 수 없는 정사각형의 수는 
    직사각형의 시작과 끝, 다음 조각으로 이어지는 점을 제외하고
    x = n 또는 y = n (n은 자연수) 을 만족하는 n의 개수 + 1과 같음
    
    왜 그런지는 몰루
    '''
    answer = w * h - pieces * (int(x - 1) + int(y - 1) + 1)
    
    return answer