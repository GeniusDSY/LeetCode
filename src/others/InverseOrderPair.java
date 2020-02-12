package others;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2020/2/3 12:29
 * @desc :
 */
public class InverseOrderPair {

    static int count;//静态全局变量，表示逆序对的个数
    public static void niXuDui(int[] array,int[] num){
        for (int i = 0; i <num.length ; i++) {
            count=0;
            array=reverse(array,num[i]);//每次更新翻转后的数组
            System.out.println(count);//输出逆序对值
        }
    }
    public static int[] reverse(int[] nums,int k){//翻转处理求逆序对函数
        int i = (nums.length/(int) (Math.pow(2.0,(double)k))),j=0,o=0;
        while(j<i){
            reverse(nums,o,o+(int) (Math.pow(2.0,(double)k))-1);
            o+=(int) (Math.pow(2.0,(double)k));
            j++;
        }
        int[] a= new int[nums.length];
        a= Arrays.copyOf(nums,nums.length);
        merge(nums,0,nums.length-1);
        return a;
    }

    public static void reverse(int[] chars,int low,int high){//翻转函数
        while(low<high){
            int temp=chars[low];
            chars[low]=chars[high];
            chars[high]=temp;
            low++;
            high--;
        }
    }
    //归并排序求逆序对
    public static void merge(int[] array,int low,int high){
        if(low>=high) return;
        int mid =low+(high-low)/2;
        merge(array,low,mid);
        merge(array,mid+1,high);
        mergeSort(array,low,mid,high);
    }
    public static void mergeSort(int[] array,int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i=low,j=mid+1,k=0;
        while(i<=mid&&j<=high){
            if(array[i]<=array[j]){
                temp[k++]=array[i++];
            }else{
                count+=mid-i+1;
                count%=1000000007;
                temp[k++]=array[j++];
            }
        }
        while(i<=mid){
            temp[k++]=array[i++];
        }
        while(j<=high){
            temp[k++]=array[j++];
        }
        for (int l = 0; l<temp.length ; l++) {
            array[l+low]=temp[l];
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,1,4,3};
        int[] ciShu = new int[]{1,2,0,2};
        niXuDui(num,ciShu);
    }
}
