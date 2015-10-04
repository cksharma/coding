/**
 * Created by cksharma on 8/20/15.
 */

class Heap {

    private int index;
    private int[] arr;

    Heap(int capacity) {
        this.arr = new int[capacity];
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //If my index is i, then parent index would be (i - 1) / 2 for 0 based indexing
    private void upAdjustHeap() {
        int i = index;

        while (i > 0) {
            int parentIndex = (i - 1) / 2;

            if (arr[parentIndex] > arr[i]) {
                swap(arr, parentIndex, i);
                i = parentIndex;
            } else {
                break;
            }
        }
    }

    //if my index is i, then my children index would be 2 * i + 1 or 2 * i + 2
    private void downAdjustHeap() {
        int i = 0;
        while ( 2*i+1 < index  ) {
            if ( arr[2*i+1] < arr[i]) {
                swap(arr, 2*i+1, i);
                i = 2 * i + 1;
            } else if (2*i+2<index && arr[2*i+2] < arr[i]) {
                swap(arr, 2*i+2, i);
                i = 2 * i + 2;
            } else
                break;
        }
    }
    public void insert(int num) {
        if (index == arr.length) throw new RuntimeException("Cannot insert in Heap which is full");
        arr[index] = num;
        upAdjustHeap();
        index++;
    }

    public void delete() {
        if (index <= 0) throw new RuntimeException("Cannot delete from empty Heap");
        arr[0] = arr[index - 1];
        downAdjustHeap();
        index--;
    }

    public void printHeap() {
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Test {

    private static int findElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE; //retruning Integer.MIN_VALUE as default value when nothing is +nt
        }
        if (arr.length == 1) return arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i < arr.length - 1 && arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) return arr[i];
            else if (i == arr.length - 1 && arr[i] != arr[i - 1]) return arr[i];
            else if (i == 0 && arr[i] != arr[i + 1]) return arr[i];
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        /*Heap heap = new Heap(10);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.delete();

        heap.printHeap();*/

        /*System.out.println(findElement(new int[]{1}));
        System.out.println(findElement(new int[]{1, 1, 2, 3, 3}));
        System.out.println(findElement(new int[]{1, 2, 2, 3, 3}));
        System.out.println(findElement(new int[]{1, 1, 2, 2, 3}));
        System.out.println(findElement(new int[]{1, 2}));
        */
        System.out.println(binarySearch(0, 7, new int[]{1, 1, 2, 2, 3, 3, 4}));
        System.out.println(binarySearch(0, 0, new int[]{1}));
        System.out.println(binarySearch(0, 2, new int[]{1, 1, 2}));
        System.out.println(binarySearch(0, 5, new int[]{1, 1, 2, 3, 3}));
        System.out.println(binarySearch(0, 10, new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6}));
        System.out.println(binarySearch(0, 8, new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println(binarySearch(0, 8, new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}));
        System.out.println(binarySearch(0, 2, new int[]{1, 2, 2}));
        System.out.println(binarySearch(0, 4, new int[]{1, 1, 2, 2, 3}));
        System.out.println(binarySearch(0, 12, new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7}));
        System.out.println(binarySearch(0, 6, new int[]{1, 2, 2, 3, 3, 4, 4}));
        System.out.println(binarySearch(0, 6, new int[]{1, 1, 2, 3, 3, 4, 4}));
    }

    private static int binarySearch(int start, int end, int[] arr) {
        if (start >= end) return arr[start];

        int mid = (start + end) / 2;

        if (mid - 1 >= 0 && mid + 1 < arr.length && arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
            return arr[mid];
        if (mid % 2 == 1 && mid - 1 >= 0 && arr[mid] != arr[mid - 1]) {
            return binarySearch(start, mid - 1, arr);
        } else if (mid % 2  == 1 && mid - 1 >= 0 && arr[mid] == arr[mid - 1]) {
            return binarySearch(mid + 1, end, arr);
        } else if (mid % 2 == 0 && mid + 1 < arr.length && arr[mid] != arr[mid + 1]) {
            return binarySearch(start, mid - 1, arr);
        } else if (mid % 2 == 0 && mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
            return binarySearch(mid + 1, end, arr);
        }
        return arr[mid];
    }
}
