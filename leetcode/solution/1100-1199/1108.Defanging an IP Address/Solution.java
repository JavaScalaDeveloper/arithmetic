package solution._1108;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
