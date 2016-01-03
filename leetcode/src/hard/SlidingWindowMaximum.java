package hard;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by cksharma on 11/26/15.
 */
public class SlidingWindowMaximum {
    static class State {
        int val;
        int index;

        State(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k > nums.length) return new int[0];

        int[] ans = new int[nums.length - k + 1];
        LinkedList<State> deque = new LinkedList<>();

        State maxState = new State(Integer.MIN_VALUE, -1);
        for (int i = 0; i < k; i++) {
            State state = new State(nums[i], i);
            deque.add(state);
            if (state.val >= maxState.val) {
                maxState = state;
            }
        }
        ans[0] = maxState.val;

        for (int i = k; i < nums.length; i++) {
            State state = new State(nums[i], i);
            deque.add(state);
            if (deque.size() > k) {
                deque.removeFirst();
            }

            if (maxState.index < deque.getLast().index) {
                maxState = getMaxState(deque);
                removeElementsBeforeMax(deque, maxState);
            }
            ans[i - k + 1] = maxState.val;
        }
        return ans;
    }

    private void removeElementsBeforeMax(LinkedList<State> deque, State maxState) {
        Iterator<State> iterator = deque.listIterator();
        while (iterator.hasNext()) {
            State state = iterator.next();
            if (state.index == maxState.index) break;
            iterator.remove();
        }
    }

    private State getMaxState(LinkedList<State> deque) {
        State ans = deque.getFirst();
        for (State state : deque) {
            if (state.val >= ans.val) {
                ans = state;
            }
        }
        return ans;
    }

    public int[] maxSlidingWindowOpt(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k > nums.length) return new int[0];

        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (deque.isEmpty() == false && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        ans[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; i++) {
            ans[i - k] = nums[deque.getFirst()];
            while (deque.isEmpty() == false && i - k >= deque.getFirst()) {
                deque.removeFirst();
            }
            while (deque.isEmpty() == false && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        ans[nums.length - k] = nums[deque.getFirst()];
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        //arr = new int[]{1, -1};
        //k = 1;

        SlidingWindowMaximum sol = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(sol.maxSlidingWindow(arr, k)));

        System.out.println(Arrays.toString(sol.maxSlidingWindowOpt(arr, k)));

    }
}
