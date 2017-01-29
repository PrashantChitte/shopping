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
public class OperationOnProduct extends AbstractProductOperation {

	@Override
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

	@Override
	public boolean removeProduct(String newName) {

		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		
		String hqlUpdate = "delete ProductDetails p where p.product_Name = :oldProdName";
		int updatedEntities = ses.createQuery(hqlUpdate).setString("oldProdName", newName)
		.executeUpdate();

		tx.commit();
			ses.close();
			System.out.println(updatedEntities);
		return true;
	}

	@Override
	public boolean removeProduct(int newprodId) {

		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		
		String hqlUpdate = "delete ProductDetails p where p.product_Id = :prodId";
		int updatedEntities = ses.createQuery(hqlUpdate).setInteger("prodId", newprodId)
		.executeUpdate();

		tx.commit();
			ses.close();
		return true;
	}

	@Override
	public boolean updateProduct(String prodName, double newProdPrice) {
		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		
		String hqlUpdate = "update ProductDetails p set p.product_Price = :newProdPrice where p.product_Name = :prodName";
				int updatedEntities = ses.createQuery(hqlUpdate).setDouble("newProdPrice", newProdPrice)
				.setString("prodName", prodName).executeUpdate();
		ses.flush();
		tx.commit();
		ses.close();
		if (updatedEntities > 0) {
			System.out.println("Record Updated");
			return true;
		} else
			return false;

	}

	@Override
	public boolean updateProduct(String prodName, String newProdName) {
		System.out.println(prodName + newProdName);
		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		
		String hqlUpdate = "update ProductDetails p set p.product_Name = :newProdName where p.product_Name = :prodName";
				int updatedEntities = ses.createQuery(hqlUpdate).setString("newProdName", newProdName)
				.setString("prodName", prodName).executeUpdate();
		ses.flush();
		tx.commit();
		ses.close();
		if (updatedEntities > 0) {
			System.out.println("Inserted");
			return true;
		} else
			return false;
	}

	@Override
	public boolean retriveProduct(int prodId) {
		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		ProductDetails proddetail = (ProductDetails) ses.get(ProductDetails.class, prodId);// get(ProductDetails.class,prodName);

		System.out.println("Product ID:" + proddetail.getProduct_Id());
		System.out.println("Product Name:" + proddetail.getProduct_Name());
		System.out.println("Product Price:" + proddetail.getProduct_Price());
		System.out.println("Product Type:" + proddetail.getProductType());
		System.out.println("Product Quantity:" + proddetail.getProductQuantity());
		return true;
	}

	public static void main(String[] args) {
		OperationOnProduct op = new OperationOnProduct();
		// ProductDetails proddetails=new ProductDetails("MotoG2", 14000,
		// "Moblie", 1);
		// System.out.println(op.addProduct(proddetails));
		// System.out.println(op.retriveProduct(1));
		//System.out.println(op.updateProduct("MotoG2", "Mpple"));
		//System.out.println(op.updateProduct("Mpple", 500));
		//op.removeProduct(5);
		op.removeProduct("Mpple");
	}

}
