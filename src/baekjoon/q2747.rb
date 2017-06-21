class Q2747
  n = gets.chomp.to_i

  x = 0
  y = 1

  if n < 2
    if n == 0
      puts x
    elsif n == 1
      puts y
    end
  else
    (3..n).each {|i|
      if i %2 == 1
        x = x+y
      else
        y = x+y
      end
    }

    puts x + y
  end
end