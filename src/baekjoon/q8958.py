"""
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
"""
count = int(input())
scores = []
for i in range(count):
    result = input()
    score = 0
    continuing = 0
    for c in result:
        if c == "O":
            continuing += 1
            score += continuing
        else:
            continuing = 0
    scores.append(score)

for i in scores:
    print(i)