package jz_offer.all.JZ63;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.*;

public class Solution {
    private List<Double> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num.doubleValue());
        Collections.sort(list);
    }

    public Double GetMedian() {
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2);
        } else {
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        }
    }
}
