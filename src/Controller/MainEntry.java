package Controller;

import java.util.List;
import java.util.Scanner;
import Dao.EmpDaoImpl;
import Model.Employee;

public class MainEntry {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		EmpDaoImpl obj = new EmpDaoImpl();

		do {

			System.out.println("**********Welcome To HR Management System**********");

			System.out.println("1 - Add Employee");
			System.out.println("2 - Delete Employee");
			System.out.println("3 - All Employee Details");
			System.out.println("4 - Update Employee");
			System.out.println("5 - Search Employee By Employee_Id");
			System.out.println("0 - Exit From System");

			System.out.println("enter Your Choice");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				int status1 = 0;
				System.out.println("enter emplyoee name");
				String name = sc.next();
				System.out.println("enter emplyoee salary");
				int salary = sc.nextInt();
				System.out.println("enter emplyoee joining date");
				String jdate = sc.next();
				System.out.println("enter emplyoee location");
				String location = sc.next();
				System.out.println("enter emplyoee email");
				String email = sc.next();
				System.out.println("enter emplyoee mobile number");
				long mob_no = sc.nextLong();
				System.out.println("enter emplyoee department id");
				int did = sc.nextInt();
				System.out.println("enter emplyoee role id");
				int rid = sc.nextInt();

				Employee e = new Employee(0, name, salary, jdate, location, email, mob_no, did, rid);
				status1 = obj.addEmployee(e);

				if (status1 > 0) {
					System.out.println("employee added successfully");
				} else {
					System.out.println("employee not added");
				}
				break;

			case 2:

				int status2 = 0;
				System.out.println("enter emplyoee id to delete record");
				int id = sc.nextInt();

				status2 = obj.deleteEmployee(id);

				if (status2 > 0) {
					System.out.println("record deleted successfully");
				} else {
					System.out.println("unable to delete record");
				}
				break;

			case 3:

				System.out.println("all emplyoee records as below");

				List<Employee> emplist = obj.getAllEmployee();

				for (Employee emp : emplist) {
					System.out.println(emp);
				}

				break;

			case 4:

				int status3 = 0;
				System.out.println("enter emplyoee id to update record");
				int eid = sc.nextInt();

				status3 = obj.updateEmployee(eid);

				if (status3 > 0) {
					System.out.println("record updated successfully");
				} else {
					System.out.println("unable to update record");
				}
				break;

			case 5:

				System.out.println("enter emplyoee id to search record");

				int epid = sc.nextInt();

				Employee record = obj.searchEmployeeById(epid);

				System.out.println(record);

				break;

			case 0:
				System.out.println("Bye...Thank you");
				System.exit(0);
				break;
			}

		} while (true);

	}

}
