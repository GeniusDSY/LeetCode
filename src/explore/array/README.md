# 数组和字符串

## 数组简介

数组是一种基本的数据结构，用于按顺序存储元素的集合。但是元素可以随机存取，因为数组中的每个元素都可以通过数组索引来识别。

数组可以有一个或多个维度。这里我们从一维数组开始，它也被称为线性数组。这里有一个例子：

![mark](http://picture.geniusdsy.cn/picture/20191130/ttUGADHXrspW.png?imageslim)

index是数组的索引，从0开始蓝色框中是各个索引所对应的元素值。

### 动态数组简介

正如我们在上文中提到的，数组具有固定的容量，我们需要在初始化时指定数组的大小。有时它会非常不方便并可能造成浪费。

因此，大多数编程语言都提供内置的动态数组，它仍然是一个随机存取的列表数据结构，但大小是可变的。例如，在 C++ 中的 vector，以及在 Java 中的 ArrayList。

## 二维数组简介

类似于一维数组，二维数组也是由元素的序列组成。但是这些元素可以排列在矩形网格中而不是直线上。

### 存储结构

![mark](http://picture.geniusdsy.cn/picture/20191201/DyVYnpDPTOzf.png?imageslim)

## 字符串简介

字符串实际上是一个 unicode 字符数组。你可以执行几乎所有我们在数组中使用的操作，自己试试看吧。

然而，二者之间还是存在一些区别。在这篇文章中，我们将介绍一些在处理字符串时应该注意的问题。这些特性在不同的语言之间可能有很大不同。

### 不可变字符串——问题和解决方案

> 修改操作

不可变字符串无法被修改。哪怕你只是想修改其中的一个字符，也必须创建一个新的字符串。

> 字符串连接

字符串连接有以下几种方式：

- String创建的字符串（String a = "abc";a += "def";）
- StringBuffer创建的字符串（StringBuffer a = new StringBuffer()"abc");a.append("def");）
- StringBuilder创建的字符串（StringBuilder a = new StringBuilder("abc"); a.append("adf");）

运行速度：StringBuilder > StringBuffer > String （除此之外，可以将字符串转化为字符数组来提高速度）

线程安全：StringBuffer安全 StringBuilder不安全

## 数组与字符串题解

- [14 longest-common-prefix 最长公共前缀](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/LongestCommonPrefix.java)
- [28 implement-strstr 实现strStr()](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/ImplementStrStr.java)
- [54 spiral-matrix 螺旋矩阵](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/SpiralMatrix.java)
- [60 plus-one 加一](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/PlusOne.java)
- [67 add-binary 二进制求和](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/AddBinary.java)
- [498 diagonal-traverse 对角线遍历](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/DiagonalTraverse.java)
- [724 find-pivot-index 寻找数组的中心索引](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/FindPivotIndex.java)
- [747 largest-number-at-least-twice-of-others 至少是其他数字两倍的最大数](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/LargestNumberAtLeastTwiceOfOthers.java)

