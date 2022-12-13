package Business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager extends Employee {
    HashMap<Employee, List<Report>> employeesRep;

    public Manager(int eID, String password, String firstName, String lastName, String position, String phoneNumber, String adress, String bankName, Number acountNumber, String bankBranch) {
        super(eID, password, firstName, lastName, position, phoneNumber, adress, bankName, acountNumber, bankBranch);
        this.employeesRep=new HashMap<>();
    }
    public void addEmployee(Employee emp) {
        employeesRep.put(emp,new ArrayList<>());
    }

    public String createAssignment(Employee emp, String taskText, LocalDate taskDate, LocalDate dueDate) {
        Assignment as;
        String response="Assignment was delivered succesfuly";
        try {
            as = new Assignment(taskText, taskDate, dueDate);
            Employee employee = getSubEmployee(emp.getID()); //also checks if is direct worker
            employee.acceptAssignment(as);
        }catch (Exception e) {
        response=e.getMessage();
        }
        return response;
    }

    public void acceptReport(Employee emp,Report report) throws Exception {
        if (!isEmployee(emp))
            throw new Exception("Manager received report from undirect employee");
        List<Report> reports= employeesRep.get(emp);
        reports.add(report);
    }

    @Override
    public Double CalculateSalary() {
        double hours= this.calculateTotalHours();
        double salary= (hours * 20)*1.15;
        return salary;
    }

    @Override
    public String getSubReports() {
        String ans= "Manager: ".concat(this.getFullName()).concat("\n");
        ans= ans.concat("Employees reports:\n");
        for (Employee emp: employeesRep.keySet()
                  ) {
            ans= ans.concat("\n").concat(emp.getFullName()).concat(" reports:\n");
            ans= ans.concat("--------------------------------------").concat("\n");
            List<Report>reports= employeesRep.get(emp);
            if(reports.isEmpty())
                ans=ans.concat("None.\n");
            else
            for (Report r:employeesRep.get(emp)
                 ) {
                ans= ans.concat(r.toString());
            }
        }
        return ans;
    }


    public boolean isEmployee(Employee employee) {
        if(employeesRep.containsKey(employee))
            return true;
        return false;
    }


    private Employee getSubEmployee(int empID) throws Exception {
        Employee emp= null;
        for (Employee e:employeesRep.keySet()
             ) {
            if (e.getID()==empID)
                emp=e;
        }
        if(emp==null)
            throw new Exception("The given employee is not your worker");
        return emp;
    }
    @Override
    public String getRole() {
        return "Manager";
    }

    }
