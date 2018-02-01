package com.bridgelabz.util;

public class Stock {

	private String stockName;
	private long nymOfshares;
	private long priceOfShare;
	private String filePath;
	private String fileDirectory="/home/bridgeit/Documents/";
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = fileDirectory+filePath+".json";
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public long getNymOfshares() {
		return nymOfshares;
	}
	public void setNymOfshares(long nymOfshares) {
		this.nymOfshares = nymOfshares;
	}
	public long getPriceOfShare() {
		return priceOfShare;
	}
	public void setPriceOfShare(long priceOfShare) {
		this.priceOfShare = priceOfShare;
	}
}
