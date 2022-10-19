price = int(input())
count = int(input())

sum = 0

for i in range(count):
    tmp = input().split()
    sum  = sum + (int(tmp[0]) * int(tmp[1]))

if sum == price:
    print('Yes')
else:
    print('No')

