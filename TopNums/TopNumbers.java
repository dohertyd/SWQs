import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class TopNumbers 
{
    static void topN (String numbersFile, int N) throws IOException 
    {
        BufferedReader inputStream = null;
	Queue<Long> pq = new PriorityQueue<Long>(N);
	List<Long> result = new ArrayList<Long>(N);

	try 
	{
	    inputStream = new BufferedReader(new FileReader("numbers.txt"));

            String line;
	    // Go Through the list of numbers
            while ((line = inputStream.readLine()) != null) 
	    {
		long num = Long.valueOf(line);
		// Add the first N elements to Q
		if (pq.size() < N)
		{
		    pq.add(num);
		}
		// Iterate through the following elements and compare to HEAD of priority Q
		// If a bigger number is found remove HEAD and add new bigger number into Q
		else
		{
		    if (num > pq.element())
		    {
		        pq.remove();
			pq.add(num);
                    }
		}
	    }
	} finally 
	{
            if (inputStream != null) 
	    {
	        inputStream.close();
	    }
	} 

	// Use an Array list to print out the N numbers in the correct order, Highest first
	while (!pq.isEmpty()) 
	   result.add(pq.remove());

        ListIterator li = result.listIterator(result.size());
        while (li.hasPrevious())
	   System.out.println( ">" + li.previous() + "<");
    }



    public static void main(String[] args) throws IOException 
    {
        
        if (args.length != 2)
	{
	     System.out.println("Use -> java TopNumbers <fileName> <N> " );
	     System.exit(0);
        }
	String fileName = args[0];
	int N = Integer.valueOf(args[1]);
	topN( fileName, N );
    }
}
