import java.io.File;
import java.util.*;
import java.lang.*;

public class problem3_aoc
{
    public static void main(String[] args) throws Exception
    {
        String filename = "E:/Advent_of_Code/problem3/problem3_input.txt";
        problem3tp1(filename);   
    }


    public static void problem3pt2(String filename) throws Exception
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int mlength = 140;
        String[][] str_matrix = new String[mlength][mlength];
        int i = 0;
        while (sc.hasNextLine())
        {
            String line_in = sc.next();
            String[] split_line = line_in.split("");
            for (int j = 0; j < split_line.length; j++)
            {
                str_matrix[i][j] = split_line[j];
            }
            i++;
        }
        int total = 0;
        for (int k = 0; k < mlength; k++)
        {
            
            for (int g = 0; g < mlength; g++)
            {   
                String candidate = "";
                // Step 1: Get the integer out
                int init = 0;
                if (isInteger(str_matrix[k][g]))
                {   
                    init = g;
                    int idx = g;
                    candidate += str_matrix[k][g];
                    for (int y = g+1; y < mlength; y++)
                    {
                        if (isInteger(str_matrix[k][y]))
                        {
                            candidate += str_matrix[k][y];
                        } else {
                            break;
                        }
                        idx = y;
                    }
                    g=idx;
                }
                // Step 2: check for special characters
                if (!candidate.isEmpty())
                { 
                    // Check row limits
                    boolean valid = false;
                    int Lrow_check = 0;
                    int Hrow_check = 0;
                    if (k != 0) 
                    {
                        Lrow_check = k-1;
                    } else {
                        Lrow_check = k;
                    }
                    if (k != mlength-1)
                    {
                        Hrow_check = k+1;
                    } else {
                        Hrow_check = k;
                    }
                    // Check column limits
                    int Lcol_check = 0;
                    int Hcol_check = 0;
                    if (init != 0) 
                    {
                        Lcol_check = init-1;
                    } else {
                        Lcol_check = init;
                    }
                    if (g != mlength-1)
                    {
                        Hcol_check = g+1;
                    } else {
                        Hcol_check = g;
                    }
                    for (int q = Lrow_check; q <= Hrow_check; q++)
                    {
                        for (int x = Lcol_check; x <= Hcol_check; x++)
                        {
                            String check = str_matrix[q][x];
                            if (check.contains("*"))
                            {
                                valid = true;
                            }
                        }
                    }
                }
            }
        }
    }


    public static void problem3tp1(String filename) throws Exception
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int mlength = 140;
        String[][] str_matrix = new String[mlength][mlength];
        int i = 0;
        while (sc.hasNextLine())
        {
            String line_in = sc.next();
            String[] split_line = line_in.split("");
            for (int j = 0; j < split_line.length; j++)
            {
                str_matrix[i][j] = split_line[j];
            }
            i++;
        }
        int total = 0;
        for (int k = 0; k < mlength; k++)
        {
            
            for (int g = 0; g < mlength; g++)
            {   
                String candidate = "";
                // Step 1: Get the integer out
                int init = 0;
                if (isInteger(str_matrix[k][g]))
                {   
                    init = g;
                    int idx = g;
                    candidate += str_matrix[k][g];
                    for (int y = g+1; y < mlength; y++)
                    {
                        if (isInteger(str_matrix[k][y]))
                        {
                            candidate += str_matrix[k][y];
                        } else {
                            break;
                        }
                        idx = y;
                    }
                    g=idx;
                }
                // Step 2: check for special characters
                if (!candidate.isEmpty())
                { 
                    // Check row limits
                    boolean valid = false;
                    int Lrow_check = 0;
                    int Hrow_check = 0;
                    if (k != 0) 
                    {
                        Lrow_check = k-1;
                    } else {
                        Lrow_check = k;
                    }
                    if (k != mlength-1)
                    {
                        Hrow_check = k+1;
                    } else {
                        Hrow_check = k;
                    }
                    // Check column limits
                    int Lcol_check = 0;
                    int Hcol_check = 0;
                    if (init != 0) 
                    {
                        Lcol_check = init-1;
                    } else {
                        Lcol_check = init;
                    }
                    if (g != mlength-1)
                    {
                        Hcol_check = g+1;
                    } else {
                        Hcol_check = g;
                    }
                    for (int q = Lrow_check; q <= Hrow_check; q++)
                    {
                        for (int x = Lcol_check; x <= Hcol_check; x++)
                        {
                            String check = str_matrix[q][x];
                            if (!isInteger(check) && !check.contains("."))
                            {
                                valid = true;
                            }
                        }
                    }

                    // Step 3: add to the total sum
                    if (valid)
                    {
                        int valid_candidate = Integer.parseInt(candidate);
                        total += valid_candidate;  
                    }             
                }
            }
        }
        System.out.println(total);
    }


    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}