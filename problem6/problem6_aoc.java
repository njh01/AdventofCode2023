import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;

public class problem6_aoc
{
    public static void main (String[] args) throws Exception, NumberFormatException
    {
        String filename = "E:/Advent_of_Code/problem6/problem6.txt";
        part1(filename);
        String filename2 = "E:/Advent_of_Code/problem6/problem6pt2.txt";
        part2(filename2);

    }


    public static void part2(String filename) throws Exception,NumberFormatException
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String[] times_line = sc.nextLine().split(":");
        String[] dists_line = sc.nextLine().split(":");
        String[] times = times_line[1].split("\\s+");
        String[] dists = dists_line[1].split("\\s+");
        Double[] time = new Double[times.length];
        Double[] dist = new Double[dists.length];
        for (int i = 0; i < dists.length; i++)
        {
            time[i] = Double.parseDouble(times[i]);
            dist[i] = Double.parseDouble(dists[i]);
        }
        Double total = 1.;
        for (int k = 0; k < time.length; k++)
        {
            Double j = 0.;
            int win_counter = 0;
            while (j < time[k])
            {
                Double time_held = j;
                Double time_remaining = time[k] - j;
                Double race_dist = time_held * time_remaining;
                if (race_dist > dist[k])
                {
                    win_counter++;
                }
                j++;
            }
            total *= win_counter;
        }
        System.out.printf("%.1f",total);
    }



    public static void part1(String filename) throws Exception, NumberFormatException
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        String[] times_line = sc.nextLine().split(":");
        String[] dists_line = sc.nextLine().split(":");
        String[] times = times_line[1].split("\\s+");
        String[] dists = dists_line[1].split("\\s+");
        int[] time = new int[times.length];
        int[] dist = new int[dists.length];
        for (int i = 0; i < dists.length; i++)
        {
            time[i] = Integer.parseInt(times[i]);
            dist[i] = Integer.parseInt(dists[i]);
        }
        int total = 1;
        for (int k = 0; k < time.length; k++)
        {
            int j = 0;
            int win_counter = 0;
            while (j < time[k])
            {
                int time_held = j;
                int time_remaining = time[k] - j;
                int race_dist = distance(time_held, time_remaining);
                if (race_dist > dist[k])
                {
                    win_counter++;
                }
                j++;
            }
            total *= win_counter;
        }
        System.out.println(total);
    }


    public static int distance(int time_held, int time_remaining)
    {
        return time_held * time_remaining;
    }
}