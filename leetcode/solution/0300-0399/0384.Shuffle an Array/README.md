# [384. 打乱数组](https://leetcode-cn.com/problems/shuffle-an-array)

[English Version](/solution/0300-0399/0384.Shuffle%20an%20Array/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>打乱一个没有重复元素的数组。</p>

<p><strong>示例:</strong></p>

<pre>
// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
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
    private int[] src;
    private int[] arr;
    private Random random;

    public Solution(int[] nums) {
        src = nums;
        arr = Arrays.copyOf(src, src.length);
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return src;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = arr.length - 1; i >= 0; --i) {
            swap(i, random.nextInt(i + 1));
        }
        return arr;
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
