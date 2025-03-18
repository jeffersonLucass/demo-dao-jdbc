package application;

import java.time.LocalDate;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj  = new Department(1, "Books");
		//LocalDate.now() pega a data atual do sistema. ou LocalDate.of(ano, mes, dia) que é uma data específica. 
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", LocalDate.of(2000,12,8), 3000.0, obj);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(obj);
		System.out.println(seller);
		
		
		
	}

}
