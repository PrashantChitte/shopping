/**
 * 
 */
package crudoperation;

import org.hibernate.Query;
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
	public boolean updateProduct(String prodName,double newProdPrice) {
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();		
		ProductDetails ProdDetail=new ProductDetails();
		ProdDetail.setProduct_Price(newProdPrice);;
		ses.update(ProdDetail);
		ses.close();		
		return true;
		
	}
	@Override
	public  boolean updateProduct(String prodName,String newProdName){
		System.out.println(prodName+newProdName);
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();													
					String hql = "UPDATE ProductDetails set NAME = :newProdName "  + 
				                     "WHERE  NAME = :prodName";
				Query query = ses.createQuery(hql);				
				query.setParameter("newProdName", newProdName);
				query.setParameter("prodName",prodName );
				int result = query.executeUpdate();
				System.out.println("result");
				if(result>0)
					return true;
				else
					return false;
	}
	
	@Override
	public boolean retriveProduct(int prodId) {
		Session ses=(Session) UtilityClass.getSessionFactory().openSession();		
		Transaction tx=ses.beginTransaction();
		ProductDetails proddetail=(ProductDetails) ses.get(ProductDetails.class, prodId);//get(ProductDetails.class,prodName);
		
		System.out.println("Product ID:"+proddetail.getProduct_Id());
		System.out.println("Product Name:"+proddetail.getProduct_Name());
		System.out.println("Product Price:"+proddetail.getProduct_Price());
		System.out.println("Product Type:"+proddetail.getProductType());
		System.out.println("Product Quantity:"+proddetail.getProductQuantity());
		return true;
	}

	public static void main(String[] args) {
		OperationOnProduct op=new OperationOnProduct();
		//ProductDetails proddetails=new ProductDetails("MotoG2", 14000, "Moblie", 1); 
		//System.out.println(op.addProduct(proddetails));
		//System.out.println(op.retriveProduct(1));
		System.out.println(op.updateProduct("MotoG2", "Mpple"));
	}
		
	

}
