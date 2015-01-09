package com.onmobile.training.strategy;

public class Test {
	public static void main(String[] args) {
		SortStrategy st = new BubbleSort();
		SearchEngine engine = new SearchEngine(st);
		engine.search();
	}
}