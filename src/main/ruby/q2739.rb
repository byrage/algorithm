class Q2739
  x = gets.chomp.to_i
  (1..9).each do |n|
    puts "#{x} * #{n} = #{x*n}"
  end
end