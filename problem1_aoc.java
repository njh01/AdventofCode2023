import java.io.File;
import java.util.*;
import java.lang.*;
public class problem1_aoc{
    public static void main(String[] args) throws Exception
    {
        File file = new File("E:/Advent_of_Code/puzzle1.txt");
        Scanner sc = new Scanner(file);
        
        int total = 0;
        while (sc.hasNextLine())
        {
            String line = sc.next();
            int digits = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) >= 48 && line.charAt(i) <= 57)
                {
                    digits++;
                }
                    
            }
            String strip_line = line.replaceAll("\\D+","");
            int line_int = Integer.parseInt(strip_line);
            int first_digit = Integer.parseInt(Integer.toString(line_int).substring(0, 1));
            int last_digit = lastDigit(line_int);
            int line_total = 0;
            // if (digits < 2) 
            // {
            //     line_total = last_digit; 
            // } else {
            //     String combined = Integer.toString(first_digit) + Integer.toString(last_digit);
            //     line_total = Integer.parseInt(combined);
            // }
            String combined = Integer.toString(first_digit) + Integer.toString(last_digit);
            line_total = Integer.parseInt(combined);

            total += line_total;
        }
        System.out.println(total);
    }

    public static int lastDigit(int integer_in)
    {
        return Math.abs(integer_in) % 10;
    }
}