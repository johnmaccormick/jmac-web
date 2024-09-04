input = '12 4 7 24 14 15'
numbers = map (int, input.split())
pairs = []
for num1 in numbers:
    for num2 in numbers:
        if num1 < num2 and num2 % num1 == 0:
            pairs.append(str(num1) + ' ' + str(num2))
output = '\n'.join(pairs)
print output
