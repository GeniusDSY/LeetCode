# 数组和字符串

## 数组简介

数组是一种基本的数据结构，用于按顺序存储元素的集合。但是元素可以随机存取，因为数组中的每个元素都可以通过数组索引来识别。

数组可以有一个或多个维度。这里我们从一维数组开始，它也被称为线性数组。这里有一个例子：

![mark](http://picture.geniusdsy.cn/picture/20191130/ttUGADHXrspW.png?imageslim)

index是数组的索引，从0开始蓝色框中是各个索引所对应的元素值。

## 动态数组简介

正如我们在上文中提到的，数组具有固定的容量，我们需要在初始化时指定数组的大小。有时它会非常不方便并可能造成浪费。

因此，大多数编程语言都提供内置的动态数组，它仍然是一个随机存取的列表数据结构，但大小是可变的。例如，在 C++ 中的 vector，以及在 Java 中的 ArrayList。

## 数组与字符串题解

- [60 plus-one 加一](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/PlusOne.java)
- [724 find-pivot-index 寻找数组的中心索引](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/FindPivotIndex.java)
- [747 largest-number-at-least-twice-of-others 至少是其他数字两倍的最大数](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/array/LargestNumberAtLeastTwiceOfOthers.java)

