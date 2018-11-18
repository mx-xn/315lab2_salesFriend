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
   //int[][] recover = new int[n][n];
   int minCost = getMinCost(n, flyCost);
   System.out.println("minCost: " +minCost);
  }

  public static int getMinCost(int n, int[][] flyCost) {
    // mc[i][j]: min cost if I stop at i and friend stop at j
    int[][] mc = new int[n][n];
    //Base case
    mc[0][0] = 0;
    mc[0][1] = 0;

    //I stay, friend flies
    for (int j = 2; j < n; j++){
      mc[0][j] = mc[0][j-1] + flyCost[j-1][j];
    }

    //friend stays, I fly
    for (int i = 1; i < n; i++){
      mc[i][0] = mc[i-1][0] + flyCost[i-1][i];
    }


    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        if (i < j) {
          if (j - i == 1) {
            // choose from which city prior than i friend flies to j
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < i; k++){
              //if (k == 1) continue;
              int fc = flyCost[k][j];

              // if friend starts at j
              if (k == 0) 
                fc = 0;

              if (min > mc[i][k] + fc) {
                min = mc[i][k] + fc;
                //recover[i][j] = min;
              }
            }
            mc[i][j] = min;
          }
          else {
            mc[i][j] = mc[i][j - 1] + flyCost[j-1][j];
          }
        }

        else if (i > j) {
          if (i - j == 1) {
            // choose from which city prior to j I fly from
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < j; k++){
              //if (k == 1) continue;
              if (min > mc[k][j] + flyCost[k][i]){
                min = mc[k][j] + flyCost[k][i];
                //recover[i][j] = min;
              }
            }
            mc[i][j] = min;
          }
          else {
            mc[i][j] = mc[i - 1][j] + flyCost[i - 1][i];
          }
        }
      }
    }
    /*
    for (int[] j : mc){
      for (int i : j){
        System.out.println(i);
      }
    }
    */
    int min = Integer.MAX_VALUE;
    //System.out.println("Friend ends");
    for (int i = 0; i < n - 1; i++) {
      min = (mc[i][n-1] < min) ? mc[i][n-1] : min;
    }

    //System.out.println("I end");
    for (int j = 0; j < n - 1; j++) {
      min = (mc[n-1][j] < min) ? mc[n-1][j] : min;
    }
    return min;
  }
}
