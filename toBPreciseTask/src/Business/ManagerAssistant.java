package Business;

import java.time.LocalDate;

public class ManagerAssistant extends Employee {

    public ManagerAssistant(int eID, String password, String firstName, String lastName, String position, String phoneNumber, String adress, String bankName, Number acountNumber, String bankBranch) {
        super(eID, password, firstName, lastName, position, phoneNumber, adress, bankName, acountNumber, bankBranch);
    }

    public Double CalculateSalary(){
        double hours= this.calculateTotalHours();
        double salary= (hours * 10)*1.05;
        return salary;
    }
    public String createAssignment(Employee emp, String taskText, LocalDate taskDate, LocalDate dueDate) {
        Assignment as;
        String response="Assignment was delivered succesfuly";
        try {
            as = new Assignment(taskText, taskDate, dueDate);
            checkIsSubEmployee(emp);
            emp.acceptAssignment(as);
        }catch (Exception e) {
            response=e.getMessage();
        }
        return response;
    }

    private void checkIsSubEmployee(Employee emp) throws Exception {
        if (emp.getManagerID()!= this.getManagerID())
            throw new Exception("Not assistant manager of current employee manager");
    }

    public void addEmployee(Employee emp) throws Exception {
        throw new Exception("Non Manager Employee cannot assign new worker");
    }
    @Override
    public String getRole() {
        return "Manager assistant";
    }

}
