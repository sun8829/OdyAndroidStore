package com.ody.temp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Map<String, String> map = new HashMap<String, String>() {{
        put("key1", "value1");
        put("key1", "value1");
    }};

    @Test
    public void bubbleSortTest() throws Exception {

        int[] a = createData(500, 1000);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println("  ");
        System.out.println(System.currentTimeMillis());
        a = bubbleSort(a);
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        assertEquals(4, 2 + 2);
    }

    @Test
    public void quickSortTest() {

        int[] a = createData(10, 100);
        int start = 0;
        int end = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println("  ");
        System.out.println(System.currentTimeMillis());
        quickSort(a, start, end);
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        assertEquals(4, 2 + 2);
    }

    @Test
    public void simpleSelectSortTest() {
        int[] a = createData(10, 100);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println("  ");
        System.out.println(System.currentTimeMillis());
        int[] result = simpleSelectSort(a);
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "  ");
        }
    }

    //快速排序
    private void quickSort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }

        System.out.println();
        System.out.println("start : " + start + "; end : " + end);
        //递归
        if (start > low) quickSort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) quickSort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
    }

    //冒泡法
    private int[] bubbleSort(int[] src) {
        for (int i = 0; i < src.length - 2; i++) {
            for (int j = 0; j < src.length - 1; j++) {
                if (src[j] > src[j + 1]) {
                    int temp = src[j];
                    src[j] = src[j + 1];
                    src[j + 1] = temp;
                }
            }
        }

        return src;
    }

    //简单选择排序
    private int[] simpleSelectSort(int[] src) {
        int k;
        for (int i = 0; i < src.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < src.length; j++) {
                if (src[k] > src[j]) {
                    k = j;
                }
            }

            int temp = src[i];
            src[i] = src[k];
            src[k] = temp;
        }

        return src;
    }

    //生成数据
    private int[] createData(int n, int max) {
        int[] a = new int[n];
        Random random = new Random();
        int index = 0;
        boolean flag = false;
        while (true) {
            flag = false;
            int v = random.nextInt(max) + 1;
            for (int i = 0; i < index + 1; i++) {
                if (a[i] == v) {
                    flag = true;
                }
            }
            if (flag) continue;
            a[index] = v;
            index++;
            if (index == n) {
                break;
            }
        }
        return a;
    }
}