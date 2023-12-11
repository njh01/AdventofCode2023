import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;

public class problem10_aoc
{
	/**
	 * compilation note
	 * `$~ javac problem10_aoc.java`
	 * `$~ java -cp . problem10_aoc`
	 */
    public static void main (String[] args) throws Exception
    {
        String filename = "C:/Users/njhen/Documents/AdventofCode2023/problem10/problem10.txt";
        File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String str = new String(data, "UTF-8");
        String[] lines = str.split("\n");
        String line00 = lines[0];

        int s_row = 0;
        int s_col = 0;
        for (int i = 0; i < lines.length; i++)
        {
        	s_col = lines[i].indexOf("S");
        	s_row = i;
        	if (s_col != -1)
        	{
        		break;
        	}
        }
        System.out.println("S location: r" + s_row + "c" + s_col);
        Integer[] current_coords = new Integer[]{s_row,s_col};
        Integer[] north = new Integer[]{-1,0};
        Integer[] south = new Integer[]{1,0};
        Integer[] west = new Integer[]{0,-1};
        Integer[] east = new Integer[]{0,1};
        String direction = "north";
        String current_pipe;
        swtich (current_pipe)
        {
        	case "\|":
        		// Direction is from current node to connecting node
        		if (direction == "north")
        		{
        			current_coords[0] = current_coords[0] + north[0];
        		}
        		if (direction == "south")
        		{
        			current_coords[0] = current_coords[0] + south[0];
        		}
        		break;
        	case "\-":
        		if (direction == "east")
        		{
        			current_coords[1] = current_coords[0] + east[1];
        		}
        		if (direction == "west")
        		{
        			current_coords[1] = current_coords[0] + west[1];
        		}
        		break;
        	case "L": // opposite direction, starting node into connecting
        		if (direction == "west")
        		{
        			current_coords[1] = current_coords[1] + west[1];
        			current_coords[0] = current_coords[0] + north[0]; 
        		}
        		if (direction == "south")
        		{
        			current_coords[0] = current_coords[0] + south[0];
        			current_coords[1] = current_coords[1] + east[1];
        		}
        		break;
        	case "J":
        		if (direction == "south")
        		{
        			current_coords[0] = current_coords[0] + south[0];
        			current_coords[1] = current_coords[1] + west[1];
        		}
        		if (direction == "east")
        		{
        			current_coords[0] = current_coords[0] + north[0];
        			current_coords[1] = current_coords[1] + east[1];
        		}
        		break;
        	case "7":
        		if (direction == "north")
        		{
        			current_coords[0] = current_coords[0] + north[0];
        			current_coords[1] = current_coords[1] + west[1];
        		}
        		if (direction == "east")
        		{
        			current_coords[0] = current_coords[0] + south[0];
        			current_coords[1] = current_coords[1] + east[1];
        		}
        		break;
        	case "F":
        		if (direction == "north")
        		{
        			current_coords[0] = current_coords[0] + north[0];
        			current_coords[1] = current_coords[1] + east[1];
        		}
        		if (direction == "west")
        		{
        			current_coords[0] = current_coords[0] + south[0];
        			current_coords[1] = current_coords[1] + west[1];
        		}
        		break;
        	default:
        		break;
        }
        direction = "south"
        current_pipe = "|"
        switch(current_pipe)
        System.out.println(current_coords)
        


    }
}