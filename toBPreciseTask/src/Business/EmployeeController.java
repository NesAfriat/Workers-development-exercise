package Business;
import com.sun.org.apache.xml.internal.security.Init;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EmployeeController {
    private HashMap<Integer,Employee> employeeList; //employees by their ID
    private HashMap<Integer,Double> employeeSalaries; //Salaries by employees ID's
    private Integer eID_Counter; //Employee ID Counter
    private Employee headManager;
    private Employee loggedIn;



    public EmployeeController() {
        this.employeeList = new HashMap<>();
        this.employeeSalaries= new HashMap<>();
        this.eID_Counter = -1;
        loggedIn=null;
        this.headManager= null;
    }
    public Integer CreateHeadManager(String password, String firstName, String lastName, String position, String phoneNumber, String adress, String bankName, Number acountNumber, String bankBranch) {
        this.eID_Counter +=1;
        Employee e=new Manager(eID_Counter,password, firstName, lastName, position, phoneNumber, adress, bankName, acountNumber, bankBranch);
        this.employeeList.put(eID_Counter,e);
        return this.eID_Counter;
    }

    public Integer CreateNewEmployee(Role role,int managerID, String password, String firstName, String lastName,String position ,String phoneNumber, String adress, String bankName, Number acountNumber, String bankBranch) {
        Employee e;
        this.eID_Counter +=1;
        switch (role)
        {
            case MANAGER:
                e= new Manager(eID_Counter,password, firstName, lastName, position, phoneNumber, adress, bankName, acountNumber, bankBranch);
                break;
            case SECRETARY:
                e= new Secretary(eID_Counter,password, firstName, lastName, position, phoneNumber, adress, bankName, acountNumber, bankBranch);
                break;
            case ASSISTANTMANAGER:
                e= new ManagerAssistant(eID_Counter,password, firstName, lastName, position, phoneNumber, adress, bankName, acountNumber, bankBranch);
                break;
            default:
                e= new Employee(eID_Counter,password, firstName, lastName, position, phoneNumber, adress, bankName, acountNumber, bankBranch);
                break;
        }
        this.employeeList.put(eID_Counter,e);
        setManager(eID_Counter, managerID);
        return this.eID_Counter;
    }
    public String setManager(Integer empID, Integer managerID) {
        Employee man,emp;
        try {
            emp = getEmployeeByID(empID);
            man = getEmployeeByID(managerID);
            man.addEmployee(emp);
            emp.setManagerID(managerID);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Worker assiged Succesfuly to- ".concat(man.getFirstName()).concat(" ").concat(man.getLastName());
    }

    public Employee getEmployeeByID(Integer empID) {
        return employeeList.get(empID);
    }

    public void CalculateMonthSalaries() {
        for (Employee emp:employeeList.values()
             ) {
            employeeSalaries.put(emp.getID(),emp.CalculateSalary());
        }
    }
    public Double getSalary() throws Exception {
        if (loggedIn==null)
            throw new Exception("Not logged In");
        if (!employeeSalaries.containsKey(this.loggedIn.getID()))
            throw new Exception("Did not calculated month salaries wait, sorry");
        return employeeSalaries.get(this.loggedIn.getID());
    }

    public String login(Integer empID, String password) throws Exception {
        Employee emp;
        if (this.loggedIn!=null){
            throw new Exception("Already logged in");
        }
        else if(!employeeList.containsKey(empID)){
            throw new Exception("Employee ID does not exist");
        }
        else
        emp= employeeList.get(empID);
        if(!password.equals(emp.getPassword())){
            throw new Exception("Illegal password");
        }
        this.loggedIn=emp;
        return "Logged in succesfully,".concat(" Hello ").concat(emp.getFullName());
    }

    public String logout() throws Exception {
        Employee emp;
        if (this.loggedIn==null){
            throw new Exception("No one is logged in");
        }
        emp=loggedIn;
        this.loggedIn=null;
        return "Logged out succesfully,".concat(" GoodBye ").concat(emp.getFirstName());
    }

    public String getSubReports() {
        String subReports="Your employees reports:";
        String subReport;
        for (Employee emp: employeeList.values()
             ) {
            subReport=emp.getSubReports();
            if (subReport!= null){
                subReports.concat("\n").concat(emp.getFullName()).concat("'s employees:");
                subReports.concat(subReport);
            }
        }
        return subReports;
    }
    public List<String> getAllSubReports(){
        List<String> employeesReports = new ArrayList<>();
        employeesReports.add("Employees reports arranged by managers:\n");
        for (Employee emp: employeeList.values()
        ) {
            String reports = emp.getSubReports();
            if (!reports.isEmpty())
                employeesReports.add(reports);
        }
        return employeesReports;
    }

    public String createAssignment(int empID, String taskText, LocalDate taskDate, LocalDate dueDate) throws Exception {
    String response;
    Employee employee;
    if (loggedIn==null)
        throw new Exception("Not logged In");
    try {
        employee= getEmployeeByID(empID);
        response= loggedIn.createAssignment(employee, taskText, taskDate, dueDate);
    }catch (Exception e)
    {
        response= e.getMessage();
    }
    return response;
    }

    public String submitReport(String reportText, LocalDate reportDate, Double workingHours) throws Exception {
        String response;
        Employee manager;
        if (loggedIn==null)
            throw new Exception("Not logged In");
        try {
            manager= getEmployeeByID(loggedIn.getManagerID());
            response= loggedIn.submitReport(manager,reportText, reportDate, workingHours);
        }catch (Exception e)
        {
            response= e.getMessage();
        }
        return response;
    }

    public String editEmployee(int eID, String newPhone, String newAddress) throws Exception {
        String response;
        Employee employee;
        if (loggedIn==null)
            throw new Exception("Not logged In");
        try {
            employee= getEmployeeByID(eID);
            response= loggedIn.editEmployee(employee, newPhone, newAddress);
        }catch (Exception e)
        {
            response= e.getMessage();
        }
        return response;
    }

    public List<String> getAllEmployees()  {
        List<String> employees = new ArrayList<>();
        employees.add("The employees list:\n");
        for (Employee emp: employeeList.values()
        ) {
            employees.add(emp.toString());
        }
        return employees;
    }
    public String getEmployeeAssignments() throws Exception {
        String employeeAssignment;
        if (loggedIn==null)
            throw new Exception("Not logged In");
        employeeAssignment= loggedIn.getFullName().concat("'s Assignments:\n");
            for (String as: loggedIn.getAssignmentList())
             {
                 employeeAssignment= employeeAssignment.concat(as).concat("\n");
            }
        return employeeAssignment;
    }

    public List<String> getAllEmployeeAssignments() {
        List<String> employeeAssignments = new ArrayList<>();
        employeeAssignments.add("The company total employees assignments:\n");
        for (Employee emp: employeeList.values()
        ) {
            String singleEmployee= emp.getFullName().concat("'s assignments:\n");
            List<String> assigments =emp.getAssignmentList();
            if (assigments.isEmpty())
                singleEmployee= singleEmployee.concat(" None.\n");
            for (String as: assigments
                 ) {
               singleEmployee= singleEmployee.concat(as).concat("\n");
            }
            employeeAssignments.add(singleEmployee);
        }
        return employeeAssignments;
    }


    public void init() throws Exception {
        InitClass init= new InitClass(this);
        init.start();
    }
}
