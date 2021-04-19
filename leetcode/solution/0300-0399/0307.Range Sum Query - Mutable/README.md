# [307. 区域和检索 - 数组可修改](https://leetcode-cn.com/problems/range-sum-query-mutable)

[English Version](/solution/0300-0399/0307.Range%20Sum%20Query%20-%20Mutable/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个整数数组 &nbsp;<em>nums</em>，求出数组从索引&nbsp;<em>i&nbsp;</em>到&nbsp;<em>j&nbsp;&nbsp;</em>(<em>i</em>&nbsp;&le;&nbsp;<em>j</em>) 范围内元素的总和，包含&nbsp;<em>i,&nbsp; j&nbsp;</em>两点。</p>

<p><em>update(i, val)</em> 函数可以通过将下标为&nbsp;<em>i&nbsp;</em>的数值更新为&nbsp;<em>val</em>，从而对数列进行修改。</p>

<p><strong>示例:</strong></p>

<pre>Given nums = [1, 3, 5]

sumRange(0, 2) -&gt; 9
update(1, 2)
sumRange(0, 2) -&gt; 8
</pre>

<p><strong>说明:</strong></p>

<ol>
	<li>数组仅可以在&nbsp;<em>update&nbsp;</em>函数下进行修改。</li>
	<li>你可以假设 <em>update</em> 函数与 <em>sumRange</em> 函数的调用次数是均匀分布的。</li>
</ol>

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
public class NumArray {	int[] array, helper;

	public NumArray(int[] nums) {

		array = new int[nums.length];
		helper = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			array[i] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			add(i + 1, nums[i]);
		}
	}

	private void add(int pos, int value) {
		// TODO Auto-generated method stub
		while (pos < helper.length) {
			helper[pos] += value;
			pos += lowBit(pos);
		}
	}

	private int lowBit(int pos) {

		return pos & (-pos);
	}

	private int sum(int pos) {

		int rt = 0;

		while (pos > 0) {
			rt += helper[pos];
			pos -= lowBit(pos);
		}

		return rt;
	}

	void update(int i, int val) {
		int delta = val - array[i];
		array[i] = val;
		add(i + 1, delta);
	}

	public int sumRange(int i, int j) {

		return sum(j + 1) - sum(i);
	}}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
```

### **...**

```

```

<!-- tabs:end -->
