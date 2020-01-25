package com.practice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.dao.EmployeeDAO;
import com.practice.model.Employee;

@Controller
public class MainController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value = "/home")
	public ModelAndView listEmployees(ModelAndView model) throws IOException {
		List<Employee> employees = employeeDAO.list();
		model.addObject("employees", employees);
		model.setViewName("Home");
		
		return model;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee newEmployee = new Employee();
		model.addObject("employee", newEmployee);
		model.setViewName("EmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		employeeDAO.saveOrUpdate(employee);
		System.out.println("SAVE");
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("id"));
		employeeDAO.delete(empId);
		System.out.println("DELETE");
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeDAO.get(empId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		System.out.println("UPDATE");
		model.addObject("employee", employee);

		return model;
	}
}