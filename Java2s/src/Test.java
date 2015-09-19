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

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.delete();

        heap.printHeap();
    }
}
