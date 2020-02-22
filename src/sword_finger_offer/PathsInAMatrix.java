package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/2/21 21:28
 * @desc : 面试题12.矩阵中的路径
 * 【题目】
 *      请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 *      每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 *      例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *          [["a","b","c","e"],
 *          ["s","f","c","s"],
 *          ["a","d","e","e"]]
 *      但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 【示例】
 *      输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *      输出：true
 *
 *      输入：board = [["a","b"],["c","d"]], word = "abcd"
 *      输出：false
 * 【提示】
 *      1 <= board.length <= 200
 *      1 <= board[i].length <= 200
 */
public class PathsInAMatrix {

    /**
     * 【解法】
     *      【算法原理】
     *          深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。
     *                        DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
     *          剪枝： 在搜索中，遇到这条路不可能和目标字符串匹配成功的情况（
     *                例如：此矩阵元素值和目标字符值不同、路径已访问此元素），则应立即返回，称之为 可行性剪枝 。
     *      【算法剖析】
     *          1、递归参数： 当前元素在 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
     *          2、终止条件：
     *              （1）返回 false：
     *                      ①行列索引越界或②当前矩阵元素与目标字符不同或③当前矩阵元素已访问过（③可合并至②） 。
     *              （2）返回true：k = len(word) - 1，即字符串 word 已匹配完成。
     *          3、递推工作：
     *              （1）标记当前矩阵元素：将board[i][j]值暂存于变量tmp，并修改为字符'/'代表此元素已访问过，防止之后搜索时重复访问。
     *              （2）搜索下一单元格： 朝当前元素的上、下、左、右 四个方向开启下层递归，使用||连接 （代表只需一条可行路径） ，并记录结果至 res 。
     *              （3）还原当前矩阵元素：将tmp暂存值还原至board[i][j]元素。
     *          4、回溯返回值：返回res代表是否搜索到目标字符串。
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if(k == word.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}
