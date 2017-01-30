/**
 * 
 */
package crudoperation;

import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.productdetails.ProductDetails;
import com.utility.UtilityClass;

/**
 * @author PrashantChitte
 *
 */
public class OperationOnProductImpl extends AbstractProductOperation {

	@Override
	public boolean addProductImpl() {
		ProductDetails objectproduct=new ProductDetails();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product info:");
			ProductDetails prodobj=new ProductDetails();
			System.out.println("Product Name:");
			prodobj.setProduct_Name(sc.next());
			System.out.println("product price:");
			prodobj.setProduct_Price(sc.nextDouble());
			System.out.println("product type:");
			prodobj.setProductType(sc.next());
			System.out.println("product Quantity:");
			prodobj.setProductQuantity(sc.nextInt());
			
			OperationOnProductDao operaOnDao=new OperationOnProductDao();
			operaOnDao.addProduct(prodobj);
			System.out.println("Product Saved");
		
		return true;
	}

	@Override
	public boolean removeProductImplByName(String newName) {
		Session ses= (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		ProductDetails newprodDetails=(ProductDetails) ses.get(ProductDetails.class, newName);
		OperationOnProductDao operaOnDao=new OperationOnProductDao();
		operaOnDao.removeProduct(newprodDetails);
		tx.commit();
		ses.close();
		return true;
	}

	@Override
	public boolean removeProductImplById(int newprodId) {
		Session ses= (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		//System.out.println(newprodId);
		ProductDetails newprodDetails=(ProductDetails) ses.get(ProductDetails.class, newprodId);
		//System.out.println(newprodDetails.getProduct_Name());
		OperationOnProductDao operaOnDao=new OperationOnProductDao();
		operaOnDao.removeProduct(newprodDetails);
		tx.commit();
		ses.close();
		return true;
	}

	@Override
	public boolean updateProductPriceByName(String prodName, double newProdPrice) {
		
		Session ses= (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx=ses.beginTransaction();
		ProductDetails newprodDetails=(ProductDetails) ses.get(ProductDetails.class, prodName);
		newprodDetails.setProduct_Price(newProdPrice);
		OperationOnProductDao operaOnDao=new OperationOnProductDao();
		operaOnDao.updateProduct(newprodDetails);		
		tx.commit();
		ses.close();
		System.out.println("Product Updated");
		return true;
	}
	
	@Override
	public boolean updateProductNameByName(String prodName, String newProdName) {		
		Session ses = (Session) UtilityClass.getSessionFactory().openSession();
		Transaction tx = ses.beginTransaction();
		ProductDetails newprodDetails=(ProductDetails) ses.get(ProductDetails.class, prodName);
		newprodDetails.setProduct_Name(newProdName);
		OperationOnProductDao operaOnDao=new OperationOnProductDao();
		operaOnDao.updateProduct(newprodDetails);						
		tx.commit();
		ses.close();
		System.out.println("Product updated");
		return true;
		
	}

	@Override
	public boolean retriveProductById(int prodId) {
		OperationOnProductDao operaOnDao=new OperationOnProductDao();
		 operaOnDao.retriveProduct(prodId);
		 System.out.println("Product Retrieved");
		return true;
	}

	public static void main(String[] args) throws IOException {
		OperationOnProductImpl op = new OperationOnProductImpl();
		 //ProductDetails proddetails=new ProductDetails("MotoG2", 14000, "Moblie", 1);
		// System.out.println(op.addProduct(proddetails));
		// System.out.println(op.retriveProduct(1));
		//System.out.println(op.updateProduct("MotoG2", "Mpple"));
		//System.out.println(op.updateProduct("Mpple", 500));
		//op.removeProduct(5);
		//op.removeProduct("Mpple");
		
		
		char ans;
		Scanner sc=new Scanner(System.in);
	     do
	      {
	    	 
	 		 int choice;
	 		
	    	 System.out.println("Enter Your Operation choice Number:");
	    	 System.out.println("1)Add new Product");
	    	 System.out.println("2)Display Product by Its ID");
	    	 System.out.println("3)Update product Name by using Its Name");//not running
	    	 System.out.println("4)Update product Price by using Its ID");//not running
	    	 System.out.println("5)Remove product  by using ID");//not running
	    	 System.out.println("6)Remove product  by using Name");//not running
	    	 System.out.println("7)Exit");
	    	 choice=sc.nextInt();
			switch (choice) {
			case 1:
				op.addProductImpl();
				break;
			case 2:
				System.out.println("Enter Product ID");
				op.retriveProductById(sc.nextInt());
				break;
			case 3:
				String oldProd, newName;
				System.out.println("Enter old Product name:");
				oldProd = sc.next();
				System.out.println("Enter new Product Name:");
				newName = sc.next();
				op.updateProductNameByName(oldProd, newName);
				break;
			case 4:
				String oldProdname;
				double price;
				System.out.println("Enter old Product name:");
				oldProdname = sc.next();
				System.out.println("Enter new Price :");
				price = sc.nextDouble();
				op.updateProductPriceByName(oldProdname, price);
				break;
			case 5:
				System.out.println("Enter ID of product To remove:");
				int id = sc.nextInt();
				op.removeProductImplById(id);
				break;
			case 6:
				System.out.println("Enter Name of product to remove:");
				String name = sc.next();

				op.removeProductImplByName(name);
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid");

			}
	     System.out.println("Do you want to Continue:");        
         ans=(char) sc.next().charAt(0);	     	           
	   }while('y'==ans || 'Y'==ans);//while("Y".equals(ans) && "y".equals(ans));
	}
}
		
		
		
		
	


