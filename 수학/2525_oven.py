time = input().split(' ')
A = int(time[0])
B = int(time[1])
oven = int(input())

B += oven

if B >= 60 :
  t = B // 60
  A += t
  B = B - (t * 60)

if A >= 24:
  A -= 24

print(A, B)
