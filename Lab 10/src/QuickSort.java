
public class QuickSort 
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
		qsort(list, 0, list.length-1);
	}
	
  private void qsort(int arr[], int low, int high)
  {
     if (low < high)
     {
        int pi = partition(arr, low, high);
        qsort(arr, low, pi-1);
        qsort(arr, pi+1, high);
     }
  }
    
	private int partition(int arr[], int low, int high)
	{
		
		int	pivot = arr[high] ;
		
	    int i = (low-1); 
	    for (int j=low; j<=high-1; j++)
	    {
	    	comp++;
	    	if (arr[j] <= pivot)
	        {
	    		i++;
	
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	
	    int temp = arr[i+1];
	    arr[i+1] = arr[high];
	    arr[high] = temp;
	
	    return i+1;
	}
	 
	public String toString()
	{
		String result = "Quick Sorted List: \n";

		for(int i = 0;i < list.length ;i++)
		{
			result += (list[i] + " ");
		}
		
		result += "\nComparisons: " + comp;
		
		return result;

	}

}
