package Math.LargestPalindromeProduct_479_Steven;

public class LargestPalindromeProduct_479_Steven {
  public static int largestPalindrome(int n) {
    if (n == 1) {
      return 9;
    }

    long upper = (long) Math.pow(10, n) - 1;
    long limit = (long) Math.pow(10, n - 1);

    long size = upper + 1;

    // the number of digits is 2 here 99
    while (size-- >= limit) {
      // start should be 99;
      long start = size;
      String head = String.valueOf(start);

      StringBuilder sb = new StringBuilder();
      sb.append(head);
      sb.reverse();

      String tail = sb.toString();
      sb = new StringBuilder();

      sb.append(head);
      sb.append(tail);

      Long candidate = Long.valueOf(sb.toString());
      // the number of digits is 2
      // 99 * 99 => From 9999 to 11

      for (long i = upper; i * i >= candidate; i--) {
        if (candidate / i > upper) {
          break;
        } else if (candidate % i == 0) {
          return (int) (candidate % 1337);
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int res = largestPalindrome(1);
    System.out.println("Res: " + res);
  }
}
