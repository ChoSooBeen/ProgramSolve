import sys

N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
plus, minus, multiply, divide = map(int, sys.stdin.readline().split())

# sys상 가장 큰수를 저장
resultMax = -sys.maxsize
resultMin = sys.maxsize

'''
count : 현재 접근하는 nums 인덱스
total : 앞의 연산 결과
plus, minus, multiply, divide : 각 연산이 가지고 있는 개수
'''
def dfs(count, total, plus, minus, multiply, divide) :        
    global resultMax, resultMin
    if count == N :
        resultMax = max(resultMax, total)
        resultMin = min(resultMin, total)
        return
    if plus :
        tmp = total + nums[count]
        dfs(count+1, tmp, plus-1, minus, multiply, divide)
    if minus :
        tmp = total - nums[count]
        dfs(count+1, tmp, plus, minus-1, multiply, divide)
    if multiply :
        tmp = total * nums[count]
        dfs(count+1, tmp, plus, minus, multiply-1, divide)
    if divide :
        '''
        // 와 / 의 차이점
        https://gksdudrb922.tistory.com/207 참고
        '''
        tmp = int(total / nums[count])
        dfs(count+1, tmp, plus, minus, multiply, divide-1)

# 맨 앞의 값에 연산자가 들어갈 일이 없으므로 바로 시작
dfs(1, nums[0], plus, minus, multiply, divide)
print(resultMax)
print(resultMin)
