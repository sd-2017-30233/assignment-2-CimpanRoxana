package com.javasampleapproach.marshalling.controller;

import com.javasampleapproach.marshalling.dao.EmployeeDao;
import com.javasampleapproach.marshalling.liste.EmployeeList;
import com.javasampleapproach.marshalling.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/**
 * Created by Roxana on 04-May-17.
 */

@Controller
@RequestMapping("/")
public class EmployeeController {

    private EmployeeDao employeeDao = new EmployeeDao();

    @RequestMapping(value = "/viewAllEmployees", method = RequestMethod.GET)
    public ModelAndView getEmployees() throws Exception {
        EmployeeList employeeList = employeeDao.getAllEmployees();
        List<Employee> employeeList1 = employeeList.getListOfEmployees();

        ModelAndView mav = new ModelAndView("employees");
        mav.addObject("employeeList1", employeeList1);

        return mav;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "AddEmployeeForm";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployeeSubmit(@ModelAttribute("employee") Employee angajat) throws Exception{
        employeeDao.addEmployee(angajat);
        return "addEmployee";
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public String deleteEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "deleteEmployeeForm";
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployeeSubmit(@ModelAttribute("employee") Employee angajat) throws Exception {
        employeeDao.deleteEmployee(angajat);
        return "deleteEmployee";
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
    public String updateEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "updateEmployeeForm";
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute Employee angajat) throws Exception {

        Employee a = employeeDao.getEmployee(angajat.getName());
        employeeDao.updateEmployeeAddress(angajat, angajat.getAddress());
        angajat.setName(a.getName());
        angajat.setNumericPersonalCode(a.getNumericPersonalCode());
        return "updateEmployee";
    }
}
