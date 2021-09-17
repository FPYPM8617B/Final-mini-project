package Dao;

import java.util.List;

import Model.Employee;

public interface EmpDao {

	public int addEmployee(Employee e);

	public int deleteEmployee(int id);

	public List<Employee> getAllEmployee();

	public int updateEmployee(int id);

	public Employee searchEmployeeById(int id);

}
