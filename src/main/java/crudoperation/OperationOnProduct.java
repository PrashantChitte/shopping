/**
 * 
 */
package crudoperation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.productdetails.ProductDetails;
import com.utility.UtilityClass;

/**
 * @author PrashantChitte
 *
 */
public class OperationOnProduct extends AbstractProductOperation 
{
	
	

	@Override
	public boolean addProduct(ProductDetails objectproduct) {
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();
		if(null==objectproduct)
		{
			return false;
		}
		else
		{
			Transaction tx=ses.beginTransaction();
			ses.save(objectproduct);
			tx.commit();
			ses.close();
			return true;
		}
	}

	@Override
	public boolean removeProduct(String productName) {
		
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();
		if(null!=productName)
		ses.delete(productName,new ProductDetails());
		ses.close();		
		return true;
	}
	@Override
	public boolean removeProduct(int prodId) {
		
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();		
		ProductDetails ProdDetail=new ProductDetails();
		ProdDetail.setProduct_Id(prodId);
		ses.delete(ProdDetail);
		ses.close();		
		return true;
	}
	@Override
	public boolean updateProduct(int prodId) {
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();		
		ProductDetails ProdDetail=new ProductDetails();
		ProdDetail.setProduct_Id(prodId);
		ses.update(ProdDetail);
		ses.close();		
		return true;
		
	}
	@Override
	public  boolean updateProduct(String prodName){
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();		
		ProductDetails ProdDetail=new ProductDetails();
		ProdDetail.setProduct_Name(prodName);
		ses.update(ProdDetail);
		ses.close();		
		return true;
	}
	
	@Override
	public boolean retriveProduct(String prodName) {
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();		
		Transaction tx=ses.beginTransaction();
		ProductDetails proddetail=(ProductDetails) ses.get(ProductDetails.class,prodName);
		
		System.out.println("Produrct ID:"+proddetail.getProduct_Id());
		System.out.println("Produrct Name:"+proddetail.getProduct_Name());
		System.out.println("Produrct Price:"+proddetail.getProduct_Price());
		System.out.println("Produrct Type:"+proddetail.getProductType());
		return true;
	}

	
		
	

}
