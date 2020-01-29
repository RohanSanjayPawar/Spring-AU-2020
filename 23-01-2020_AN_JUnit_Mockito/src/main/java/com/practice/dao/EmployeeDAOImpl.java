package com.practice.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.practice.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String EMP_ID = "EMP_ID";
	private static final String FIRSTNAME = "FIRSTNAME";
	private static final String LASTNAME = "LASTNAME";
	private static final String DESIGNATION = "DESIGNATION";
	private static final String DEPARTMENT = "DEPARTMENT";
	
	// Lambda Wrapper to handle exceptions in lambda functions
	static RowMapper<Employee> lambdaWrapperExcpetion(RowMapper<Employee> rowMapper) {
		return (ResultSet rs, int id) -> {
			try {
				Employee employee = new Employee();

				employee.setId(rs.getInt(EMP_ID));
				employee.setFirstName(rs.getString(FIRSTNAME));
				employee.setLastName(rs.getString(LASTNAME));
				employee.setDesignation(rs.getString(DESIGNATION));
				employee.setDepartment(rs.getString(DEPARTMENT));

				return employee;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		};
	}

	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl() {
		
	}
	
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean saveOrUpdate(Employee employee) {
		// ID object is not initialized in the employee object, so if ID is greater than
		// 0, then that employee already exists in the DB
		try {
			if (employee.getId() > 0) {
				String sql = "UPDATE EMPLOYEE SET FIRSTNAME=?, LASTNAME=?, DESIGNATION=?, DEPARTMENT=? WHERE EMP_ID=?";
				jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getDesignation(),
						employee.getDepartment(), employee.getId());
			} else {
				String sql = "INSERT INTO EMPLOYEE(FIRSTNAME, LASTNAME, DESIGNATION, DEPARTMENT) VALUES (?, ?, ?, ?)";
				jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getDesignation(),
						employee.getDepartment());
			}
			return true;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM EMPLOYEE WHERE EMP_ID=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Employee get(int id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID=" + id;
		return jdbcTemplate.query(sql, (ResultSet rs) -> {
			if (rs.next()) {
				Employee employee = new Employee();

				employee.setId(rs.getInt(EMP_ID));
				employee.setFirstName(rs.getString(FIRSTNAME));
				employee.setLastName(rs.getString(LASTNAME));
				employee.setDesignation(rs.getString(DESIGNATION));
				employee.setDepartment(rs.getString(DEPARTMENT));

				return employee;
			}
			return null;
		});
	}

	@Override
	public List<Employee> list() {
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> employees = jdbcTemplate.query(sql, lambdaWrapperExcpetion((ResultSet rs, int rowNum) -> {
			Employee employee = new Employee();

			employee.setId(rs.getInt("EMP_ID"));
			employee.setFirstName(rs.getString("FIRSTNAME"));
			employee.setLastName(rs.getString("LASTNAME"));
			employee.setDesignation(rs.getString("DESIGNATION"));
			employee.setDepartment(rs.getString("DEPARTMENT"));

			System.out.println(employee);
			return employee;
		}));

		return employees;
	}

}