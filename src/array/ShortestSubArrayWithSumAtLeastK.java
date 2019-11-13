package array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author :DengSiYuan
 * @date :2019/11/13 19:12
 * @desc : 862. 和至少为 K 的最短子数组
 * 【题目】
 *      返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *      如果没有和至少为 K 的非空子数组，返回 -1 。
 * 【示例】
 *      示例 1：
 *          输入：A = [1], K = 1
 *          输出：1
 *      示例 2：
 *          输入：A = [1,2], K = 4
 *          输出：-1
 *      示例 3：
 *          输入：A = [2,-1,2], K = 3
 *          输出：3
 * 【说明】
 *      ① 1 <= A.length <= 50000
 *      ② -10 ^ 5 <= A[i] <= 10 ^ 5
 *      ③ 1 <= K <= 10 ^ 9
 */
public class ShortestSubArrayWithSumAtLeastK {

    /**
     * 超出时间限制
     * @param A
     * @param K
     * @return
     */
    public int shortestSubArray1(int[] A, int K) {
        int min = A.length + 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= K){
                return 1;
            }
            int result = A[i];
            for (int j = i + 1; j < A.length && i != j; j++) {
                result += A[j];
                if (result < K){
                    continue;
                }else {
                    min = min < j - i + 1 ? min : j - i + 1;
                }
            }
        }
        if (min > A.length){
            return -1;
        }
        return min;
    }

    public int shortestSubArray2(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i) {
            P[i + 1] = P[i] + (long) A[i];
        }
        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()]) {
                monoq.removeLast();
            }
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K) {
                ans = Math.min(ans, y - monoq.removeFirst());
            }
            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }

    public static void main(String[] args) {
        ShortestSubArrayWithSumAtLeastK leastK = new ShortestSubArrayWithSumAtLeastK();
        System.out.println(leastK.shortestSubArray1(new int[]{84,-37,32,40,95}, 167));
    }

}
