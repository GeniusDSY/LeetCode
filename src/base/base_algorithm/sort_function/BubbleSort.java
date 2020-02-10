package base.base_algorithm.sort_function;

/**
 * @author :DengSiYuan
 * @date :2020/2/10 0:02
 * @desc : 冒泡排序
 */
public class BubbleSort {

    /**
     * 比较相邻的元素。如果第一个比第二个小，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最小的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param array 需要排序的元素
     */
    public void bubbleSort(int[] array){
        int temp; // 记录临时中间值
        int size = array.length; // 数组大小
        for(int i = 1; i < size; i++) {
            for(int j = 0; j < size - i; j++) {
                if(array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j]=array[j + 1];
                    array[j + 1]=temp;
                }
            }
        }
    }
}
