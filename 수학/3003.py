chess = [1, 1, 2, 2, 2, 8]

a = input().split(' ')

result = []

for i in range(len(chess)):
    result.append(chess[i] - int(a[i]))

for i in result:
    print(i, end = ' ')
