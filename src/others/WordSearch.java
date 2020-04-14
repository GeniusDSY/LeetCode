package others;

/**
 * @author :DengSiYuan
 * @date :2020/4/14 11:15
 * @desc :
 * 【评测题目】
 *      给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *      单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 *      同一个单元格内的字母不允许被重复使用。
 * 【示例】
 *      board =
 *          [
 *              ['A','B','C','E'],
 *              ['S','F','C','S'],
 *              ['A','D','E','E']
 *          ]
 *      给定 word = "ABCCED", 返回 true.
 *      给定 word = "SEE", 返回 true.
 *      给定 word = "ABCB", 返回 false.
 * 根据题意，可以想到的方法
 *      1、先找到第一个满足word首字母的坐标定位
 *      2、然后对坐标进行偏移判断，使用DFS
 *      3、满足条件继续进行步骤2
 *      4、不满足条件则进行回溯重置
 */
public class WordSearch{
        // 二维数组行数
        private int row;
        // 列数
        private int line;
        // 单词
        private String word;
        // 二维网格
        private char[][] board;
        // 标记此路线是否可以行得通
        private boolean[][] flag;
        // 坐标变换方式（上、下、左、右）
        private int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};

        /**
         * 方法入口
         * @param board 二维网格
         * @paam word 要搜索的单词
         */
        public boolean main(char[][] board,String word){
            row = board.length;
            // 如果二维网格为空，直接判断不存在
            if(row == 0){
                return false;
            }
            line = board[0].length;
            flag = new boolean[row][line];
            this.word = word;
            this.board = board;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < line; j++){
                    if(dfs(i, j, 0)){
                        return true;
                    }
                }
            }
            return false;
        }
        // 深度优先搜索
        private boolean dfs(int i, int j, int start){
            // 若为最后一个字母，返回当前是否匹配
            if(start == word.length() - 1){
                return board[i][j] == word.charAt(start);
            }
            // 当前字母匹配，进行flag标记
            if(board[i][j] == word.charAt(start)){
                flag[i][j] = true;
                // 向四个方向进行移动
                for(int k = 0; k < 4; k++){
                    int x = i + direction[k][0];
                    int y = j + direction[k][1];
                    // 判断是否越过边界且当前字母是否已经使用过，进行递归调用判断
                    if((x >= 0 && x < row && y >= 0 && y < line) && !flag[x][y]){
                        if(dfs(x, y, start + 1)){
                            return true;
                        }
                    }
                }
                flag[i][j] = false;
            }
            return false;
        }
}
