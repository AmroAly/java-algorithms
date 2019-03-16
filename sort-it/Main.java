import java.util.*;

class Main {
  public static void main(String[] args) {
    int[] arr = {7,2,1,6,8,5,3,4};
    System.out.println(Arrays.toString(quick_sort(arr, 0, 7)));
  }

  public static int partion(int[] arr, int start, int end)
  {
    int pivot = arr[end];
    int pIndex = start;
    for(int i = start; i < end; i++)
    {
      if(arr[i] <= pivot)
      {
        int tmp = arr[i];
        arr[i] = arr[pIndex];
        arr[pIndex] = tmp;
        pIndex++;
      }
    }
    int tmp = arr[end];
    arr[end] = arr[pIndex];
    arr[pIndex] = tmp;
    return pIndex;
  }

  public static int[] quick_sort(int[] arr, int start, int end)
  {
    if(start < end)
    {
      int pIndex = partion(arr, start, end);
      quick_sort(arr, start, pIndex-1);
      quick_sort(arr, pIndex+1, end);
    }
    return arr;
  }

  public static int[] merge(int[] left, int[] right)
  {
    int i = 0, j = 0, k = 0, leftN = left.length, rightN = right.length;
    int[] mergedArr = new int[leftN + rightN];
    while(i < leftN && j < rightN)
    {
      if(left[i] <= right[j])
      {
        mergedArr[k] = left[i];
        i++;
      } else {
        mergedArr[k] = right[j];
        j++;
      }
      k++;
    }
    while(i < leftN)
    {
      mergedArr[k] = left[i];
      k++;
      i++;
    }
    while(j < rightN)
    {
      mergedArr[k] = right[j];
      k++;
      j++;
    }
    System.out.println(Arrays.toString(mergedArr));

    return mergedArr;
  }

  public static int[] merge_sort(int[] arr)
  {
    int n = arr.length;
    if(n < 2)
    {
      return arr;
    }
    int[] left = Arrays.copyOfRange(arr, 0, n/2);
    int[] right = Arrays.copyOfRange(arr, n/2, n);
    left = merge_sort(left);
    right = merge_sort(right);
    return merge(left, right);    
  }

  public static int[] insertion_sort(int[] arr) {
    
    int n = arr.length; 
    for (int i=1; i<n; ++i) 
    { 
        int key = arr[i]; 
        int j = i-1; 

        /* Move elements of arr[0..i-1], that are 
            greater than key, to one position ahead 
            of their current position */
        while (j>= 0 && key < arr[j]) 
        { 
          arr[j+1] = arr[j]; 
          arr[j] = key; 
          j = j-1; 
        } 
    } 

    return arr;
  }

  public static int[] selection_sort(int[] arr) {
    for(int i = 0; i < arr.length-1; i ++) {
      int min = i;
      // int minVal = arr[i];
      for(int j = i+1; j < arr.length; j++) {
        if(arr[i] > arr[j]) {
          min = j;
        }
      }
      int tmp = arr[i];
      arr[i] = arr[min];
      arr[min] = tmp;
    }
    return arr;
  }

  public static int[] bubble_sort(int[] arr) {
    for(int i = 1; i < arr.length; i++) {
      for(int j = 0; j < arr.length-1; j++) {
        if(arr[j] > arr[j+1]) {
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    }
    return arr;
  }
}