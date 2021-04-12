package jz_offer.all.JZ28;

public class Solution {
    //哈希法
    /*public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int e : array) {
            if(map.get(e)==null){
                map.put(e,1);
            }else{
                map.put(e,map.get(e)+1);
            }
            if(map.get(e)>array.length/2)
                return e;
        }
        return 0;
    }*/

    //候选人法
    public static int MoreThanHalfNum_Solution(int[] array) {
        int people = 0, tickets = 0;
        // 轮流投票
        for (int e : array) {
            // 新人上任
            if (tickets == 0) {
                people = e;
            }

            // 支持自己，反对别人
            if (people == e) {
                tickets++;
            } else {
                tickets--;
            }
        }

        // 检测该数是否为众数
        tickets = 0;
        for (int e : array) {
            if (e == people && ++tickets > array.length / 2) {
                return people;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
