package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/13 22:12
 * @desc : 999.车的可用捕获量
 * 【题目】
 *      在一个 board.length x board.length 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 *      车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 *
 *      返回车能够在一次移动中捕获到的卒的数量。
 * 【示例】
 *      ![](https://user-gold-cdn.xitu.io/2019/9/14/16d2dcbd3a251c5d?w=597&h=606&f=png&s=24628)
 *      输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 *      输出：3
 *      解释：
 *      在本例中，车能够捕获所有的卒。
 */
public class AvailableCapturesForRook {

    /**
     * 【个人思路】
     *      先找到军所在的位置，然后在控制分别控制x轴、y轴不变进行遍历寻找卒和象。
     *      （1）遇到第一个卒就进行++并跳出本次循环并进行下一次循环
     *      （2）遇到象就跳出本次循环进行下一次循环
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 'R') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'B') {break;}
                        if (board[i][k] == 'p') {
                            result++;
                            break;
                        }
                    }
                    for (int k = j + 1; k < board.length; k++) {
                        if (board[i][k] == 'B') {break;}
                        if (board[i][k] == 'p') {
                            result++;
                            break;
                        }
                    }
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'B') {break;}
                        if (board[k][j] == 'p') {
                            result++;
                            break;
                        }
                    }
                    for (int k = i + 1; k < board.length; k++) {
                        if (board[k][j] == 'B') {break;}
                        if (board[k][j] == 'p') {
                            result++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 【LeetCode 解法】
     *      【想法】
     *          (1)找到军所在的索引位置，以该索引为原点建立平面直角坐标系
     *          (2)从该坐标分别向上下左右寻找满足要求的元素
     * @param board
     * @return
     */
    public int numRookCaptures1(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                //找到R的位置
                if(board[i][j]=='R'){
                    //以R 为原点建立坐标系
                    //依次向上找,向下找,向右找,向左找
                    return cap(board,i,j,0,1)+cap(board,i,j,0,-1)+cap(board,i,j,1,0)+cap(board,i,j,-1,0);
                }
            }
        }
        return 0;
    }
    public int cap(char[][] a,int x,int y,int dx,int dy){
        /*参数说明
         *a为原数组矩阵
         *x,y为R的坐标
         *dx,dy为增长步长
         */
        while(x>=0 && x<a.length && y>=0 && y<a[x].length && a[x][y]!='B'){
            if(a[x][y]=='p'){
                return 1;
            }
            x+=dx;
            y+=dy;
        }
        return 0;
    }

    public static void main(String[] args) {
        AvailableCapturesForRook rook = new AvailableCapturesForRook();
        char[][] arr = new char[][]{{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        long start = System.nanoTime();
        int result = rook.numRookCaptures(arr);
        long end = System.nanoTime();
        System.out.println("吃掉：" + result + "个");
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = rook.numRookCaptures1(arr);
        end = System.nanoTime();
        System.out.println("吃掉：" + result + "个");
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
