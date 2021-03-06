# [703. 数据流中的第 K 大元素](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream)

[English Version](/solution/0700-0799/0703.Kth%20Largest%20Element%20in%20a%20Stream/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。</p>

<p>你的&nbsp;<code>KthLargest</code>&nbsp;类需要一个同时接收整数&nbsp;<code>k</code> 和整数数组<code>nums</code>&nbsp;的构造器，它包含数据流中的初始元素。每次调用&nbsp;<code>KthLargest.add</code>，返回当前数据流中第K大的元素。</p>

<p><strong>示例:</strong></p>

<pre>
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);&nbsp; &nbsp;// returns 4
kthLargest.add(5);&nbsp; &nbsp;// returns 5
kthLargest.add(10);&nbsp; // returns 5
kthLargest.add(9);&nbsp; &nbsp;// returns 8
kthLargest.add(4);&nbsp; &nbsp;// returns 8
</pre>

<p><strong>说明: </strong><br />
你可以假设&nbsp;<code>nums</code>&nbsp;的长度&ge;&nbsp;<code>k-1</code>&nbsp;且<code>k</code> &ge;&nbsp;1。</p>

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
class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int size;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        size = k;
        for (int e : nums) {
            add(e);
        }
    }

    public int add(int val) {
        if (minHeap.size() < size) {
            minHeap.add(val);
        } else {
            if (minHeap.peek() < val) {
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
```

### **...**

```

```

<!-- tabs:end -->
