#

# Complete the 'dayOfProgrammer' function below.
#

# The function is expected to return a STRING.
# The function accepts INTEGER year as parameter.
#


function dayOfProgrammer(year)

# Write your code here
total_days = 243
programmer_day = 256
if year >= 1700 && year <1917
if year % 4 == 0
total_days += 1
end
        elseif(year == 1918)
total_days = total_days - 28 + 15
else
if year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)
total_days += 1
end
        end
date = programmer_day - total_days
return
string(date,
".09.",year)
end
        fptr = open(ENV["OUTPUT_PATH"], "w")
year = parse(Int32, strip(readline(stdin)))
result = dayOfProgrammer(year)
write(fptr, result
* "\n")
close(fptr)
