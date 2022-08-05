test_case = int(input())
nums = input().split()

min = int(nums[0])
max = int(nums[0])

for i in range(1, test_case):
    num = int(nums[i])
    if num < min:
        min = num
    elif num > max:
        max = num

print(min, max)