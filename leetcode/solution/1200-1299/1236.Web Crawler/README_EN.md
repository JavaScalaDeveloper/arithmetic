# [1236. Web Crawler](https://leetcode.com/problems/web-crawler)

[中文文档](/solution/1200-1299/1236.Web%20Crawler/README.md)

## Description

<p>Given a url <code>startUrl</code> and an interface <code>HtmlParser</code>, implement a web crawler to crawl all links that are under the <strong>same hostname</strong> as <code>startUrl</code>. </p>

<p>Return all urls obtained by your web crawler in <strong>any</strong> order.</p>

<p>Your crawler should:</p>

<ul>
	<li>Start from the page: <code>startUrl</code></li>
	<li>Call <code>HtmlParser.getUrls(url)</code> to get all urls from a webpage of given url.</li>
	<li>Do not crawl the same link twice.</li>
	<li>Explore only the links that are under the <strong>same hostname</strong> as <code>startUrl</code>.</li>
</ul>

![](./images/urlhostname.png)

<p>As shown in the example url above, the hostname is <code>example.org</code>. For simplicity sake, you may assume all urls use <strong>http protocol</strong> without any <strong>port</strong> specified. For example, the urls <code>http://leetcode.com/problems</code> and <code>http://leetcode.com/contest</code> are under the same hostname, while urls <code>http://example.org/test</code> and <code>http://example.com/abc</code> are not under the same hostname.</p>

<p>The <code>HtmlParser</code> interface is defined as such: </p>

<pre>
interface HtmlParser {
  // Return a list of all urls from a webpage of given <em>url</em>.
  public List<String> getUrls(String url);
}</pre>

<p>Below are two examples explaining the functionality of the problem, for custom testing purposes you'll have three variables <code data-stringify-type="code">urls</code>, <code data-stringify-type="code">edges</code> and <code data-stringify-type="code">startUrl</code>. Notice that you will only have access to <code data-stringify-type="code">startUrl</code> in your code, while <code data-stringify-type="code">urls</code> and <code data-stringify-type="code">edges</code> are not directly accessible to you in code.</p>

<p> </p>
<p><strong>Example 1:</strong></p>

![](./images/sample_2_1497.png)

<pre>
<strong>Input:
</strong>urls = [
  "http://news.yahoo.com",
  "http://news.yahoo.com/news",
  "http://news.yahoo.com/news/topics/",
  "http://news.google.com",
  "http://news.yahoo.com/us"
]
edges = [[2,0],[2,1],[3,2],[3,1],[0,4]]
startUrl = "http://news.yahoo.com/news/topics/"
<strong>Output:</strong> [
  "http://news.yahoo.com",
  "http://news.yahoo.com/news",
  "http://news.yahoo.com/news/topics/",
  "http://news.yahoo.com/us"
]
</pre>

<p><strong>Example 2:</strong></p>

![](./images/sample_3_1497.png)

<pre>
<strong>Input:</strong> 
urls = [
  "http://news.yahoo.com",
  "http://news.yahoo.com/news",
  "http://news.yahoo.com/news/topics/",
  "http://news.google.com"
]
edges = [[0,2],[2,1],[3,2],[3,1],[3,0]]
startUrl = "http://news.google.com"
<strong>Output:</strong> ["http://news.google.com"]
<strong>Explanation: </strong>The startUrl links to all other pages that do not share the same hostname.</pre>

<p> </p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 <= urls.length <= 1000</code></li>
	<li><code>1 <= urls[i].length <= 300</code></li>
	<li><code>startUrl</code> is one of the <code>urls</code>.</li>
	<li>Hostname label must be from 1 to 63 characters long, including the dots, may contain only the ASCII letters from 'a' to 'z', digits  from '0' to '9' and the hyphen-minus character ('-').</li>
	<li>The hostname may not start or end with the hyphen-minus character ('-'). </li>
	<li>See:  <a href="https://en.wikipedia.org/wiki/Hostname#Restrictions_on_valid_hostnames">https://en.wikipedia.org/wiki/Hostname#Restrictions_on_valid_hostnames</a></li>
	<li>You may assume there're no duplicates in url library.</li>
</ul>

## Solutions

<!-- tabs:start -->

### **Python3**

```python

```

### **Java**

```java

```

### **...**

```

```

<!-- tabs:end -->
