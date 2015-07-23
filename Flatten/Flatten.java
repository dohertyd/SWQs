import java.util.LinkedList;
import java.util.List;
import static java.util.Arrays.asList;



public final class Flatten
{
	public static List<Object> flatten(List<?> list)
	{
		List<Object> retVal = new LinkedList<Object>();
		flatten(list, retVal);
		return retVal;
	}


        public static void flatten( List<?> fromTreeList, List<Object> toFlatList)
        {
             for (Object item : fromTreeList)
             {
                  if (item instanceof List<?>)
                  {
                       flatten((List<?>) item, toFlatList);
                  }
                  else
                  {
                       toFlatList.add(item);
                  }
             }
        }

        private static List<Object> a(Object... input)
        {
             return asList(input);
        }



	public static void main(String[] args)
	{
                List<Object> treeList = a(a(1), 2, a(a(3,4),5) );
                List<Object> flatList = flatten(treeList);

                System.out.println(treeList);
                System.out.println("flatten: " + flatList);
	}
}
