File.open("day1.txt") do |f|
  input = []
  f.each_line.with_index do |line, idx|
    num = line.to_i
    input[idx] = num
  end

  flag = false
  current = 0
  answers = []
  until flag == true
    input.each do |num|
      current += num
      if answers.include?(current)
        flag = true
        p current
        break
      else 
        answers << current
      end
    end
  end
end