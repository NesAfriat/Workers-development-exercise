package Business;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int eID;
    private int managerID;
    private String password;
    private String firstName;
    private String lastName;
    private String position;

    private String phoneNumber;
    private String adress;
    private BankAccount bankAccount;
    protected List<Report> reportList;
    protected List<Assignment> assignmentList;

    public Employee(int eID, String password, String firstName, String lastName, String position, String phoneNumber, String adress, String bankName, Number acountNumber, String bankBranch) {
        this.eID = eID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.bankAccount = new BankAccount(bankName, acountNumber, bankBranch);
        this.reportList = new ArrayList<>();
        this.assignmentList = new ArrayList<>();
    }

    protected double calculateTotalHours() {
        double hours = 0.0;
        List<Report> toRemove = new ArrayList<>();
        LocalDate currentdate = LocalDate.now();
        for (Report r : reportList
        ) {
            if (currentdate.getMonth().equals(r.getReportDate().getMonth()))
                hours += r.getWorkingHours();
            toRemove.add(r);
        }
        reportList.removeAll(toRemove);
        return hours;
    }

    public Double CalculateSalary() {
        {
            double salary;
            double hours = calculateTotalHours();
            int total_completed = this.getCompletedTasks();
            salary = hours * 10 + total_completed * 5;
            return salary;
        }
    }
    public void addEmployee(Employee emp) throws Exception {
        throw new Exception("Non Manager Employee cannot assign new worker");
    }
    protected String getFullName() {
        return this.firstName.concat(" ").concat(this.lastName);
    }

    protected int getCompletedTasks() {
        int completed = 0;
        LocalDate curr = LocalDate.now();
        LocalDate assDueDate;
        for (Assignment as : assignmentList
        ) {
            assDueDate = as.getDueDate();
            if (assDueDate.getMonth().equals(curr.getMonth()) && assDueDate.isBefore(curr)) {
                completed++;
            }
        }
        return completed;
    }
    public String createAssignment(Employee empID, String taskText, LocalDate taskDate, LocalDate dueDate) throws Exception {
        throw new Exception("Only manager or assistantManager can create assignment for another worker");
    }
    public void acceptAssignment(Assignment as) {
        assignmentList.add(as);
    }
    public String submitReport(Employee manager,String reportText, LocalDate reportDate, Double workingHours) throws Exception {
        Report report;
        String response="Report was delivered succesfuly";
        try {
            report = new Report(reportText,reportDate,workingHours);
            manager.acceptReport(this,report);
            reportList.add(report);
        }catch (Exception e) {
            response=e.getMessage();
        }
        return response;
    }

    public void acceptReport(Employee emp,Report report) throws Exception {
        throw new Exception("The reports are submitted only to the direct manager");
    }

    public String getSubReports()  {
        return "";
    }

    public void addReport(Report report) {
        reportList.add(report);
    }


    public int getID() {
        return eID;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return adress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.adress = address;
    }


    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public List<String> getAssignmentList() {
        List<String> assignments= new ArrayList<>();
        for (Assignment as: assignmentList
             ) {
            assignments.add(as.toString());
        }
        return assignments;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String  toString()
    {
        String emp= "\n";
        emp= emp.concat("Employee ID: ").concat(Integer.toString(getID())).concat("\n");
        emp= emp.concat("Full name: ").concat(getFullName()).concat("\n");
        emp= emp.concat("Role: ").concat(getRole()).concat("\n");
        emp= emp.concat("Position: ").concat(getPosition()).concat("\n");
        emp= emp.concat("Phone : ").concat(getPhoneNumber()).concat("\n");
        emp= emp.concat("Adress: ").concat(getAddress()).concat("\n");
        return emp;
    }

    public String getRole() {
        return "Employee";
    }

    public String editEmployee(Employee employee, String newPhone, String newAddress) throws Exception {
        throw new Exception("Only secretary can edit employee's phone number and adress");
    }
}

