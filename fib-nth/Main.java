
class Main {
  public static void main(String[] args) {
    fib(7);
  }

  static void fib(int n) {
    int[] memo = new int[n+1];
    System.out.println(allFib(n, memo));    
  }

  static int allFib(int num, int[] memo) {
    if(num == 0) return 0;
    else if(num == 1) return 1;
    else if(memo[num] > 0) { return memo[num]; }
    memo[num] = allFib(num-1, memo) + allFib(num-2, memo);

    return memo[num];
  }
}