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