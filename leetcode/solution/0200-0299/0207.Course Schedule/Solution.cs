using System.Collections.Generic;

import java.util.*;

public class Solution {
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        var indegree = new int[numCourses];
        var edgeCount = prerequisites.Length;
        var edge = new List<int>[numCourses];
        for (var i = 0; i < edgeCount; ++i)
        {
            var child = prerequisites[i][0];
            var parent = prerequisites[i][1];
            if (edge[parent] == null)
            {
                edge[parent] = new List<int>();
            }
            edge[parent].Add(child);
            ++indegree[child];
        }

        var queue = new Queue<int>();
        for (var i = 0; i < numCourses; ++i)
        {
            if (indegree[i] == 0) queue.Enqueue(i);
        }

        var count = 0;
        while (queue.Count > 0)
        {
            var node = queue.Dequeue();
            ++count;
            if (edge[node] != null)
            {
                foreach (var next in edge[node])
                {
                    if (--indegree[next] == 0)
                    {
                        queue.Enqueue(next);
                    }
                }
            }
        }
        return count == numCourses;
    }
}