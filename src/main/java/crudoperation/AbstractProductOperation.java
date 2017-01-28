package crudoperation;

import com.productdetails.ProductDetails;

public abstract class AbstractProductOperation {

	
	
	public abstract boolean addProduct(ProductDetails p);
	public abstract boolean removeProduct(String productName);
	public abstract boolean retriveProduct(int prodName);
	public abstract boolean removeProduct(int id);
	public abstract boolean updateProduct(String prodName,String newProdName);
	public abstract boolean updateProduct(String prodName,double newProdPrice);
	
	
	
}
