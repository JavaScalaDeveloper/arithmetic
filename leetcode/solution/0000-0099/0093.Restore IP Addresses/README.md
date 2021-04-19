# [93. 复原 IP 地址](https://leetcode-cn.com/problems/restore-ip-addresses)

[English Version](/solution/0000-0099/0093.Restore%20IP%20Addresses/README_EN.md)

## 题目描述

<!-- 这里写题目描述 -->
<p>给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> &quot;25525511135&quot;
<strong>输出:</strong> <code>[&quot;255.255.11.135&quot;, &quot;255.255.111.35&quot;]</code></pre>

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
    private List<String> result;
    private int length;
    public List<String> restoreIpAddresses(String s) {
        result  = new ArrayList<>();
        length = s.length();
        int[] ip = new int[4];
        restoreIpAddresses(s,0,ip,0);
        return result;
    }
    private void restoreIpAddresses(String s, int si, int[] ip, int pi) {
        int sl = length - si , pl = 3 - pi , i = -1;
        String pfx = null;
        while (si< length){
            int num = s.charAt(si++) - '1' + 1;
            if (i==0) break;
            i = i == -1 ? num : i * 10 + num;
            sl--;
            if (i>255) break;
            if (sl < pl || sl > pl * 3) continue;
            if (pi==3){
                if (pfx==null){
                    StringBuilder pfxBuilder = new StringBuilder();
                    for (int j = 0; j < ip.length-1; j++) pfxBuilder.append(ip[j]).append('.');
                    pfx = pfxBuilder.toString();
                }
                result.add(pfx + i);
            }
            ip[pi] = i;
            restoreIpAddresses(s,si,ip,pi+1);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
