package solution._0258;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
  public int addDigits(int num) {
      return (num - 1) % 9 + 1;
  }
}