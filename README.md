# Lowest-Common-Ancestor

# Solution Constraints and Definitions
1. My implemnetation (both the Binary Tree and Directed Acyclic Grap one) will only find the Lowest Common Ancestor for **TWO** target nodes.

2. My implementation for a Directed Acyclic Graph uses the existance of a root to calculate the depth of each Ancestor. This means that if there are multiple roots only one root is selected. The selected root will always be the first vertex in the list of vertices contained in the Directed Acyclic Graph with indegree = 0.

3. My definition of Lowest Common Ancestor (for a DAG) goes as follows: The deepest common ancestor between nodes v and w.

4. My definition of depth (for a DAG) is as follows: Distance (in number of edges) between a vertex and a selected root.

5. My definition of root (for a DAG) is as follows: First vertex in the list of vertices which represent the graph which has an indegree (the number of edges directed into a vertex in a directed graph) of 0.

6. If there are more than one LCAs (for a DAG) only the first one (relative to the list of vertices) is returned. 
