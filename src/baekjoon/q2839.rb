class Q2839
  x=gets.chomp.to_i

  r = -1

  (0..x/5).each {|a|
    (0..x/3).each {|b|
      if a*5 +b*3 == x
        r = a+b if a+b > 0 || r > a+b
      end
    }
  }

  puts r
end