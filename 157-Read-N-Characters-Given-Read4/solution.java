/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
  /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
  public int read(char[] buf, int n) {
    char[] temp = new char[4];
    int count = 0;
    int pos = 0;
    
    while (n > 0) {
      int num = read4(temp);
      if (num == 0) {
        break;
      }
      
      if (n < num) {
        num = n;
      }
      
      count += num;
      n -= num;
      
      for (int i = 0; i < num; i++) {
        buf[pos++] = temp[i];
      }
    }
    
    return count;
  }
}