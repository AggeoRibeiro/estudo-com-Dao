package application;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	/*public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		SellerDao sellerDao = DaoFactory.createSellerDao();
		boolean exit=true;
		while(exit) {
			System.out.println("select the option you want");
			System.out.println("1-insert records into the database");
			System.out.println("2-find in database");
			System.out.println("3-update database");
			System.out.println("4-Delete in database");
			System.out.println("5-exit");
			char userResponse=sc.next().charAt(0);
			
			switch (userResponse) {
			
			case '1':
				System.out.println("select the option you want");
				System.out.println("1-Insert new SELLER");
				System.out.println("2-Insert new DEPARTMENT");
				char userResponse2=sc.next().charAt(0);
				if (userResponse2=='1') {
					System.out.println("enter the data for the new seller");
					System.out.print("Name:");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Email:");
					String email = sc.nextLine();
					System.out.print("Birth-date: (dd/mm/yyyy");
					Date birthDate = sdf.parse(sc.next());
					System.out.print("Base salary:");
					Double baseSalary = sc.nextDouble();
					System.out.print("Department id:");
					Integer departmentId=sc.nextInt();
					Seller newSeller = new Seller (null, name, email, birthDate, baseSalary, departmentDao.findById(departmentId));
					sellerDao.insert(newSeller);
					System.out.println("Inserted! new id = " + newSeller.getId());
				}
				else if (userResponse=='2') {
					System.out.println("Enter the data for the new department");
					System.out.print("Name:");
					sc.nextLine();
					String departmentName=sc.next();
					Department newDepartment = new Department(null, departmentName);
					departmentDao.insert(newDepartment);
					System.out.println("Inserted! new id: " + newDepartment.getId());
				} else {
					System.out.println("invalid data");
				}
			case '2':
				System.out.println("select the option you want");
				System.out.println("1-Find a department");
				System.out.println("2-Find a seller");
				char userResponse3=sc.next().charAt(0);
				if (userResponse3 == '1') {
					System.out.println("select the option you want");
					System.out.println("1-Find by department id");
					System.out.println("2-Find all departments");
					char userResponse4=sc.next().charAt(0);
					if (userResponse4 == '1') {
						System.out.print("Enter the id:");
						int departmentId = sc.nextInt();
						Department department = departmentDao.findById(departmentId);
						System.out.println(department);
					}
					else if (userResponse4=='2') {
						List<Department> departmentList = departmentDao.findAll();
						for (Department obj : departmentList) {
							System.out.println(obj);
						}	
					}
				}
				else if (userResponse3=='2') {
					System.out.println("select the option you want");
					System.out.println("1-Find by department id");
					System.out.println("2-Find all sellers");
					char userResponse4=sc.next().charAt(0);
					if (userResponse4 == '1') {
						Department department = new Department (2, null);
						List<Seller> list = sellerDao.findByDepartment(department);
						for (Seller obj : list) {
							System.out.println(obj);
						}
					}
					else if (userResponse4 == '2') {
						List<Seller>list = sellerDao.findAll();
						for (Seller obj : list) {
							System.out.println(obj);
						}
					}
				}
				
			case '3':
				System.out.println("select the option you want");
				System.out.println("1-Update department");
				System.out.println("2-Update seller");
				char userResponseUpdate = sc.next().charAt(0);
				if (userResponseUpdate=='1') {
					System.out.println("Enter the department id:");
					int id = sc.nextInt();
					System.out.println("Enter the new department name:");
					Department department = departmentDao.findById(id);
					sc.nextLine();
					department.setName(sc.nextLine());
					departmentDao.update(department);
				}
				else if (userResponseUpdate=='2') {
					System.out.println("Enter the seller id:");
					int id = sc.nextInt();
					Seller updateSeller = sellerDao.findById(id);
					System.out.print("Name:");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Email:");
					String email = sc.nextLine();
					System.out.print("Birth-date: (dd/mm/yyyy");
					Date birthDate = sdf.parse(sc.next());
					System.out.print("Base salary:");
					Double baseSalary = sc.nextDouble();
					System.out.print("Department id:");
					Integer departmentId=sc.nextInt();
					updateSeller = new Seller (null, name, email, birthDate, baseSalary, departmentDao.findById(departmentId));
					sellerDao.update(updateSeller);
					System.out.println("Update completed");
				}
				
			}
			if(sc.next().charAt(0)=='5') {
				exit=false;
			}
			
		}
		
		
		
		System.out.println("---------Find by id department------------");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		System.out.println();
		System.out.println("---------Find all department--------");
		
		System.out.println();
		System.out.println("--------------update department----------------");
		
		
		System.out.println();
		System.out.println("--------------Insert department----------------");
		Department newdep = new Department(null, "teste");
		departmentDao.insert(newdep);
		System.out.println("Inserted! new id: " + newdep.getId());
		System.out.println();
		System.out.println("-----------Delete department-------------------");
		
		
		

		System.out.println("-----------Find by Id Seller------------");
		
		System.out.println();
		System.out.println("-------------Find by id Department-------------");
		
		
		System.out.println();
		System.out.println("-------------Seller find all-------------");
		
		System.out.println();
		System.out.println("--------Insert seller------------");
		Seller newSeller = new Seller (null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println();
		System.out.println("---------Seller update------------");
		
		
		System.out.println("----------delete seller----------------");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("delete completed");
		
		sc.close();
		}
		*/
	
	

}
