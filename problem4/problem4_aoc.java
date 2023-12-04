import java.io.File;
import java.util.*;
import java.lang.*;

public class problem4_aoc
{
    public static void main(String[] args) throws Exception
    {
        String filename = "E:/Advent_of_Code/problem4/problem4.txt";
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int total = 0;
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] split_list = line.split(":");

            String[] split_winners = split_list[1].split("\\|");
            String[] winner_int_list = split_winners[0].split("\\s+");
            String[] my_int_list = split_winners[1].split("\\s+");
            int match_count = 0;
            int card_score = 0;
            for (int j = 1; j < winner_int_list.length; j++) 
            {
                for (int g = 1; g < my_int_list.length; g++)
                {
                    int my_number = Integer.parseInt(my_int_list[g]);
                    int winning_number = Integer.parseInt(winner_int_list[j]);
                    if (my_number == winning_number)
                    {
                        System.out.println("Mine: " + winning_number + "\tWinning : " + winning_number);
                        match_count ++;
                        if (match_count == 1)
                        {
                            card_score ++;
                        }
                        if (match_count > 1)
                        {
                            card_score *= 2;
                            System.out.println("Score: " + card_score);
                        }
                    }
                   
                }
            }
            total += card_score;
        }
        System.out.println(total);
    }
}