package others;

/**
 * @author :DengSiYuan
 * @date :2020/3/6 17:28
 * @desc :// 实现一个有界循环队列，不可使用容器，语言为java
 * // 示例：
 * // add(1) --> {1}
 * // add(2) --> {1,2}
 * // add(3) --> {1,2,3}
 * // add(4) --> {2,3,4}
 */
public class LoopQueue<T> {

    //默认长度
    private int DEFAULT_SIZE = 3;
    //保存数组的长度
    private int capacity;
    //定义一个数组用于保存循环队列的元素
    private Object[] elements;
    //队头
    private int front = 0;
    //队尾
    private int rear = 0;

    //以默认数组长度创建空循环队列
    public LoopQueue() {
        capacity = DEFAULT_SIZE;
        elements = new Object[capacity];
    }

    //以一个初始化元素来创建循环队列
    public LoopQueue(T element) {
        this();
        elements[0] = element;
        rear++;
    }

    /**
     * 以指定长度的数组来创建循环队列
     * @param element 指定循环队列中第一个元素
     * @param initSize 指定循环队列底层数组的长度
     */
    public LoopQueue(T element, int initSize) {
        this.capacity = initSize;
        elements = new Object[capacity];
        elements[0] = element;
        rear++;
    }

    /**
     * 获取循环队列的大小
     * @return 队列大小
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear > front ? rear - front : capacity - (front - rear);
    }

    /**
     * 插入队列元素
     * @param element 插入的元素
     */
    public void add(T element) {
        if (rear == front && elements[front] != null) {
            pop();
        }
        elements[rear++] = element;
        rear = rear == capacity ? 0 : rear;
    }

    /**
     * 移除队列
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        //保留队列的rear端的元素的值
        T oldValue = (T) elements[front];
        //释放队列的rear端的元素
        elements[front++] = null;
        //如果front已经到头，那就转头
        front = front == capacity ? 0 : front;
        return oldValue;
    }

    /**
     * 返回队列头元素，但不删除队列顶元素
     * @return 队列头元素
     */
    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return (T) elements[front];
    }

    /**
     * 判断循环队列是否为空队列
     * @return true:为空
     */
    public boolean isEmpty() {
        //rear==front且rear处的元素为null
        return rear == front && elements[rear] == null;
    }

    /**
     * 清空循环队列
     */
    public void clear() {
        //将底层数组所有元素赋为null
        while(!isEmpty()){
            pop();
        }
        front = 0;
        rear = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            //如果front < rear，有效元素就是front到rear之间的元素
            if (front < rear) {
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < rear; i++) {
                    sb.append(elements[i].toString() + ", ");
                }
                int len = sb.length();
                return sb.delete(len - 2, len).append("]").toString();
            }
            //如果front >= rear，有效元素为front->capacity之间、0->front之间的
            else {
                StringBuilder sb = new StringBuilder("[");
                for (int i = front; i < capacity; i++) {
                    sb.append(elements[i].toString() + ", ");
                }
                for (int i = 0; i < rear; i++) {
                    sb.append(elements[i].toString() + ", ");
                }
                int len = sb.length();
                return sb.delete(len - 2, len).append("]").toString();
            }
        }
    }
}
