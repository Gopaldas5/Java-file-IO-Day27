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

        Scanner consoleInputReader = new Scanner(System.in);
        //Scanner consoleInputReader = null;
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);

    }
    public void readEmployeePayrollData( Scanner consoleInputReader){

        System.out.print("Enter employee ID :- ");
        int id = Integer.parseInt(consoleInputReader.nextLine());
        System.out.print("Enter employee name :- ");
        String name = consoleInputReader.nextLine();
        System.out.print("Enter employee salary :- ");
        double salary = Double.parseDouble(consoleInputReader.nextLine());

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }
    public void writeEmployeePayrollData(IOService ioService){
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollList);

    }
    public void printData(IOService ioService) {
        new EmployeePayrollFileIOService().printData();
    }
    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }
}
