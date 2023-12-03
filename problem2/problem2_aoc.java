import java.io.File;
import java.util.*;
import java.lang.*;
public class problem2_aoc
{

    public static void main (String[] args) throws Exception
    {
        String filename = "E:/Advent_of_Code/problem2/problem2_input.txt";
        problem2pt1(filename);
        problem2pt2(filename);
    }


    public static void problem2pt2(String filename) throws Exception
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int powersum = 0;
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] IDsplitter = line.split(":");
            String stripID_line = IDsplitter[0].replaceAll("\\D+","");
            int IDnum = Integer.parseInt(stripID_line);
            String[] subgame_splitter = IDsplitter[1].split(";");
            boolean valid = true;
            int minRed = 0;
            int minBlue = 0;
            int minGreen = 0;
            for (int j = 0; j < subgame_splitter.length; j++)
            {
                String[] cube_splitter = subgame_splitter[j].split(",");
                for (int k = 0; k < cube_splitter.length; k++)
                {
                    String cube_line = cube_splitter[k];
                    String strip_line = cube_splitter[k].replaceAll("\\D+","");
                    int cube_int = Integer.parseInt(strip_line);
                    if (cube_line.contains("red") && cube_int > minRed)
                    {
                        minRed = cube_int;
                    }
                    if (cube_line.contains("blue") && cube_int > minBlue)
                    {
                        minBlue = cube_int;
                    }
                    if (cube_line.contains("green") && cube_int > minGreen)
                    {
                        minGreen = cube_int;
                    }
                }
            }
        powersum += minBlue * minGreen * minRed;
        }
        System.err.println(powersum);
    }


    public static void problem2pt1(String filename) throws Exception
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int valid_games = 0;
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] IDsplitter = line.split(":");
            String stripID_line = IDsplitter[0].replaceAll("\\D+","");
            int IDnum = Integer.parseInt(stripID_line);
            String[] subgame_splitter = IDsplitter[1].split(";");
            boolean valid = true;
            for (int j = 0; j < subgame_splitter.length; j++)
            {
                String[] cube_splitter = subgame_splitter[j].split(",");
                for (int k = 0; k < cube_splitter.length; k++)
                {
                    String cube_line = cube_splitter[k];
                    String strip_line = cube_splitter[k].replaceAll("\\D+","");
                    int cube_int = Integer.parseInt(strip_line);
                    if (cube_line.contains("red") && cube_int > 12 )
                    {
                        valid = false;
                    }
                    if (cube_line.contains("blue") && cube_int > 14 )
                    {
                        valid = false;
                    }
                    if (cube_line.contains("green") && cube_int > 13 )
                    {
                        valid = false;
                    }
                }
            }
            if (valid)
            {
                valid_games += IDnum;
            }
        }
        System.err.println(valid_games);
    }
}