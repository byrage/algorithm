# Ruby
### Array value-index 반복
```ruby
array = ["A", "B", "C"]
array.each_with_index {|val, index| puts "#{val} => #{index}" }
```

### Array 생성 시 크기와 기본 값 설정
```ruby
Array.new(123, 0)
```

### Convert String to Char Array
```ruby
input.chars
```

### Reverse string
```ruby
input.reverse
```

### Char to ASCII Code
```ruby
'a'.ord # After 1.9
?a # Before 1.9
```

## for syntax
#### 반복
```ruby
while 
until
```

#### 숫자로 반복
```ruby
for num in 1...10
  puts num
end
```

#### 무한 반복
```ruby
loop do
  ...
  break if
end
```

#### 배열 반복
```ruby
array.each do
end
```

```ruby
3.times
time = 3, time.times
```

#### 입력을 공백기준으로 나누어 Array로 받기
``` ruby
arr = gets.split
```

#### 입력을 공백 기준으로 나누어 각각 받으면서 Integer 타입으로 변환
``` ruby
x, y = gets.split.map(&:to_i)
```