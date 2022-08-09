package com.bridgeLabz;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

public class EmployeePayrollServiceTest {
    @Test

    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {

        EmployeePayrollData[] arrayOfEmp = {
                new EmployeePayrollData(1, "Jeff Bezos", 100000.0),
                new EmployeePayrollData(2, "Bill Gates", 200000.0),
                new EmployeePayrollData(3, "Mark Zuckerberg", 300000.0) };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));

        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);


        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        assertEquals(3, entries);
    }

}