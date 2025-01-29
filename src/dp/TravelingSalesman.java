package dp;

public class TravelingSalesman {

    // Function to find the minimum cost using dynamic programming
    public static int tsp(int[][] dist) {
        int n = dist.length;

        // dp[mask][i] will store the minimum cost to visit all cities in 'mask'
        // and end at city 'i'
        int[][] dp = new int[1 << n][n];

        // Initialize dp array with a large number (infinity)
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Start at city 0, so the cost to start at city 0 with only city 0 visited is 0
        dp[1][0] = 0;

        // Iterate over all subsets of cities
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                // If city u is part of the current subset
                if ((mask & (1 << u)) != 0) {
                    // Try to come to city u from another city v
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) != 0 && u != v) {
                            dp[mask][u] = Math.min(dp[mask][u], dp[mask ^ (1 << u)][v] + dist[v][u]);
                        }
                    }
                }
            }
        }

        // We need to return to the starting city (city 0)
        int finalMask = (1 << n) - 1; // All cities visited
        int result = Integer.MAX_VALUE;

        // Find the minimum cost to visit all cities and return to city 0
        for (int i = 1; i < n; i++) {
            if (dp[finalMask][i] != Integer.MAX_VALUE) {
                result = Math.min(result, dp[finalMask][i] + dist[i][0]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example distance matrix (4 cities)
        int[][] dist = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        System.out.println("Minimum cost: " + tsp(dist));
    }
}

