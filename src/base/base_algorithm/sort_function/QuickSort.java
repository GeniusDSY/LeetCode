package base.base_algorithm.sort_function;

/**
 * @author :DengSiYuan
 * @date :2020/2/10 15:50
 * @desc : 快速排序
 */
public class QuickSort {

    /**
     * 从数列中挑出一个元素，称为“基准”
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，
     * 该基准是它的最后位置。这个称为分割（partition）操作。
     * 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param numbers 待排数组
     * @param start 起始索引
     * @param end 结束索引
     */
    public void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end)) {
                    i++;
                }
                while ((numbers[j] > base) && (j > start)) {
                    j--;
                }
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                quickSort(numbers, start, j);
            }
            if (end > i) {
                quickSort(numbers, i, end);
            }
        }
    }

    public void quickSort1(int[] a, int start, int end) {
        if(start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int base = a[start];
        while(i != j) {
            while(a[j] >= base && j > i)
                j--;
            while(a[i] <= base && i < j)
                i++;
            if(i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[start] = a[i];
        a[i] = base;
        quickSort1(a, start, i - 1);
        quickSort1(a, i + 1, end);
    }

}
