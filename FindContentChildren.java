package leetCodeJava;

//import java.util.Arrays;

public class FindContentChildren {

    public static int findContentChildren(int[] g, int[] s) {
        
    	bubbleSort(g);
    	bubbleSort(s);
    	
    	ArrayOp.printArray(g);
    	ArrayOp.printArray(s);
    	
    	int count = 0, i = 0;
    	
    	for (int cookie : s)
    	{
    		if (i<g.length && cookie >= g[i])
    		{
    			count++;
    			i++;
    		}    			
    	}
    	
    	return count;
    }
    
    public static void quickSort(int[] arr)
    {
    	doQuickSort(arr, 0, arr.length-1);
    }
    
    public static void doQuickSort(int[] arr, int start, int end)
    {
    	if (start < end)
    	{
    		int mid = partition(arr, start, end);
    		doQuickSort(arr, start, mid-1);
    		doQuickSort(arr, mid+1, end);
    	}
    }
    
    public static int partition(int[] arr, int start, int end)
    {
    	int mid = start + (end-start)/2;
    	swap(arr, start, mid);
    	
    	int pivot = arr[start];
    	int endOfLeftList = start;
    	
    	for (int scan=start+1; scan<=end; scan++)
    	{
    		if (arr[scan] < pivot)
    		{
    			endOfLeftList++;
    			swap(arr, scan, endOfLeftList);
    		}
    	}
    	
    	swap(arr, start, endOfLeftList);
    	
    	return endOfLeftList;
    }
    
    public static void swap(int[] arr, int a, int b)
    {
    	int tmp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = tmp;
    }
    
    public static void selectionSort(int[] arr)
    {
    	int i, j, minValue, minIndex;
    	
    	for (i=0; i<arr.length; i++)
    	{
    		minValue = arr[i];
    		minIndex = i;
    		
    		for (j=i+1; j<arr.length; j++)
    		{
    			if (arr[j] < arr[i])
    			{
    				minValue = arr[j];
    				minIndex = j;
    			}
    		}
    		
    		arr[minIndex] = arr[i];
    		arr[i] = minValue;
    	}
    }
  
	public static void insertionSort(int[] arr)
	{
		int index, unsortedValue, scan;
		
		for (index=1; index<arr.length; index++)
		{
			unsortedValue = arr[index];
			scan = index;
			
			while (scan > 0 && arr[scan] > unsortedValue)
			{
				arr[scan] = arr[scan-1];
				scan--;
			}
			
			arr[scan] = unsortedValue;
		}
	}
	
	public static void bubbleSort(int[] arr)
	{
		for (int last=arr.length-1; last>0; last--)
			for (int index=0; index<last; index++)
			{
				if (arr[index] > arr[index+1]) swap(arr, index, index+1);
			}
	}
	
}

