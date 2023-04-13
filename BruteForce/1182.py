import sys

N, S = map(int, sys.stdin.readline().split())

nums = list(map(int, sys.stdin.readline().split()))

count = 0

tmp = []

'''
조합을 구할 함수
start : 시작 인덱스
시작점을 부여하는 이유 : 똑같은 값을 가지고 순서만 다른 조합을 만들지 않기 위해
'''
def combination(start) : 
    global count
    if sum(tmp) == S and len(tmp) > 0 :
        count += 1
        # return 사용하면 안된다 -> 현재 시작점에서 다른 조합이 조건을 만족할 수도 있다.

    # 현재 시작 인덱스부터 뒤에 원소만 고려한다.
    for i in range(start, N) :
        tmp.append(nums[i])
        combination(i+1)
        tmp.pop()

combination(0)
print(count)
