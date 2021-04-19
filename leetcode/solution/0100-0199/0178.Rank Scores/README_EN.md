# [178. Rank Scores](https://leetcode.com/problems/rank-scores)

[中文文档](/solution/0100-0199/0178.Rank%20Scores/README.md)

## Description

<p>Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no &quot;holes&quot; between ranks.</p>

<pre>

+----+-------+

| Id | Score |

+----+-------+

| 1  | 3.50  |

| 2  | 3.65  |

| 3  | 4.00  |

| 4  | 3.85  |

| 5  | 4.00  |

| 6  | 3.65  |

+----+-------+

</pre>

<p>For example, given the above <code>Scores</code> table, your query should generate the following report (order by highest score):</p>

<pre>

+-------+------+

| Score | Rank |

+-------+------+

| 4.00  | 1    |

| 4.00  | 1    |

| 3.85  | 2    |

|&nbsp;3.65  | 3    |

| 3.65  | 3    |

| 3.50  | 4    |

+-------+------+

</pre>

## Solutions

<!-- tabs:start -->

### **SQL**

Use `DENSE_RANK()` to solve this problem.

```sql
DENSE_RANK() OVER (
    PARTITION BY <expression>[{,<expression>...}]
    ORDER BY <expression> [ASC|DESC], [{,<expression>...}]
)
```

Solution:

```sql
# Write your MySQL query statement below
SELECT Score, DENSE_RANK() OVER (ORDER BY Score DESC) 'Rank'
FROM Scores;
```

<!-- tabs:end -->
