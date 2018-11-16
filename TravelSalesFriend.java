import java.util.*;

public class TravelSalesFriend {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); //num cities
    int flyCost[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        flyCost[i][j] = in.nextInt();
      }
    }

    //after reading the input
    int minCost = getMinCost(n, flyCost);
  }

  public static int getMinCost(int n, int[][] flyCost) {
    // mc[i][j]: min cost if I stop at i and friend stop at j
    int[][] mc = new int[n][n];
    
    /* Base case:
     *   mc[0][0] = 0; [probably all [a][a] should = -1]
     *   
     *   // I: 0, f: j
     *   mc[0][1] = 0;
     *   for (j = 2 ... n - 1)
     *     mc[0][j] = mc[0][j - 1] + flyCost[j - 1][j];
     *   // I: i; f: 0???
     *   for (int i = 1 ... n - 1)
     *     mc[i][0] = mc[i - 1][0] + flyCost[i - 1][i];
     *
     * Iterative:
     *   for (i = 1 ... n - 1) {
     *     for (j = 1 ... n - 1) {
     *       if (i < j) {
     *         if (j - i == 1) {
     *           mc[i][j] = MIN(mc[i - 1][j] + flyCost[i - 1][i], //I fly from i - 1
     *                          mc[i][j - 1] + flyCose[i - 1][j]) //F fly from i - 1
     *         } else {
     *           mc[i][j] = mc[i][j - 1] + flyCost[i][j - 1];
     *         }
     *       } else if (i > j) {
     *         if (i - j == 1) {
     *           mc[i][j] = MIN(mc[j - 1][j] + flyCost[j - 1][i], //I fly from j - 1
     *                          mc[i][j - 1] + flyCost[j - 1][j]) //F fly from j - 1
     *         } else {
     *           mc[i][j] = mc[i - 1][j] + flyCost[i - 1][i];
     *         }
     *        // mc[i][j] = MIN(mc[j - 1][j] + flyCost[j - 1][i]//I at j - 1,
     *                       // mc[i][j - 1] + flyCost[j - 1][j]//F at j - 1);
     *       } else {
     *         // i == j, but do what?
     *       }
     *     }
     *   }
     *
     * Return:
         return //return what????
         return min(mc[i = 0 ... n - 2][n - 1], mc[n - 1][0...n - 2]);
     */

    return 0;
  }
}
