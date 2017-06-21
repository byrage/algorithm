X = int(input())
Y = int(input())
Z = int(input())

result = str(X * Y * Z)
for c in ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']:
    print(result.count(c))