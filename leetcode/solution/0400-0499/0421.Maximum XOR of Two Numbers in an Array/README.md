# [421. 数组中两个数的最大异或值](https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array)

[English Version](/solution/0400-0499/0421.Maximum%20XOR%20of%20Two%20Numbers%20in%20an%20Array/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个非空数组，数组中元素为 a<sub>0</sub>, a<sub>1</sub>, a<sub>2</sub>, &hellip; , a<sub>n-1</sub>，其中 0 &le; a<sub>i</sub> &lt; 2<sup>31&nbsp;</sup>。</p>

<p>找到 a<sub>i</sub> 和a<sub>j&nbsp;</sub>最大的异或 (XOR) 运算结果，其中0 &le; <em>i</em>,&nbsp;&nbsp;<em>j</em> &lt; <em>n&nbsp;</em>。</p>

<p>你能在O(<em>n</em>)的时间解决这个问题吗？</p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> [3, 10, 5, 25, 2, 8]

<strong>输出:</strong> 28

<strong>解释:</strong> 最大的结果是 <strong>5</strong> ^ <strong>25</strong> = 28.
</pre>

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public int findMaximumXOR(int[] numbers) {
        int max = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            int current = 1 << i;
            // 期望的二进制前缀
            mask = mask ^ current;
            // 在当前前缀下, 数组内的前缀位数所有情况集合
            Set<Integer> set = new HashSet<>();
            for (int j = 0, k = numbers.length; j < k; j++) {
                set.add(mask & numbers[j]);
            }
            // 期望最终异或值的从右数第i位为1, 再根据异或运算的特性推算假设是否成立
            int flag = max | current;
            for (Integer prefix : set) {
                if (set.contains(prefix ^ flag)) {
                    max = flag;
                    break;
                }
            }
        }
        return max;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
