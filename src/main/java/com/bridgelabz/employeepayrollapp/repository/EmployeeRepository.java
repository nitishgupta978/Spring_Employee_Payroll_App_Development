package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeePayrollData, Integer> {
    @Query(value = "select *from employee_payroll, employee_department where employee_id = id and department = :department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeeByDepartment(String department);

    /**
     * Add new method in the Repository Interface with @Query Annotation for Native Queries.
     * Note how department variable is passed to the Native Query.
     *
     */

}
