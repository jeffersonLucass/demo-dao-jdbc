package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department department = new Department(null, "null");
		/*System.out.println("=== TEST 1: department insert ===");

		
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());
		*/
		
		System.out.println("\n=== TEST 2: department findbyID ===");
		
		department = departmentDao.findById(1);
		System.out.println(department);
		System.out.println("\n=== TEST 3: department update ===");
		
		department = departmentDao.findById(1);
		department.setName("Food");
		departmentDao.update(department);
		System.out.println("Update completed");
		
	}

}
