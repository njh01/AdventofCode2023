import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;

public class problem9_aoc
{
    public static void main (String[] args) throws Exception
    {
        String filename = "E:/Advent_of_code/problem9/problem9.txt";
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int total = 0;
        while (sc.hasNextLine())
        {
            ArrayList<Integer[]> line_history = new ArrayList<Integer[]>();
            String line = sc.nextLine();
            String[] split_line = line.split("\\s+");
            Integer[] line_nums = new Integer[split_line.length+1];
            for (int i = 0; i < split_line.length; i++)
            {
                line_nums[i] = Integer.parseInt(split_line[i]);
            }
            line_nums[line_nums.length-1] = 0;
            line_history.add(line_nums);
            int line_count = 0;
            while (!onlyZeros(line_history.get(line_count)))
            {
                Integer[] loop_var = line_history.get(line_count);
                Integer[] hist = new Integer[line_nums.length-1-line_count];
                for (int i = 0; i < line_nums.length-(2+line_count); i++)
                {
                    hist[i] = Math.abs(loop_var[i+1] - loop_var[i]);
                    hist[i+1] = 0;
                }
                hist[hist.length-1] = 0;
                line_history.add(hist);
                line_count++;
            }
            int extrap = 0;
            for (int j = line_count; j > 0; j--)
            {
                int index = line_history.get(j).length-1;
                int num2add = line_history.get(j)[index];
                int numadded = line_history.get(j-1)[index];
                if (j == 1)
                {        
                    int check_numadded = line_history.get(j-1)[index-1];
                    if ((numadded < 0) && (check_numadded > numadded))
                    {
                        num2add *= -1;
                    }
                }
                int sum = num2add + numadded;
                line_history.get(j-1)[index+1] = sum;
                extrap = sum;
            }
            total += extrap;
        }
        System.out.println(total);
    }

    public static boolean onlyZeros(Integer[] int_in)
    {
        for (int i = 0; i < int_in.length; i++)
        {
            if (int_in[i] == null)
            {
                int_in[i] = 0;
            }
            if (int_in[i] > 0)
            {
                return false;
            }
        }
        return true;
    }
}