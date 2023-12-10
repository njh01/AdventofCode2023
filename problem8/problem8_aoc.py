import copy
import math


def part1(lines):
    # LHS = lines [][0:3]
    # LRHS = lines[][7:10]
    # RRHS = lines[][12:15]
    destination = 'ZZZ'
    current = 'AAA'
    rl_direction = lines[0]
    count = 0
    line_no = 691
    rl_counter = 0
    while current != destination:
        current_direction = rl_direction[rl_counter]
        if current_direction == 'L':
            coords = [7,10]
        if current_direction == 'R':
            coords = [12,15]
        current = lines[line_no][coords[0]:coords[1]]
        prev_line_no = copy.copy(line_no)
        for i in range(len(lines)):
            if current in lines[i][0:3] and i != prev_line_no:
                line_no = i
                break
        current = lines[line_no][0:3]
        count += 1
        rl_counter += 1
        if rl_counter > len(lines[0])-1:
            rl_counter = 0
    print(count)


def part2(lines):
    # Samuel hints: LCM
    rl_direction = 'LR'
    destination = 'ZZZ'
    line_nos = [11,191,242,371,476,691]
    count = [0,0,0,0,0,0]
    rl_counter = 0
    for j in range(len(line_nos)):
        line_no = line_nos[j]
        current = lines[line_nos[j]][0:3]
        while current[2] != destination[2]:
            current_direction = rl_direction[rl_counter]
            if current_direction == 'L':
                coords = [7,10]
            if current_direction == 'R':
                coords = [12,15]
            current = lines[line_no][coords[0]:coords[1]]
            prev_line_no = copy.copy(line_no)
            for i in range(len(lines)):
                if current in lines[i][0:3] and i != prev_line_no:
                    line_no = i
                    break
            current = lines[line_no][0:3]
            count[j] += 1
            rl_counter += 1
            if rl_counter > len(rl_direction)-1:
                rl_counter = 0

    for i in range(len(count)-1):
        current_lcm = lcm(count[i],count[i+1])
    print(current_lcm)


def lcm(a, b):
    return abs(a*b) // math.gcd(a, b)



def main():
    with open("./problem8.txt","r") as f:
        data = f.read()
    lines = data.split("\n")
    part1(lines)
    part2(lines)


if __name__ == "__main__":
    main()