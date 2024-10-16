package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST 1: seller findById====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findById====");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll====");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller obj: list2) {
			System.out.println(obj);
			
		}
		
		System.out.println("\n=== TEST 4: seller findAll====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(),4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = "+ newSeller.getId());
	
		System.out.println("\n=== TEST 5: seller findAll====");
		seller = sellerDao.findById(1);
		seller.setName("Martilde Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller Delete ====");
		System.out.print("Seller id: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Seller deleted");
		sc.close();
	}

}
