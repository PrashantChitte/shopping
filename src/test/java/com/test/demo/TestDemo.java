/*package com.test.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.productdetails.ProductDetails;
import com.utility.Constant;

import crudoperation.OperationOnProduct;

public class TestDemo {
	
	ProductDetails proddetails=new ProductDetails("Note3", 9000, "Moblie", 1);
	String retval=null;
	OperationOnProduct oop=new OperationOnProduct();
  

  @Test
  public void addTest() {	
	  Assert.assertEquals(oop.addProduct(proddetails),Constant.PRODUCTADDED);
	
  }
  
  @Test
  public void removeTest() {
	  Assert.assertEquals(oop.removeProduct(1),Constant.PRODUCTREMOVED);
	
  }
  @Test
  public void retriveTest() {
	 // Assert.assertEquals(oop.retriveProduct("Note3"),Constant.PRODUCTRETRIVED);
	
  }
  @Test
  public void updateIdTest() {
	  Assert.assertEquals(oop.updateProduct(1),Constant.PRODUCTUPDATED);
	
  }
  
  @Test
  public void updateStringTest() {
	  Assert.assertEquals(oop.updateProduct("Note4"),Constant.PRODUCTUPDATED);
	  }
  
}
*/