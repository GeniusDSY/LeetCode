# 链表

## 单链表

### 简介

#### 定义与结构

单链表中的每个结点不仅包含值，还包含链接到下一个结点的引用字段。通过这种方式，单链表将所有结点按顺序组织起来。

下面是一个单链表的例子：
![单链表](http://picture.geniusdsy.cn/picture/20191221/2mBlYwcXlP2x.png?imageslim)

> [链表结构代码](https://github.com/GeniusDSY/LeetCode/blob/master/src/base/ListNode.java)

在大多数情况下，我们将使用头结点(第一个结点)来表示整个列表。

#### 操作

与数组不同，我们无法在常量时间内访问单链表中的随机元素。 如果我们想要获得第 i 个元素，我们必须从头结点逐个遍历。 我们按索引来访问元素平均要花费 O(N) 时间，其中 N 是链表的长度。

- 添加操作
    - 使用给定值初始化新结点 cur；
    ![mark](http://picture.geniusdsy.cn/picture/20191224/ru5QumHTJBXw.png?imageslim)
    - 将 cur 的“next”字段链接到 prev 的下一个结点 next；
    ![mark](http://picture.geniusdsy.cn/picture/20191224/BqWR2s44twCx.png?imageslim)
    - 将 prev 中的“next”字段链接到 cur 。
    ![mark](http://picture.geniusdsy.cn/picture/20191224/oJXIG8LdEkJs.png?imageslim)
    
与数组不同，我们不需要将所有元素移动到插入元素之后。因此，您可以在 O(1) 
时间复杂度中将新结点插入到链表中，这非常高效。

> 在开头添加新结点

众所周知，我们使用头结点来代表整个列表。
因此，在列表开头添加新节点时更新头结点 head 至关重要。
- 1、初始化一个新结点 cur；
- 2、将新结点链接到我们的原始头结点 head。
![mark](http://picture.geniusdsy.cn/picture/20191224/R5ctQ4ccFgw7.png?imageslim)
- 3、将 cur 指定为 head。
![mark](http://picture.geniusdsy.cn/picture/20191224/9tkEBfKX4oCO.png?imageslim)

- 删除操作

    - 找到 cur 的上一个结点 prev 及其下一个结点 next；
    - 接下来链接 prev 到 cur 的下一个节点 next。

在我们的第一步中，我们需要找出 prev 和 next。使用 cur 的参考字段很容易找出 next，但是，我们必须从头结点遍历链表，以找出 prev，它的平均时间是 O(N)，其中 N 是链表的长度。因此，删除结点的时间复杂度将是 O(N)。

空间复杂度为 O(1)，因为我们只需要常量空间来存储指针。

> 删除第一个结点

如果我们想删除第一个结点，策略会有所不同。

正如之前所提到的，我们使用头结点 head 来表示链表。我们的头是下面示例中的黑色结点 23。
![mark](http://picture.geniusdsy.cn/picture/20191224/KqhDLrVjic6d.png?imageslim)
如果想要删除第一个结点，我们可以简单地将下一个结点分配给 head。也就是说，删除之后我们的头将会是结点 6。
![mark](http://picture.geniusdsy.cn/picture/20191224/pmBfnEQabQvg.png?imageslim)
链表从头结点开始，因此结点 23 不再在我们的链表中。

## 双指针技巧(链表)
这正是我们在链表中使用两个速度不同的指针时会遇到的情况：

如果没有环，快指针将停在链表的末尾。
如果有环，快指针最终将与慢指针相遇。
> 这两个指针的适当速度应该是多少？

一个安全的选择是每次移动慢指针一步，而移动快指针两步。每一次迭代，快速指针将额外移动一步。如果环的长度为 M，经过 M 次迭代后，快指针肯定会多绕环一周，并赶上慢指针。

### 注意事项

1. 在调用 next 字段之前，始终检查节点是否为空。
获取空节点的下一个节点将导致空指针错误。例如，在我们运行 fast = fast.next.next 之前，需要检查 fast 和 fast.next 不为空。
2. 仔细定义循环的结束条件。

### 复杂度分析

复杂度分析
空间复杂度分析容易。如果只使用指针，而不使用任何其他额外的空间，那么空间复杂度将是 O(1)。但是，时间复杂度的分析比较困难。为了得到答案，我们需要分析运行循环的次数。

在前面的查找循环示例中，假设我们每次移动较快的指针 2 步，每次移动较慢的指针 1 步。

- 如果没有循环，快指针需要 N/2 次才能到达链表的末尾，其中 N 是链表的长度。
- 如果存在循环，则快指针需要 M 次才能赶上慢指针，其中 M 是列表中循环的长度。
显然，M <= N 。所以我们将循环运行 N 次。对于每次循环，我们只需要常量级的时间。因此，该算法的时间复杂度总共为 O(N)。

自己分析其他问题以提高分析能力。别忘了考虑不同的条件。如果很难对所有情况进行分析，请考虑最糟糕的情况。

## 经典问题

- 1.通过一些测试用例可以节省您的时间。

使用链表时不易调试。因此，在编写代码之前，自己尝试几个不同的示例来验证您的算法总是很有用的。

- 2.你可以同时使用多个指针。

有时，当你为链表问题设计算法时，可能需要同时跟踪多个结点。您应该记住需要跟踪哪些结点，并且可以自由地使用几个不同的结点指针来同时跟踪这些结点。

如果你使用多个指针，最好为它们指定适当的名称，以防将来必须调试或检查代码。

- 3.在许多情况下，你需要跟踪当前结点的前一个结点。

你无法追溯单链表中的前一个结点。因此，您不仅要存储当前结点，还要存储前一个结点。这在双链表中是不同的，我们将在后面的章节中介绍。

## 双链表

### 添加操作

- 链接 cur 与 prev 和 next，其中 next 是 prev 原始的下一个节点；
- 用 cur 重新链接 prev 和 next。

与单链表类似，添加操作的时间和空间复杂度都是 O(1)。

### 删除操作

- cur.pre.next = cur.next;
- cur.next.pre = cur.pre;

## 链表题解
- [2 add-two-numbers 两数之和](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/Add)
- [19 remove-nth-node-from-end-of-list 删除链表的倒数第N个节点](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/RemoveNthNodeFromEndOfList.java)
- [21 merge-two-sorted-lists 合并两个有序链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/MergeTwoSortedLists.java)
- [138 copy-list-with-random-pointer 复制带随机指针的链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/CopyListWithRandomPointer.java)
- [141 linked-list-cycle 环形链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/LinkedListCycle.java)
- [142 linked-list-cycle-ii 环形链表II](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/LinkedListCycleII.java)
- [160 intersection-of-two-linked-lists 相交链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/IntersectionOfTwoLinkedLists.java)
- [203 remove-linked-list-elements 移除链表元素](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/RemoveLinkedListElements.java)
- [206 reverse-linked-list 反转链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/recursion_i/ReverseLinkedList.java)
- [234 palindrome-linked-list 回文链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/PalindromeLinkedList.java)
- [328 odd-even-linked-list 奇偶链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/OddEvenLinkedList.java)
- [430 flatten-a-multilevel-doubly-linked-list 扁平化多级双向链表](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/FlattenAMultilevelDoublyLinkedList.java)
- [707 design-linked-list 设计链表(单链表)](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/DesignLinkedList.java)
- [707 design-linked-list 设计链表(双链表)](https://github.com/GeniusDSY/LeetCode/blob/master/src/explore/linked_list/DesignDoubleLinkedList.java)