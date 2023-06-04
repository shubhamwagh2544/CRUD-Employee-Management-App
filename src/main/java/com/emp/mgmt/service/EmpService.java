package com.emp.mgmt.service;

import com.emp.mgmt.entities.Employee;
import com.emp.mgmt.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;

    public void addEmp(Employee employee) {
        this.empRepo.save(employee);
    }

    public List<Employee> getAllEmp() {
        return this.empRepo.findAll();
    }

    public Employee getEmpById(int id) {
        Optional<Employee> employee = this.empRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    public void deleteEmpById(int id) {
        this.empRepo.deleteById(id);
    }

}
