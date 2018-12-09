import java.util.*;

class Main {
  public static void main(String[] args)
  {  
    anagramFinder("abbc", "cbabadcbbabbcbabaabccbabc");    
  }

  static void anagramFinder(String sub, String bigStr)
  {
    int n = sub.length();
    int m = bigStr.length();
    int[] subFreq = new int[256]; // Ascii chars count
    int[] bigStrFreq = new int[256]; // Ascii chars count
    ArrayList strResult = new ArrayList();

    // Build our first window array to compare
    // and the frequency of each char in the sub str
    for(int i = 0; i < n; i++) {
      subFreq[sub.charAt(i)]++;
      bigStrFreq[bigStr.charAt(i)]++;
    }

    for(int j = n, k = 0; j < m; j++, k++) {
    
      if(compare(subFreq, bigStrFreq)) {
        // Get the matched 4chars window 
        strResult.add(bigStr.substring(j-n, n+k));
      }
      // Increase the frequency of the next char
      // and decrease it for the previous one
      bigStrFreq[bigStr.charAt(j)]++;
      bigStrFreq[bigStr.charAt(j-n)]--;
    }
    // check to see the current window
    // contains the same chars
    if(compare(subFreq, bigStrFreq)) {
      strResult.add(bigStr.substring(m-n, m));
    }

    System.out.println(Arrays.toString(bigStrFreq));
    System.out.println(Arrays.toString(strResult.toArray()));
  }

  static boolean compare(int[] arr1, int[] arr2)
  {
    for(int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) return false;
    }
    return true;
  }
}