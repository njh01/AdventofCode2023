import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;

public class problem5_aoc
{
    public static void main (String[] args) throws NumberFormatException, Exception
    {
        String filename = "E:/Advent_of_Code/problem5/problem5.txt";
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String seed_line_in = sc.nextLine();
        String[] seed_line = seed_line_in.split(":");
        String[] seed_numbers = seed_line[1].split("\\s+");
        Float[] seed_num_Float = new Float[seed_numbers.length-1];
        for (int i = 0; i < seed_numbers.length-1; i++)
        {
            seed_num_Float[i] = Float.parseFloat(seed_numbers[i+1]);
        }

        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");
        String[] str2 = str.split("\n");
        for (int k = 3; k < str2.length; k++)
        {
            String line = str2[k];
            String[] map_numbers = line.split("\\s+");
            Float dest_start = Float.parseFloat(map_numbers[0]);
            Float source_start = Float.parseFloat(map_numbers[1]);
            Float range_len = Float.parseFloat(map_numbers[2]);
            for (int j = 0; j < seed_num_Float.length; j++)
            {
                Float seed_no = seed_num_Float[j];
                Float map_destination;
                if ((seed_no >= source_start) && (seed_no <= (source_start + range_len)))
                {
                    Float idx = (seed_no-source_start);
                    map_destination = dest_start + idx;
                    seed_num_Float[j] = map_destination;
                }
            }
        }
        Float min = Float.MAX_VALUE;
        for (int q = 0; q < seed_num_Float.length; q++)
        {
            if (seed_num_Float[q]<min)
            {
                min = seed_num_Float[q];
            }
        }
        System.out.printf("%.1f",min);
    }
}