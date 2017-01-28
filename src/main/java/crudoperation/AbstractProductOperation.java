package crudoperation;

import com.productdetails.ProductDetails;

public abstract class AbstractProductOperation {

	
	
	public abstract boolean addProduct(ProductDetails p);
	public abstract boolean removeProduct(String productName);
	public abstract boolean retriveProduct(String prodName);
	public abstract boolean removeProduct(int id);
	public abstract boolean updateProduct(int prodId);
	public abstract boolean updateProduct(String prodName);
	
	
	
}
