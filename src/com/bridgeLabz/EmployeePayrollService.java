package com.bridgeLabz;

import java.util.*;

public class EmployeePayrollService {

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO};
    List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    public static String PAYROLL_FILE_NAME = "payroll.file.txt";

    public EmployeePayrollService(List<EmployeePayrollData>list){
        this.employeePayrollList = list;
    }
    public static void main(String[] args) {

        ArrayList<EmployeePayrollData> payrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(payrollList);
        employeePayrollService.readEmployeePayrollData();
        employeePayrollService.writeEmployeePayrollData();

    }
    public void readEmployeePayrollData(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Id :- ");
        int id = scanner.nextInt();
        System.out.print("Enter Employee Name :- ");
        String name = scanner.next();
        System.out.print("Enter Employee Salary :- ");
        double salary = scanner.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }
    public void writeEmployeePayrollData(){

        Iterator iterator = employeePayrollList.iterator();
        while ( iterator.hasNext() ){
            System.out.println(iterator.next() + " ");

        }
    }
}
