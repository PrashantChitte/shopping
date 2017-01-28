package com.productdetails;

public class ProductDetails {

	private int product_Id;
	private String product_Name;
	private double product_Price;
	private String productType;
	private int productQuantity;
	
	
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProductDetails(String product_Name, double product_Price, String productType,int productQuantity) {
		super();
		//this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.product_Price = product_Price;
		this.productType = productType;
		this.productQuantity=productQuantity;
	}



	public int getProduct_Id() {
		return product_Id;
	}



	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}



	public String getProduct_Name() {
		return product_Name;
	}



	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}



	public double getProduct_Price() {
		return product_Price;
	}



	public void setProduct_Price(double product_Price) {
		this.product_Price = product_Price;
	}



	public String getProductType() {
		return productType;
	}



	public void setProductType(String productType) {
		this.productType = productType;
	}



	public int getProductQuantity() {
		return productQuantity;
	}



	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	
}
