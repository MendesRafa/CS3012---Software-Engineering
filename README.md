# Lowest-Common-Ancestor

# Solution Constraints and Definitions
1. My implemnetation (both the Binary Tree and Directed Acyclic Grap one) will only find the Lowest Common Ancestor for **TWO** target nodes.

2. My implementation for a Directed Acyclic Graph uses the existance of a root to calculate the depth of each Ancestor. This means that if there are multiple roots only one root is selected. The selected root will always be the first vertex in the list of vertices contained in the Directed Acyclic Graph with indegree = 0.

3. My definition of Lowest Common Ancestor (for a DAG) goes as follows: The deepest common ancestor between nodes v and w.

4. My definition of depth (for a DAG) is as follows: Distance (in number of edges) between a vertex and a selected root.

5. My definition of root (for a DAG) is as follows: First vertex in the list of vertices which represent the graph which has an indegree (the number of edges directed into a vertex in a directed graph) of 0.

6. If there are more than one LCAs (for a DAG) only the first one (relative to the list of vertices) is returned. 

# Instructions for running the test suite
1. Make sure you have Eclipse installed in your machine

2. Clone the repo into your local machine

3. Open Eclipse and go to File, Click on and select the Lowest Common Ancestor folder

4. Open the test files and run them individually (Note: Test Coverage for each test file should only apply to the corresponding code file and not the project as a whole)

# Where to find each assignment
Assignment 1 (Simple LCA): Because I have merged the other two parts into master, my submission for Part 1 can only be found by cherry-pick the commit with the sha 3880c223e9f0598674f61ff1e5c1af4662bc0863.

Assignment 2 (DAG LCA): You can simply take the Lowest Common Ancestor folder from master to be my submission.

Assignment 3 (Biograh): You can simply take the PDF found in the Biography folder in the master branch.

