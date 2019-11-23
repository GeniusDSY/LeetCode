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

## 递归题解

- [344 reverse-string 反转字符串](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/ReverseString.java)
- [24 swap-nodes-in-pairs 两两交换链表中的节点](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/SwapNodesInPairs.java)