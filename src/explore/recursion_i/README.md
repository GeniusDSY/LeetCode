# 递归I

## 递归原理

### 递归原理内容

> 递归是一种解决问题的有效方法，在递归过程中，函数将自身作为子例程调用

你可能想知道如何实现调用自身的函数。诀窍在于，每当递归函数调用自身时，它都会将给定的问题拆解为子问题。递归调用继续进行，直到到子问题无需进一步递归就可以解决的地步。

为了确保递归函数不会导致无限循环，它应具有以下属性：

一个简单的基本案例（basic case）（或一些案例） —— 能够不使用递归来产生答案的终止方案。
一组规则，也称作递推关系（recurrence relation），可将所有其他情况拆分到基本案例。
注意，函数可能会有多个位置进行自我调用。

### 递归函数

对于一个问题，如果存在递归解决方案，我们可以按照以下步骤来实施它。

举个例子，我们将问题定义为有待实现的函数 F(X)，其中 X 是函数的输入，同时也定义了问题的范围。

然后，在函数 F(X) 中，我们将会：

- 将问题逐步分解成较小的范围，例如 x0∈X,x1∈X,...xn∈X；
- 调用函数 F(x0),F(x1),...,F(xn)递归地 解决 X 的这些子问题；
最后，处理调用递归函数得到的结果来解决对应 X 的问题。

## 递推关系

### 递推关系内容

在实现递归函数之前，有两件重要的事情需要弄清楚:

- <span style="color:red"><code>递推关系</code></span>： 一个问题的结果与其子问题的结果之间的关系。
- <span style="color:red"><code>基本情况</code></span>: 不需要进一步的递归调用就可以直接计算答案的情况。 有时，基本案例也被称为 bottom cases，因为它们往往是问题被减少到最小规模的情况，也就是如果我们认为将问题划分为子问题是一种自上而下的方式的最下层。

> 一旦我们计算出以上两个元素，再想要实现一个递归函数，就只需要根据<span style="color:red"><code>递推关系</code></span>调用函数本身，直到其抵达<span style="color:red"><code>基本情况</code></span>。

## Memoization(记忆化)技术

### 递归中的重复计算

通常情况下，递归是一种直观而有效的实现算法的方法。 但是，如果我们不明智地使用它，可能会给性能带来一些不希望的损失，例如重复计算。 在前一章的末尾，我们遇到了帕斯卡三角的重复计算问题，其中一些中间结果被多次计算。

在本文中，我们将进一步研究递归可能出现的重复计算问题。 然后我们将提出一种常用的技术，称为**记忆化（memoization）**，可以用来避免这个问题。

为了演示重复计算的另一个问题，让我们看一个大多数人可能都很熟悉的例子，斐波那契数。 如果我们定义函数 F(n) 表示在索引 n 处的斐波那契数，那么你可以推导出如下的递推关系：

```text
    F(n) = F(n - 1) + F(n - 2)
```

基本情况：
```text
    F(0) = 0, F(1) = 1
```

根据斐波那契数列的定义，可以实现下面的函数：

```java
public class Test{
    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
        return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
```

现在，如果你想知道 F(4) 是多少，你可以应用上面的公式并进行展开：
```text
F(4) = F(3) + F(2) = (F(2) + F(1)) + F(2)
```

正如你所看到的，为了得到 f (4)的结果，我们需要在上述推导之后计算两次数 F(2) : 第一次在 F(4) 的第一次展开中，第二次在中间结果 F(3) 中。

下面的树显示了在计算 F(4) 时发生的所有重复计算（按颜色分组）。

![mark](http://picture.geniusdsy.cn/picture/20191124/Po1s3r2VPUlv.png?imageslim)

#### 记忆化

为了消除上述情况中的重复计算，正如许多人已经指出的那样，其中一个想法是将中间结果存储在缓存中，以便我们以后可以重用它们，而不需要重新计算。

这个想法也被称为**记忆化**，这是一种经常与递归一起使用的技术。

> 记忆化 是一种优化技术，主要用于加快计算机程序的速度，方法是存储昂贵的函数调用的结果，并在相同的输入再次出现时返回缓存的结果。 (来源: 维基百科)

回到斐波那契函数 F(n)。 我们可以使用哈希表来跟踪每个以 n 为键的 F(n) 的结果。 散列表作为一个缓存，可以避免重复计算。 记忆化技术是一个很好的例子，它演示了如何通过增加额外的空间以减少计算时间。

为了便于比较，我们在下面提供了带有记忆化功能的斐波那契数列解决方案的实现。

作为一种练习，您可以尝试使记忆化更加通用和非侵入性，即应用记忆化技术而不改变原来的功能。 (提示: 可以参考一种被称作 decorator 的设计模式)。

```java
import java.util.HashMap;

public class Main {

  HashMap<Integer, Integer> cache = new HashMap<>();

  private int fib(int N) {
    if (cache.containsKey(N)) {
      return cache.get(N);
    }
    int result;
    if (N < 2) {
      result = N;
    } else {
      result = fib(N-1) + fib(N-2);
    }
    // keep the result in cache.
    cache.put(N, result);
    return result;
  }
}
```

## 递归题解

- [24 swap-nodes-in-pairs 两两交换链表中的节点](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/SwapNodesInPairs.java)
- [118 pascals-triangle 杨辉三角](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/PascalsTriangle.java)
- [119 pascals-triangle-ii 杨辉三角II](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/PascalsTriangleII.java)
- [206 reverse-linked-list 反转链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/ReverseLinkedList.java)
- [344 reverse-string 反转字符串](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/ReverseString.java)
- [509 fibonacci-number 斐波那契数](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/FibonacciNumber.java)
