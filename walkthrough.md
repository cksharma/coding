# Solution Walkthrough for Codeforces 2165A

## Problem Analysis
We need to merge $n$ numbers arranged on a ring into a single number by repeatedly merging adjacent pairs. Each merge of values $x$ and $y$ costs $\max(x, y)$ and produces $\max(x, y)$.

The challenge is that this is a **circular** structure, which makes it more complex than a linear interval DP problem.

## Key Insight
Since the elements are arranged in a ring, we need to "break" the ring at some position to convert it into a linear problem. The optimal solution might depend on where we break the ring, so we try **all possible break points** and take the minimum.

## Algorithm

### Step 1: Handle Base Cases
- If $n = 1$: No merges needed, cost = 0
- If $n = 2$: One merge, cost = $\max(a_0, a_1)$

### Step 2: Key Optimization - Break Only at Maximum Elements
**Critical Insight**: We don't need to try all $n$ possible break points. We only need to try breaking the ring at positions **adjacent to the maximum element(s)**.

Why? The maximum element will always survive to the end. The optimal break point is always next to a maximum element because:
- Breaking far from the max doesn't change the fundamental structure
- The max element acts as a "barrier" in the merging process

For each maximum element at position $i$:
1. Try breaking at position $i$ (before the max)
2. Try breaking at position $i+1$ (after the max)
3. Create a linear array from that break point
4. Solve using interval DP

### Step 3: Interval DP
For a linear array, we use dynamic programming:
- `dp[i][j]` = minimum cost to merge elements from index $i$ to $j$ into one element
- `mx[i][j]` = maximum element in range $[i, j]$ (precomputed)

**Recurrence:**
```
dp[i][j] = min over all k in [i, j-1] of:
           dp[i][k] + dp[k+1][j] + mx[i][j]
```

The intuition is: to merge range $[i, j]$, we first merge $[i, k]$ and $[k+1, j]$ separately, then merge the two results. The final merge costs $\max$ of all elements in $[i, j]$.

## Complexity
- **Time:** $O(k \cdot n^3)$ where $k$ is the number of maximum elements
  - Usually $k$ is small (often 1-2), making this effectively $O(n^3)$
  - $O(k)$ break points × $O(n^2)$ DP states × $O(n)$ transitions
- **Space:** $O(n^2)$ for DP tables

For $n \leq 200$ and small $k$, this is efficient enough to pass time limits.

## Code
See [Codeforces2165A.cpp](file:///Users/cksharma/Github/coding/Codeforces2165A.cpp)

## Verification

### Test Set 1
```
5
3
1 2 3
4
10 2 11 3
4
2 3 2 3
3
5 1 4
4
2 1 4 3
```

**Output:**
```
5
31
9
9
9
```

### Test Set 2
```
3
4
1 1 3 2
2
0 2
7
1 1 4 5 1 4 1
```

**Output:**
```
6
2
19
```

All outputs verified correct! ✓

