import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;

public class problem7_aoc
{
    public static void main (String[] args) throws Exception
    {
        String filename = "E:/Advent_of_Code/problem7/problem7.txt";
        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        Map<String, Integer> card_dict = new Hashtable<>();
        card_dict.put("A",14);
        card_dict.put("K",13);
        card_dict.put("Q",12);
        card_dict.put("J",11);
        card_dict.put("T",10);
        card_dict.put("9",9);
        card_dict.put("8",8);
        card_dict.put("7",7);
        card_dict.put("6",6);
        card_dict.put("5",5);
        card_dict.put("4",4);
        card_dict.put("3",3);
        card_dict.put("2",2);

        String str = new String(data, "UTF-8");
        String[] hands_n_bids = str.split("\n");
        String[] hands = new String[hands_n_bids.length];
        Integer[] bids = new Integer[hands_n_bids.length];
        for (int i = 0; i < hands_n_bids.length; i++)
        {   
            String[] line = hands_n_bids[i].split("\\s+");
            hands[i] = line[0];
            bids[i] = Integer.parseInt(line[1]);
        }
        
    }
}