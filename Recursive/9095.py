import sys

testcase = int(sys.stdin.readline())   

def fun(n) :
    if n == 1 :
        return 1
    if n == 2 :
        return 2
    if n == 3 :
        return 4
    return fun(n-1) + fun(n-2) + fun(n-3) 

for i in range(testcase) :
    num = int(sys.stdin.readline())
    print(fun(num))
