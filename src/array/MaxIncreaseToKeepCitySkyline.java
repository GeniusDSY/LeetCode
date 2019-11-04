package array;

/**
 * @author :DengSiYuan
 * @date :2019/11/4 13:25
 * @desc :
 */
public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int origin = 0;
        int result = 0;
        int length = grid.length;
        int[] maxLine = new int[length];
        int[] maxRow = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                maxLine[i] = maxLine[i] > grid[j][i] ? maxLine[i] : grid[j][i];
                maxRow[i] = maxRow[i] > grid[i][j] ? maxRow[i] : grid[i][j];
                origin += grid[i][j];
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                grid[i][j] = maxLine[j] < maxRow[i] ? maxLine[j] : maxRow[i];
                result += grid[i][j];
            }
        }
        return result - origin;
    }

    public static void main(String[] args) {
        MaxIncreaseToKeepCitySkyline skyline = new MaxIncreaseToKeepCitySkyline();
        int result = skyline.maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}});
        System.out.println(result);
    }

}
