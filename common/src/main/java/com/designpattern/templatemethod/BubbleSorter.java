package com.designpattern.templatemethod;

/**
 * Author Bryan.C <br>
 * Date 2018/5/2
 */
public abstract class BubbleSorter<T> {

    /**
     * 冒泡排序
     */
    public int sort(T array) {
        setArray(array);
        int length = getLength();

        int operations = 0;
        if (length <= 1) {
            return operations;
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                operations++;
                if (needSwap(j)) {
                    swap(j);
                }
            }
        }

        return operations;
    }

    /**
     * 初始化排序数组
     */
    protected abstract void setArray(T array);

    /**
     * @return 返回数组长度
     */
    protected abstract int getLength();

    /**
     * @return 是否需要交换数组中 index 和 index+1 元素
     */
    protected abstract boolean needSwap(int index);

    /**
     * 交换array数组中的 index 和 index+1 元素
     */
    protected abstract void swap(int index);
}
