nums = []
result = []
cnt = 0

for i in range(10):
    nums.append(int(input()))

for i in range(10):
    result.append(nums[i] % 42)
    
result2 = set(result)

print(len(result2))
