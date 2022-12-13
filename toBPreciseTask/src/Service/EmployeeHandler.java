package Service;

import Business.EmployeeController;
import Business.Role;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class EmployeeHandler {
    private EmployeeController ec;

    public EmployeeHandler() {
        this.ec = new EmployeeController();
    }
    public String init()
    { String response= "Initated data succesfully - open readme.txt for more information";
        try {
        ec.init();
        }
        catch (Exception e){
            response= e.getMessage();
        }
    return response;
    }
    public String login(Integer empID,String password){
        String response;
        try {
            response= ec.login(empID,password);
        }
        catch (Exception e){
            response=e.getMessage();
        }
        return response;
    }

    public String logout(){
        String response;
        try {
            response= ec.logout();
        }
        catch (Exception e){
            response= e.getMessage();
        }
        return response;
    }
    public Integer CreateNewEmployee(Role role,int managerID, String password, String firstName, String lastName,String position ,String phoneNumber, String adress, String bankName, Number acountNumber, String bankBranch)
    {
        return ec.CreateNewEmployee(role,managerID,password, firstName, lastName, position, phoneNumber, adress,bankName, acountNumber, bankBranch);
    }
    public String setManager(Integer empID, Integer managerID){
        return ec.setManager(empID,managerID);
    }

    public String CreateHeadManager(String password, String firstName, String lastName, String position, String phoneNumber, String address, String bankName, Number acountNumber, String bankBranch) {
        return  ec.CreateHeadManager(password, firstName, lastName, position, phoneNumber, address, bankName,  acountNumber, bankBranch).toString();
    }

    //For each manager, print list of reports from its subordinates (grouped by
    //employee)
    public List<String> getSubReports(){
        return ec.getAllSubReports();
    }
    public String CalculateMonthSalaries(){
        ec.CalculateMonthSalaries();
        return "updated month salaries for-".concat(LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    }
    public String getSalary(){
        Double salary;
        try {
            salary=ec.getSalary();
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
        return salary.toString();
    }
    public String createAssignment(int empID, String taskText, LocalDate taskDate, LocalDate dueDate){
        String response;
        try {
            response= ec.createAssignment(empID, taskText, taskDate,dueDate);
        }
        catch (Exception e){
            response= e.getMessage();
        }
        return response;
    }

    public String submitReport(String reportText, LocalDate reportDate, Double workingHours)
    {
        String response;
        try {
            response= ec.submitReport(reportText, reportDate, workingHours);
        }
        catch (Exception e){
            response= e.getMessage();
        }
        return response;
    }

    //return the logged in employees assignments
    public String getEmployeeAssignments(){
        String response;
        try {
            response= ec.getEmployeeAssignments();
        }
        catch (Exception e){
            response= e.getMessage();
        }
        return response;
    }
    //for each employee return assigned assignments to him
    public List<String> getAllEmployeeAssignments(){
        return ec.getAllEmployeeAssignments();
    }

    public String editEmployee(int eID, String newPhone, String newAddress){
        String response;
        try {
            response= ec.editEmployee(eID, newPhone, newAddress);
        }
        catch (Exception e){
            response= e.getMessage();
        }
        return response;
    }

    public List<String> getAllEmployees()
    {
        return ec.getAllEmployees();
    }

}
