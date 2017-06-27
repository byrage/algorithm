"""
1 2 3 4 5 6 7 8
ascending, descending, mixed
"""
scale = list(map(int, input().split()))

if scale[0] == 1:
    arrange = "ascending"
    for index, elem in enumerate(scale):
        if elem != index + 1:
            arrange = "mixed"
            print(arrange)
            exit(0)

elif scale[0] == 8:
    arrange = "descending"
    for index, elem in enumerate(scale):
        if elem != 8 - index:
            arrange = "mixed"
            print(arrange)
            exit(0)

print(arrange)
