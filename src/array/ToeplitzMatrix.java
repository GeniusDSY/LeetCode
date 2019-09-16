package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/16 16:17
 * @desc : 766.托普利茨矩阵
 * 【题目】
 *      如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 *      给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * 【示例】
 *      输入:
 *      matrix = [
 *                  [1,2,3,4],
 *                 [5,1,2,3],
 *                [9,5,1,2]
 *              ]
 *      输出: True
 *      解释:
 *          在上述矩阵中, 其对角线为:"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 *          各条对角线上的所有元素均相同, 因此答案是True。
 * 【说明】
 *      matrix 是一个包含整数的二维数组。
 *      matrix 的行数和列数均在 [1, 20]范围内。
 *      matrix[i][j] 包含的整数在 [0, 99]范围内。
 * 【进阶】
 *      如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
 *      如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
 */
public class ToeplitzMatrix {

    /**
     * 【想法】
     *      （1）分两部分判断，上三角和下三角（下面以示例介绍想法）
     *      （2）上三角部分：遍历第一个子数组的元素并记录，然后内部不停进行++与记录元素对比，只要遇到一个不一样的就直接跳出循环返回false
     *      （3）下三角部分：从第二个子数组（因为我们把第一组的首元素归到了上三角部分）开始遍历每个子数组的第一个元素并记录，然后进行++进行对比，若遇到不相等则直接跳出循环进行返回false
     * @param matrix
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(M*N) M*N = a.length * a[0].length
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int temp;
        for (int i = 0,m = 0; i < matrix[0].length; i = ++m) {
            int j = 0;
            temp = matrix[j][i];
            while (j++ < matrix.length-1 && i++ < matrix[0].length-1){
                if(matrix[j][i] != temp){
                    return false;
                }
            }
        }
        for (int i = 1,m = 0; i < matrix.length; i = ++m) {
            int j = 0;
            temp = matrix[i][j];
            while (j++ < matrix[0].length-1 && i++ < matrix.length-1){
                if(matrix[i][j] != temp){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 【想法】
     *      每个元素只需要与他右下角那一个进行对比，也就是横纵坐标分别+1，只要两两有一个不相等就直接返回false
     * @param matrix
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(M*N) M*N = a.length * a[0].length
     */
    public boolean isToeplitzMatrix1(int[][] matrix) {
        for(int i=0;i<matrix.length-1;i++){
            for(int j=0;j<matrix[0].length-1;j++){
                if(matrix[i][j]!=matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3,4,5,6},{6,1,2,3,4,5},{5,6,1,2,3,4},{4,5,6,1,2,3},{3,4,5,6,1,2},{2,3,4,5,6,1,2}};
        ToeplitzMatrix matrix = new ToeplitzMatrix();
        long start = System.nanoTime();
        boolean result = matrix.isToeplitzMatrix(arr1);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = matrix.isToeplitzMatrix1(arr1);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
