s = input().lower()
repetition = [0] * 26

for c in s:
    repetition[ord(c) - ord('a')] += 1

max_num = max(repetition)
temp = 0

for i in repetition:
    if i == max_num:
        temp += 1

if temp == 1:
    print(chr(ord("A") + repetition.index(max_num)))
else:
    print("?")
