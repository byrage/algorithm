class Q10817
  a, b, c = gets.split.map(&:to_i)
  puts a+b+c- [a, b, c].max - [a, b, c].min
end