package jz_offer.src.medium.JZ41;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int l = 1;
        int r = 2;
        list.add(l);
        list.add(r);
        while (l < (sum + 1) / 2) {
            int temp = cal(l, r);
            if (temp < sum) {
                r++;
                list.add(r);
            } else if (temp == sum) {
                //加入到ans中需要新生成一个对象，不然会随着引用list不断改变
                ans.add(new ArrayList<>(list));
                r++;
                list.add(r);
            } else {
                l++;
                list.remove(0);
            }
        }
        return ans;
    }

    /**
     * 求连续数组的平均值*步长
     * 例如，l=18，r=22,连续数组为[18	19	20	21	22] 计算结果为100
     * @param l 左值
     * @param r 右值
     * @return 结果
     */
    public static int cal(int l, int r) {
        return (l + r) * (r - l + 1) / 2;
    }

    /**
     * 可以使用双指针来解决这个问题。设定两个指针small和big，分别表示序列的最小值和最大值。开始时，small和big都指向1，此时序列和为1。
     *
     * 如果当前序列和sum小于目标值target，则向右移动big，使得序列包含更多的数字，即序列和增加。
     * 如果当前序列和sum大于目标值target，则向右移动small，使得序列去掉最左边的数字，即序列和减小。
     * 如果当前序列和sum等于目标值target，则把序列存储起来，并将small右移一位，以便寻找下一个符合条件的序列。
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence2(int target) {
        List<int[]> res = new ArrayList<>();
        int small = 1, big = 1;
        int sum = 1;
        while (big <= target / 2 + 1) { // 当big超过target的一半时，序列已经不可能再满足要求
            if (sum < target) {
                big++;
                sum += big;
            } else if (sum > target) {
                sum -= small;
                small++;
            } else {
                int[] arr = new int[big - small + 1];
                for (int i = small; i <= big; i++) {
                    arr[i - small] = i;
                }
                res.add(arr);
                sum -= small;
                small++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        System.out.println(findContinuousSequence(100));
        int[][] arr = findContinuousSequence2(100);
        for (int i = 0; i < arr.length; i++) {
            int[] arr2 = arr[i];
            for (int i1 : arr2) {
                System.out.print(i1+"\t");
            }
            System.out.println();
        }
    }
}
