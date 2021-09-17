package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Configuration.DBconnect;
import Model.Employee;

public class EmpDaoImpl implements EmpDao {

	private static Scanner sc = new Scanner(System.in);

	public int addEmployee(Employee e) {

		int status = 0;
		try (Connection con = DBconnect.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"insert into employee(ename, esalary, ejoin_date, elocation, email, emob_no, edid, erid) values(?,?,?,?,?,?,?,?);")) {
			pst.setString(1, e.getEmpName());
			pst.setInt(2, e.getEmpSal());
			pst.setString(3, e.getEmpJoiningDate());
			pst.setString(4, e.getEmpLocation());
			pst.setString(5, e.getEmpMail());
			pst.setLong(6, e.getEmpMobile());
			pst.setInt(7, e.getEmpDid());
			pst.setInt(8, e.getEmpRid());

			status = pst.executeUpdate();

		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return status;
	}

	public int deleteEmployee(int id) {
		int status = 0;

		try (Connection con = DBconnect.getConnection();
				PreparedStatement pst = con.prepareStatement("delete from employee where eid=?;")) {

			pst.setInt(1, id);

			status = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Employee> getAllEmployee() {
		ArrayList<Employee> emplist = new ArrayList<>();

		try (Connection con = DBconnect.getConnection(); Statement st = con.createStatement()) {

			ResultSet rs = st.executeQuery("select * from employee");

			while (rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setEmpSal(rs.getInt(3));
				e.setEmpJoiningDate(rs.getString(4));
				e.setEmpLocation(rs.getString(5));
				e.setEmpMail(rs.getString(6));
				e.setEmpMobile(rs.getLong(7));
				e.setEmpDid(rs.getInt(8));
				e.setEmpRid(rs.getInt(9));

				emplist.add(e);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return emplist;

	}

	public int updateEmployee(int empid) {

		int count = 0;
		try (Connection con = DBconnect.getConnection();
				PreparedStatement pst = con.prepareStatement(
						"update employee set ename = ?, esalary = ?, ejoin_date = ?, elocation = ?, email = ?, emob_no = ?, edid = ?, erid = ? where eid = ?;")) {

			System.out.println("enter details for update");

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

			pst.setString(1, name);
			pst.setInt(2, salary);
			pst.setString(3, jdate);
			pst.setString(4, location);
			pst.setString(5, email);
			pst.setLong(6, mob_no);
			pst.setInt(7, did);
			pst.setInt(8, rid);
			pst.setInt(9, empid);

			count = pst.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();

		}

		return count;
	}

	public Employee searchEmployeeById(int id) {

		ResultSet rs = null;

		Employee e = null;

		try (Connection con = DBconnect.getConnection();
				PreparedStatement pst = con.prepareStatement("select * from employee where eid = ?")) {

			pst.setInt(1, id);

			rs = pst.executeQuery();

			rs.next();

			e = new Employee();

			e.setEmpId(rs.getInt(1));
			e.setEmpName(rs.getString(2));
			e.setEmpSal(rs.getInt(3));
			e.setEmpJoiningDate(rs.getString(4));
			e.setEmpLocation(rs.getString(5));
			e.setEmpMail(rs.getString(6));
			e.setEmpMobile(rs.getLong(7));
			e.setEmpDid(rs.getInt(8));
			e.setEmpRid(rs.getInt(9));

		} catch (Exception ee) {
			ee.printStackTrace();
		}

		return e;
	}

}
