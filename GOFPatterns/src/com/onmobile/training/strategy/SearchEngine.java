package com.onmobile.training.strategy;

public class SearchEngine {
	private SortStrategy strategy; //coz of this we can use any of the sorting strategy during runtime
	
	public SearchEngine(SortStrategy strategy)
	{
		this.strategy = strategy;
	}
	public void search()
	{
		strategy.sort();
		System.out.println("starting searching");
		//remaining search logic
	}
}
