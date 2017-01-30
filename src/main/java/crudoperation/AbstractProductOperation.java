package crudoperation;

import com.productdetails.ProductDetails;

public abstract class AbstractProductOperation {

	
	
	public abstract boolean addProductImpl();
	
	public abstract boolean removeProductImplByName(String productName);
	public abstract boolean removeProductImplById(int id);
	
	public abstract boolean retriveProductById(int prodName);
	
	public abstract boolean updateProductNameByName(String prodName,String newProdName);
	public abstract boolean updateProductPriceByName(String prodName,double newProdPrice);
	
	
	
}
