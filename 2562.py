max = 0
nums = []

for i in range(9):
    num = int(input())
    nums.append(num)
    if num > max:
        max = num
    
print(max)
print(nums.index(max)+1)