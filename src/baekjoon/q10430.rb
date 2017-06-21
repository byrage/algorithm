class Q10430
  a, b, c = gets.split.map(&:to_i)
  p (a+b)%c, (a%c+b%c)%c, (a*b)%c, (a%c*b%c)%c
end