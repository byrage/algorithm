sentence = input().strip()
string = ''.join([c for c in sentence if c not in "1234567890"])
result = string.split(' ')
count = 0

for i in result:
    if i != '':
        count += 1

print(count)
