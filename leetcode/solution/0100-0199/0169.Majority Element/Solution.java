package solution._0169;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int res=nums[0];
        for(int i=1; i<nums.length; i++){
            if(res==nums[i])
                count++;
            else{
                count--;
                if(count==0)
                    res=nums[i+1];
            }
        }
        return res;
    }
}