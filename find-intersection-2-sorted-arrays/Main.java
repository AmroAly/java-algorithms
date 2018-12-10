import java.util.*;

class Main {

  public static void main(String[] args)
  {  
    int[] arr1 = {13, 27, 35, 40, 49, 55, 59};
    int[] arr2 = {17, 35, 39, 40, 55, 58};
    findElementsInCommon(arr1, arr2);
  }

  static void findElementsInCommon(int[] arr1, int[] arr2)
  {
    int i = 0, j = 0;
    int l1 = arr1.length;
    int l2 = arr2.length;
    ArrayList resultArr = new ArrayList();

    while(i < l1 && j < l2)
    {
      if(arr1[i] > arr2[j]) {
        j++;
      } else if(arr1[i] < arr2[j]) {
        i++;
      } else {
        resultArr.add(arr1[i]);
        i++;
        j++;
      }
    }
    System.out.println(Arrays.toString(resultArr.toArray()));
  }
}