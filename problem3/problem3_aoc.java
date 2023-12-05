import java.io.File;
import java.util.*;
import java.lang.*;
public class problem3_aoc
{
    public static void main(String[] args) throws Exception
    {
        String filename = "E:/Advent_of_Code/problem3/problem3_input.txt";
        problem3tp1(filename);
        problem3pt2(filename);   
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
                String[] values_str = new String[2];
                if (str_matrix[k][g].contains("*"))
                {
                    int valid_count = 0;
                    int[] q_store = new int[2];
                    int[] x_store = new int[2];
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
                    if (g != 0) 
                    {
                        Lcol_check = g-1;
                    } else {
                        Lcol_check = g;
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
                            if (isInteger(check) && valid_count < 2)
                            {
                                valid_count++;
                                q_store[valid_count-1] = q;
                                x_store[valid_count-1] = x;
                                // check overlap detection case
                                if (q_store[0] == q_store[1] && x_store[1]-x_store[0] == 1)
                                {
                                    int loop_var = x_store[1];
                                    while (!str_matrix[q_store[0]][loop_var].contains("."))
                                    {
                                        loop_var++;
                                    }
                                    x = loop_var;
                                    valid_count--;
                                }
                            }
                        }
                    }
                    if (valid_count > 1)
                    {
                        // method to find integer new a coordinate
                        String num1 = "";
                        String num2 = "";
                        // handle #1
                        // first go back till a "."
                        // collect ints till back at a "."
                        int new_save_col = 0;
                        for (int b = x_store[0]; b > 0; b--)
                        {
                            new_save_col = b+1;
                            if (str_matrix[q_store[0]][b].contains(".") || !isInteger(str_matrix[q_store[0]][b]))
                            {
                                break;
                            }
                        }
                        for (int n = new_save_col; n < mlength; n++)
                        {   
                            if(str_matrix[q_store[0]][n].contains(".") || !isInteger(str_matrix[q_store[0]][n]))
                            {
                                break;
                            }
                            if (isInteger(str_matrix[q_store[0]][n]))
                            {
                                num1 += str_matrix[q_store[0]][n];
                            }
                        }

                        int save_col_num2 = 0;
                        for (int f = x_store[1]; f > 0; f--)
                        {
                            save_col_num2 = f+1;
                            if (str_matrix[q_store[1]][f].contains(".") || !isInteger(str_matrix[q_store[1]][f]))
                            {
                                break;
                            }
                        }
                        for (int w = save_col_num2; w < mlength; w++)
                        {   
                            if(str_matrix[q_store[1]][w].contains(".") || !isInteger(str_matrix[q_store[1]][w]))
                            {
                                break;
                            }
                            if (isInteger(str_matrix[q_store[1]][w]))
                            {
                                num2 += str_matrix[q_store[1]][w];
                            }
                        }
                            values_str[0] = num1;
                        values_str[1] = num2;
                    }

                }
                // System.out.println("column: " + g + "\trow : " + k);
                // System.out.println("v1: " + values_str[0] + "v2: " + values_str[1]);
                int val1 = 0;
                int val2 = 0;
                if (values_str[0] != null && values_str[1] != null)
                {
                    val1 = Integer.parseInt(values_str[0]);
                    val2 = Integer.parseInt(values_str[1]);
                }
                total += val1*val2;
            }
        }
        System.out.println(total);
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



//  if (q_store[0] == q_store[1]) 
//                         {
//                             for (int b = x_store[0]; b > 0;  b--)
//                             {
//                                 if (isInteger(str_matrix[q_store[0]][b]))
//                                 {
//                                     num1 += str_matrix[q_store[0]][b];
//                                 }
//                             }
//                             for (int p = x_store[0]; p > 0;  p++)
//                             {
//                                 if (isInteger(str_matrix[q_store[1]][p]))
//                                 {
//                                     num1 += str_matrix[q_store[1]][p];
//                                 }
//                             }
//                         }