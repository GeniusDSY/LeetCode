package base.base_algorithm.sort_function;

/**
 * @author :DengSiYuan
 * @date :2020/2/10 16:57
 * @desc : 插入排序
 */
public class InsertSort {

    /**
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     * @param numbers
     */
    public void insertSort(int[] numbers) {
        int size = numbers.length, temp, j;
        for(int i=1; i<size; i++) {
            temp = numbers[i];
            for(j = i; j > 0 && temp < numbers[j-1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
        }
    }
}
