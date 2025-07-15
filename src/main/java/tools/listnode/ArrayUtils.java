package tools.listnode;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    public static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        return list;
    }
}
