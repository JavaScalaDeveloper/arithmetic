# [146. LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache)

[English Version](/solution/0100-0199/0146.Lru%20Cache/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>运用你所掌握的数据结构，设计和实现一个&nbsp; <a href="https://baike.baidu.com/item/LRU" target="_blank">LRU (最近最少使用) 缓存机制</a>。它应该支持以下操作： 获取数据 <code>get</code> 和 写入数据 <code>put</code> 。</p>

<p>获取数据 <code>get(key)</code> - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。<br>
写入数据 <code>put(key, value)</code> - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。</p>

<p><strong>进阶:</strong></p>

<p>你是否可以在&nbsp;<strong>O(1)</strong> 时间复杂度内完成这两种操作？</p>

<p><strong>示例:</strong></p>

<pre>LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
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
//双向链表的节点
class Node{
    public int key;
    public int val;
    public Node pre;//指向前面的指针
    public Node next;//指向后面的指针
    public Node(int key,int value){
        this.val = value;
        this.key = key;
    }
}
class LRUCache {
    int capacity;//容量
    Node head;//双向链表的头，维护这个指针，因为set,get时需要在头部操作
    Node end;//双向链表的尾，set时，要是满了，需要将链表的最后一个节点remove
    HashMap<Integer,Node> map = new HashMap<Integer,Node>();//hash表
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    //添加，删除尾部，插入头部的操作
    public void remove(Node node){
        Node cur = node;
        Node pre = node.pre;
        Node post = node.next;
        if(pre == null){//说明cur是头部节点
            head = post;
        }
        else pre.next = post;//更新指针，删除
        if(post == null){//说明cur是最后的节点
            end = pre;
        }
        else post.pre = pre;
    }
    public void setHead(Node node){
        //直接插入
        node.next = head;
        node.pre = null;
        if(head != null) head.pre = node;//防止第一次插入时为空
        head = node;
        if(end==null) end = node;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            //需要把对应的节点调整到头部
            Node latest = map.get(key);
            remove(latest);
            setHead(latest);
            //返回value
            return latest.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){//这个key原来存在
            //只需要把key对应的node提到最前面，更新value
            Node oldNode = map.get(key);
            oldNode.val = value;
            remove(oldNode);
            setHead(oldNode);
        }
        else{
            //这个key原来不存在，需要重新new出来
            Node newNode = new Node(key,value);
            //接下来要考虑容量
            if(map.size() < capacity){
                setHead(newNode);
                map.put(key, newNode);
            }
            else{
                //容量不够，需要先将map中,最不常使用的那个删除了删除
                map.remove(end.key);
                //接下来更新双向链表
                remove(end);
                setHead(newNode);
                //放入新的
                map.put(key, newNode);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

### **...**

```

```

<!-- tabs:end -->
