
public class MergeSort 
{
	private int [] list;
	private int comp;
	
	public void setList(int [] list)
	{
		this.list = list;
		comp = 0;
	}
	
	public void sort()
	{
		if(list == null)
			return;

		for (int i = 1; i < list.length; i = 2 * i) 
			for (int left = 0; left < list.length-1; left += 2 * i) 
				mergeArray(list, left, left + i - 1, Math.min(left +( 2 * i) - 1, list.length-1));
	}


	private void mergeArray(int [] list, int l, int m, int r)
	{
		int num1 = m - l + 1;
		int num2 = r - m;
	 
        int L[] = new int [num1];
        int R[] = new int [num2];
 
        for (int i = 0; i < num1; i++)
            L[i] = list[l + i];
        for (int j = 0; j < num2; j++)
            R[j] = list[m + 1+ j];

        int i = 0, j = 0;
        int k = l;
        
        while (i < num1 && j < num2)
        {
        	comp++;
            if (L[i] <= R[j])
            {
                list[k] = L[i];
                i++;
            }
            else
            {
                list[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < num1)
        {
            list[k] = L[i];
            i++;
            k++;
        }
 
		while (j < num2)
		{
		    list[k] = R[j];
		    j++;
		    k++;
		}   
	}
	
	public String toString()
	{
		String result = "Merge Sorted List: \n";

		for(int i = 0;i < list.length ;i++)
		{
			result += (list[i] + " ");
		}
		
		result += "\nComparisons: " + comp;
		
		return result;

	}
}
