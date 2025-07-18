package solution._0078;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(num);
                list.add(temp);
            }
            List<Integer> one = new ArrayList<>();
            one.add(num);
            list.add(one);
        }
        list.add(new ArrayList<>());
        return list;
    }
}