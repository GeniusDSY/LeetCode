package base.base_algorithm.sort_function;

/**
 * @author :DengSiYuan
 * @date :2020/2/10 20:18
 * @desc : 希尔排序
 */
public class ShellSort {

    /**
     * 将待排序的数组元素分成多个子序列
     * 对各个子序列分别进行直接插入排序
     * 待整个待排序列“基本有序”后，最后在对所有元素进行一次直接插入排序
     * @param data
     */
    public static void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
    }
}
