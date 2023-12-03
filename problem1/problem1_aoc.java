import java.io.File;
import java.util.*;
import java.lang.*;
public class problem1_aoc{
    public static void main(String[] args) throws Exception
    {
        int problem1 = problem1("E:/Advent_of_Code/problem1/puzzle1.txt");
        System.out.println(problem1);

        // problem 2
        int problem2 = problem1pt2("E:/Advent_of_Code/problem1/problem1pt2.txt");
        System.out.println(problem2);
    }

    public static int problem1(String filename) throws Exception
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        
        int total = 0;
        while (sc.hasNextLine())
        {
            String line = sc.next();
            String strip_line = line.replaceAll("\\D+","");
            int line_int = Integer.parseInt(strip_line);
            int first_digit = Integer.parseInt(Integer.toString(line_int).substring(0, 1));
            int last_digit = lastDigit(line_int);
            int line_total = 0;
            String combined = Integer.toString(first_digit) + Integer.toString(last_digit);
            line_total = Integer.parseInt(combined);

            total += line_total;
        }
        return total;
    }


    public static int problem1pt2(String filename) throws Exception
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        
        Dictionary<String, String> num_dict = new Hashtable<>();
        num_dict.put("one","o1e");
        num_dict.put("two","t2o");
        num_dict.put("three","thr3e");
        num_dict.put("four","f4ur");
        num_dict.put("five","f5ve");
        num_dict.put("six","s6x");
        num_dict.put("seven","s7ven");
        num_dict.put("eight","e8ght");
        num_dict.put("nine","n9ne");

        int total = 0;
        while (sc.hasNextLine())
        {
            Enumeration<String> keys_str = num_dict.keys();
            String line = sc.next();
            while (keys_str.hasMoreElements())
            {
                String keyname = keys_str.nextElement();
                if (line.contains(keyname))
                {
                    line = line.replace(keyname,num_dict.get(keyname));
                    System.out.println(keyname);
                    System.out.println(num_dict.get(keyname));
                    System.out.println(line);

                }
            }
            String strip_line = line.replaceAll("\\D+","");
            int line_int = Integer.parseInt(strip_line);
            int first_digit = Integer.parseInt(Integer.toString(line_int).substring(0, 1));
            int last_digit = lastDigit(line_int);
            int line_total = 0;
            String combined = Integer.toString(first_digit) + Integer.toString(last_digit);
            line_total = Integer.parseInt(combined);

            total += line_total;
        }
        return total;
    }


    public static int lastDigit(int integer_in)
    {
        return Math.abs(integer_in) % 10;
    }
}