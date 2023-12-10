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

        List<List<Integer>> hand_info = new ArrayList<>();
        for (int j = 0; j < hands.length; j++)
        {
            String[] line = hands[j].split("(?!^)");
            /*
             * 1 - high card
             * 2 - pair
             * 3 - 2 pair
             * 4 - 3 of kind
             * 5 - Full house
             * 6 - 4 of a kind
             * 7 - 5 of a kind
             */
            List<Integer> cards = new ArrayList<>();
            Integer[] freq = new Integer[line.length];
            cards.add(card_dict.get(line[0]));
            cards.add(card_dict.get(line[1]));
            cards.add(card_dict.get(line[2]));
            cards.add(card_dict.get(line[3]));
            cards.add(card_dict.get(line[4]));

            // Find hand type
            int sum = 0;
            for (int k = 0; k < line.length; k++)
            {
                sum += Collections.frequency(cards,cards.get(k));
            }
            if (sum == 5) // each card has freq of 1 [1,1,1,1,1]
            {
                cards.add(1);
            }
            if (sum == 7) // two cards have freq of 2 [2,2,1,1,1]
            {
                cards.add(2);
            }
            if (sum == 9) // four cards have freq of 2 [2,2,2,2,1,]...
            {
                cards.add(3);
            }
            if (sum == 11)
            {
                cards.add(4);
            }
            if (sum == 13)
            {
                cards.add(5);
            }
            if (sum == 17)
            {
                cards.add(6);
            }
            if (sum == 25) // freq = [5,5,5,5,5]
            {
                cards.add(7);
            }
            // add bid
            cards.add(bids[j]);
            hand_info.add(cards);
        }
        // System.out.println(hand_info.get(0).get(6)); // print bid to confirm correct construction of list
        // check each card against others
        // get rank as `int rank ++ if > card[i]`
        // multiply rank by bid, add to `int total`
        int total = 0;
        List<Integer> indices = new ArrayList<>();
        indices.add(0);
        indices.add(1);
        indices.add(2);
        indices.add(3);
        indices.add(4);
        for (int y = 0; y < hand_info.size(); y++)
        {
            int rank = 1;
            int htype = hand_info.get(y).get(5);
            int bid = hand_info.get(y).get(6);
            for (int k = 0; k < hand_info.size(); k++)
            {
                int htype_compare = hand_info.get(k).get(5);

                if (k != y)
                {
                    if (htype > htype_compare)
                    {
                        rank++;
                    }
                    if (htype == htype_compare)
                    {
                        for (int p = 0; p < 5; p++)
                        {   
                            int hand = hand_info.get(y).get(p);
                            int hand_compare = hand_info.get(k).get(p);
                            if (hand_compare > hand)
                            {
                                break;
                            }
                            if (hand > hand_compare)
                            {
                                rank++;
                                break;
                            }
                        }
                    }
                }
            }
            int winnings = rank * bid;
            total += winnings;
        }
        System.out.println(total);

    }
}