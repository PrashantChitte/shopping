package crudoperation;

public abstract class AbstractProductOperation {

	
	
	public void addProduct(ProductDetails p);
	public boolean removeProduct(ProductDetails p);
	public boolean updateProduct(ProductDetails p);
	public boolean retriveProduct(ProductDetails p);
}
