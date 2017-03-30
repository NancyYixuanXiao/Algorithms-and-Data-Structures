package leetCodeJava;

public class ArrayOp {

	public static void printArray(int[] arr)
	{
		for (int i=0; i<arr.length; i++)
		{
			System.out.print(Integer.toString(arr[i]) + ' ');
		}
		System.out.println();
	}
	
	public static void swap(int[] arr, int a, int b)
	{
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
