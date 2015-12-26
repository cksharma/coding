package com.geeks.dp;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class BoxStackingDP {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskBoxStack solver = new TaskBoxStack();
		solver.solve(1, in, out);
		out.close();
	}
}

class Box implements Comparable<Box>{
	int height;
	int width;
	int depth;
	public Box(int height,int width, int depth) {
		super();
		this.height = height;
		this.width = width;
		this.depth = depth;		
	}
	@Override
	public int compareTo(Box o2) {
		return (width * depth - o2.width * o2.depth);
	}
	@Override
	public String toString() {
		return height + " x " + width + " x " + depth;
	}	
}

class TaskBoxStack {
	Box[] box;
	private int calculateHeight() {
		int[] dp = new int[box.length];
		int index = 0;
		for (Box item : box) dp[index++] = item.height;
		assert box.length == 0 : "Box size cannot be empty";
		for (int i = 1; i < box.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (box[i].depth > box[j].depth && box[i].width > box[j].width && dp[i] < dp[j] + box[i].height) {
					dp[i] = dp[j] +  box[i].height;
				}
			}
		}
		int maxi = 0;
		for (int i = 0; i < dp.length; i++) maxi = Math.max(maxi, dp[i]);
		return maxi;
	}
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		Box[] input = { new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32)};
		box = new Box[input.length * 3];
		int index = 0;
		for (Box bb : input) {
			box[index++] = new Box(bb.height, Math.max(bb.width, bb.depth), Math.min(bb.width, bb.depth));			
			box[index++] = new Box(bb.depth, Math.max(bb.height, bb.width), Math.min(bb.height, bb.width));
			box[index++] = new Box(bb.width, Math.max(bb.depth, bb.height), Math.min(bb.depth, bb.height));
		}
		Arrays.sort(box);	
		for (Box b : box) System.out.println(b);
		int ans = calculateHeight();
		System.out.println(ans);
	}
}
