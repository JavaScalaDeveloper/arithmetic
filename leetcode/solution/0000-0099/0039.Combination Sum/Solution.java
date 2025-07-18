package solution._0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates,target,candidates.length-1, new ArrayList<>(),result);
        return result;
    }

    private void combinationSum(int[] candidates, int target,int length, List<Integer> integers,
                                List<List<Integer>> result) {
        List<Integer> list;
        for (int i = length; i >= 0; i--) {
            int nc = candidates[i];
            if (nc>target) continue;
            list = new ArrayList<>(integers);
            list.add(nc);
            if (nc==target) result.add(list);
            else combinationSum(candidates, target - nc, i, list,result);
        }
    }
}