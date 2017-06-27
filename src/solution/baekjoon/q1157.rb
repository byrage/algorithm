=begin
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

예제 입력  복사
Mississipi
예제 출력  복사
?
=end

class Q1157
  input = gets.chomp.to_s.downcase
  repetition = Array.new(26, 0)

  input.each_char do |c|
    repetition[c.ord - 'a'.ord] += 1
  end

  maxNum = repetition.max
  temp = 0
  repetition.each do |i|
    if i == maxNum
      temp += 1
    end
  end

  if temp == 1
    puts (repetition.rindex(maxNum)+ 'A'.ord).chr
  else
    puts '?'
  end
end