package solution._0140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s,wordDict,new HashMap<>(16));
    }
    private List<String> wordBreak(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        List<String> list=new ArrayList<>();
        if(map.containsKey(s))  return map.get(s);
        if("".equals(s)){
            list.add("");
            return list;
        }
        for(String word:wordDict){
            if(s.startsWith(word)){
                List<String> res=wordBreak(s.substring(word.length()),wordDict,map);
                for(String str:res){
                    list.add(word+("".equals(str) ?"":" ")+str);
                }
            }
        }
        map.put(s,list);
        return list;
    }
}