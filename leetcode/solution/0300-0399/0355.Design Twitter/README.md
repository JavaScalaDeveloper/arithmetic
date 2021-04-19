# [355. 设计推特](https://leetcode-cn.com/problems/design-twitter)

[English Version](/solution/0300-0399/0355.Design%20Twitter/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：</p>

<ol>
	<li><strong>postTweet(userId, tweetId)</strong>: 创建一条新的推文</li>
	<li><strong>getNewsFeed(userId)</strong>: 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。</li>
	<li><strong>follow(followerId, followeeId)</strong>: 关注一个用户</li>
	<li><strong>unfollow(followerId, followeeId)</strong>: 取消关注一个用户</li>
</ol>

<p><strong>示例:</strong></p>

<pre>
Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
twitter.getNewsFeed(1);

// 用户1关注了用户2.
twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -&gt; [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
twitter.getNewsFeed(1);
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
class Twitter {
    class Data {
        int id, tweetId;

        public Data(int id, int tweetId) {
            this.id = id;
            this.tweetId = tweetId;
        }
    }

    private Map<Integer, List<Data>> posts;
    private Map<Integer, Set<Integer>> follows;
    private int id;

    /** Initialize your data structure here. */
    public Twitter() {
        posts = new HashMap<>();
        follows = new HashMap<>();
        id = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!posts.containsKey(userId)) {
            posts.put(userId, new ArrayList<>());
        }
        posts.get(userId).add(new Data(id++, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Data> queue = new PriorityQueue<>(10, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Integer.compare(o2.id, o1.id);
            }
        });
        List<Data> ps = posts.get(userId);
        if (ps != null) {
            for (Data data : ps) {
                queue.offer(data);
            }
        }
        Set<Integer> fs = follows.get(userId);
        if (fs != null) {
            for (int f : fs) {
                ps = posts.get(f);
                if (ps != null) {
                    for (Data data : ps) {
                        queue.offer(data);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10 && !queue.isEmpty(); ++i) {
            res.add(queue.poll().tweetId);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, intg followeeId) {
        if (followerId != followeeId) {
            if (!follows.containsKey(followerId)) {
                follows.put(followerId, new HashSet<>());
            }
            follows.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}

```

### **...**

```

```

<!-- tabs:end -->
