# [380. 常数时间插入、删除和获取随机元素](https://leetcode-cn.com/problems/insert-delete-getrandom-o1)

[English Version](</solution/0300-0399/0380.Insert%20Delete%20GetRandom%20O(1)/README_EN.md>)

## 题目描述

<!-- 这里写题目描述 -->
<p>设计一个支持在<em>平均&nbsp;</em>时间复杂度 <strong>O(1)</strong>&nbsp;下，执行以下操作的数据结构。</p>

<ol>
	<li><code>insert(val)</code>：当元素 val 不存在时，向集合中插入该项。</li>
	<li><code>remove(val)</code>：元素 val 存在时，从集合中移除该项。</li>
	<li><code>getRandom</code>：随机返回现有集合中的一项。每个元素应该有<strong>相同的概率</strong>被返回。</li>
</ol>

<p><strong>示例 :</strong></p>

<pre>
// 初始化一个空的集合。
RandomizedSet randomSet = new RandomizedSet();

// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
randomSet.insert(1);

// 返回 false ，表示集合中不存在 2 。
randomSet.remove(2);

// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
randomSet.insert(2);

// getRandom 应随机返回 1 或 2 。
randomSet.getRandom();

// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
randomSet.remove(1);

// 2 已在集合中，所以返回 false 。
randomSet.insert(2);

// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
randomSet.getRandom();
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
class RandomizedSet {

	private List<Integer> list;
	private Map<Integer, Integer> map;
	private Random random;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
		random = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}

		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}

		int index = map.get(val);
		list.set(index, list.get(list.size() - 1));
		map.put(list.get(index), index);
		map.remove(val);
		list.remove(list.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		if (list.size() == 0) {
			return 0;
		}

		return list.get(random.nextInt(list.size()));
	}
}

```

### **...**

```

```

<!-- tabs:end -->
