package others;

/**
 * @author :DengSiYuan
 * @date :2020/4/14 18:26
 * @desc :
 * 【题目】     最大办公人数
 *      ‘*’位置无电源，不可坐人
 *      '.'可以坐人
 *      疫情期间，不能连续坐人，求最大办公人数
 */
public class MaxStaffs {

    private static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

    public static int getMaxStaffs (char[][] pos) {
        // write code here
        int usable = 0;
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                if (pos[i][j] == '*'){
                    continue;
                }
                if (pos[i][j] == '.'){
                    usable++;
                    for (int k = 0; k < 4; k++) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if (x >= 0 && x < pos.length && y >= 0 && y < pos[0].length){
                            if (pos[x][y] == '.'){
                                pos[x][y] = '*';
                            }
                        }
                    }
                }
            }
        }
        return usable;
    }

    public static void main(String[] args) {
        System.out.println(getMaxStaffs(new char[][]{{'.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.'}}));
    }

}
