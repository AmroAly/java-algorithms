import java.lang.Math;

class Main {
  public static void main(String[] args) {
      System.out.println(numberFromBin("1001", 2));
  }

  public static int numberFromBin(String strNum, int base) {
    if(base != 2 && base != 16) return -1;
    int value = 0;
    for(int i = strNum.length()-1; i >= 0; i--) {
      int digit = digitToVal(strNum.charAt(i));
      int exp = strNum.length()-1-i;
      value += digit * Math.pow(base, exp);
    }
    return value;
  }

  private static int digitToVal(char c) {
    return Character.getNumericValue(c);
  }
}