/**
 * 
 */
package crudoperation;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.productdetails.ProductDetails;
import com.utility.UtilityClass;

/**
 * @author PrashantChitte
 *
 */
public class OperationOnProductDao {

	public boolean addProduct(ProductDetails objectproduct) {
		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		if (null == objectproduct) {
			return false;
		} else {
			Transaction tx = ses.beginTransaction();
			ses.save(objectproduct);
			tx.commit();
			ses.close();
			return true;
		}
	}

	
	public boolean removeProduct(ProductDetails newprod) {

		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(newprod);		

		tx.commit();
		ses.close();
		return true;
	}

	
	public boolean updateProduct(ProductDetails prodDetail) {
		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		ses.save(prodDetail);		
		ses.flush();
		tx.commit();
		ses.close();
		return true;
		

	}

	
	public boolean retriveProduct(int prodId) {
		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		ProductDetails proddetail = (ProductDetails) ses.get(ProductDetails.class, prodId);

		System.out.println("Product ID:" + proddetail.getProduct_Id());
		System.out.println("Product Name:" + proddetail.getProduct_Name());
		System.out.println("Product Price:" + proddetail.getProduct_Price());
		System.out.println("Product Type:" + proddetail.getProductType());
		System.out.println("Product Quantity:" + proddetail.getProductQuantity());
		ses.flush();
		tx.commit();
		ses.close();
		
		return true;
	}

}
		
		
		
		
	


