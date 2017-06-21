class Q1475
  def initialize(input=gets.chomp.to_i)
    @input = input
  end

  def run
    number_arr = split_number(@input)
    counter_arr = count_each_number_size(number_arr)
    number_sets = handle_special_number(counter_arr)

    counter_arr.each {|n|
      number_sets = n if number_sets < n
    }

    return number_sets
  end

  def split_number(input)
    arr = Array.new(input.to_s.length)
    i=0

    loop {
      if input / 10 >= 1
        arr[i] = input % 10
        i += 1
        input = input / 10
      else
        arr[i] = input
        break
      end
    }

    return arr
  end

  def count_each_number_size(number_arr)
    count_arr = Array.new(10, 0)

    number_arr.each {
        |n| count_arr[n] += 1
    }

    return count_arr
  end

  def handle_special_number(counter_arr)

    size = 0
    if counter_arr[6] > 0 || counter_arr[9] > 0
      size = (counter_arr[6] + counter_arr[9] + 1) / 2
      counter_arr[6] = 0
      counter_arr[9] = 0
    end

    return size
  end

end

puts(RoomNumber.new.run)