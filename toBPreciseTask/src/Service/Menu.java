package Service;
import Business.Role;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Menu {
    final int INIT = 0;
    final int CREATE_MANAGER = 1;
    final int CREATE_EMPLOYEE = 2;
    final int SET_MANAGER = 3;
    final int LOGIN = 4;
    final int LOGOUT = 5;
    final int CREATE_ASSIGNMENT = 6;
    final int SUBMIT_REPORT = 7;
    final int EDIT_EMPLOYEE = 8;
    final int CALCULATE_MONTH = 9;
    final int GET_SALARY = 10;
    final int PRINT_SUB_REPORTS = 11;
    final int PRINT_EMPLOYEES_ASS = 12;
    final int PRINT_ALL_EMPLOYEES_ASS = 13;
    final int PRINT_ALL_EMPLOYEES=14;
    final int EXIT = 15;
    EmployeeHandler ehandler;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //string str = br.readLine(); //for string input


    public Menu() {
        this.ehandler = new EmployeeHandler();
        System.out.println('\n' + "----------------------------------------------------------");
        System.out.println('\n' +
                "0000  0 0 0   0000  0000   0000    0000  000  0000   0000" + '\n' +
                "   0  0    0  0  0  0   0  0     0        0  0       0" + '\n' +
                "0000  0 0 0   0000  00     0000  0        0    0     0000" + '\n' +
                "0     0    0  0     0  0   0     0        0      0   0   " + '\n' +
                "0000  0000    0     0   0  0000    0000  000 0000    0000" + '\n');
        System.out.println("----------------------------------------------------------");
        System.out.println("Welcome to 2BPrecise employee's system!");
    }

    public void start() {
        System.out.println("To start press 'Enter' key:");
        try {
            System.in.read();
        } catch (Exception e){}
        boolean run = true;
        String pass,firstName, lastName,position,phone,address, bankName,bankBranch, taskText,reportText;
        Integer accountNumber, managerID, employeeID;
        Double workingHours;
        LocalDate taskDate,dueDate,reportDate;
        while (run) {
            System.out.println("Enter the number of the desired option:");
            System.out.println("0) Initialize with existing scenario data");
            System.out.println("1) Create the root manager");
            System.out.println("2) Create a new employee");
            System.out.println("3) Set existing employee direct manager");
            System.out.println("4) Login to your employee-user");
            System.out.println("5) Logout");
            System.out.println("6) Create new assignment for employee");
            System.out.println("7) Submit a report to direct manager");
            System.out.println("8) Edit employee's phone number and address");
            System.out.println("9) Calculate month's salaries for all employees");
            System.out.println("10) Get salary");
            System.out.println("11) Print all employees reports arranged by manager");
            System.out.println("12) Print your assignments");
            System.out.println("13) Print All employees assignments");
            System.out.println("14) Print All employees");
            System.out.print("15) Exit\n");
            int option = getChoiceInput();
            switch (option) {
                case INIT:
                    System.out.println(ehandler.init());
                    break;
                case CREATE_MANAGER:
                    pass = getStringInput("desired password");
                    firstName = getStringInput("first name");
                    lastName = getStringInput("last name");
                    position = getStringInput("position");
                    phone = getStringInput("phone number");
                    address = getStringInput("address");
                    bankName = getStringInput("bank name");
                    accountNumber = getIntInput("bank account number");
                    bankBranch = getStringInput("bank branch");
                    System.out.println("Your ID and username is:"+ ehandler.CreateHeadManager(pass, firstName, lastName, position, phone, address, bankName, accountNumber, bankBranch));
                    break;
                case CREATE_EMPLOYEE:
                    Role role= getRoleInput();
                    managerID= getIntInput("manager ID");
                    pass = getStringInput("desired password");
                    firstName = getStringInput("first name");
                    lastName = getStringInput("last name");
                    position = getStringInput("position");
                    phone = getStringInput("phone number");
                    address = getStringInput("address");
                    bankName = getStringInput("bank name");
                    accountNumber = getIntInput("bank account number");
                    bankBranch = getStringInput("bank branch");
                   System.out.println("Your ID and username is:"+ ehandler.CreateNewEmployee(role,managerID,pass, firstName, lastName, position, phone, address, bankName, accountNumber, bankBranch));
                    break;
                case SET_MANAGER:
                    employeeID= getIntInput("the employee ID");
                    managerID= getIntInput("the manager ID");
                    System.out.println(ehandler.setManager(employeeID,managerID));
                    break;
                case LOGIN:
                    employeeID= getIntInput("your username/ID");
                    pass = getStringInput("password");
                    System.out.println(ehandler.login(employeeID,pass));
                    break;
                case LOGOUT:
                    System.out.println(ehandler.logout());
                    break;
                case CREATE_ASSIGNMENT:
                    employeeID= getIntInput("the employee's username/ID");
                    taskText=getStringInput("the assignment text:");
                    taskDate= LocalDate.now();
                    dueDate= getDateInput("the due date of the assignment ");
                    System.out.println(ehandler.createAssignment(employeeID,taskText,taskDate,dueDate));
                    break;
                case SUBMIT_REPORT:
                    reportDate=getDateInput("the date of the report ");
                    workingHours= getDoubleInput("the amount of working hours: ");
                    reportText =getStringInput("the report text:\n");
                    System.out.println(ehandler.submitReport(reportText,reportDate,workingHours));
                    break;
                case EDIT_EMPLOYEE:
                    employeeID= getIntInput("the employee's username/ID");
                    phone= getInputOrBlank("new phone number");
                    address=  getInputOrBlank("new adress");
                    System.out.println(ehandler.editEmployee(employeeID,phone,address));
                    break;
                case CALCULATE_MONTH:
                    System.out.println(ehandler.CalculateMonthSalaries());
                    break;
                case GET_SALARY:
                    System.out.println(ehandler.getSalary());
                    break;
                case PRINT_SUB_REPORTS:
                    System.out.println(ehandler.getSubReports());
                    break;
                case PRINT_EMPLOYEES_ASS:
                    System.out.println(ehandler.getEmployeeAssignments());
                    break;
                case PRINT_ALL_EMPLOYEES_ASS:
                    System.out.println(ehandler.getAllEmployeeAssignments());
                    break;
                case PRINT_ALL_EMPLOYEES:
                    System.out.println(ehandler.getAllEmployees());
                    break;
                case EXIT:
                    run = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("No such option - try again");
            }
        }
    }

    private Double getDoubleInput(String field) {
        System.out.println("Please enter " + field);
        double input;
        try {
            input =Double.parseDouble(br.readLine()); // for Integer Input
        }
        catch (Exception e)
        {
            System.out.println("Try again- Please enter a number");
            return getDoubleInput(field);
        }
        return input;
    }
    private String getInputOrBlank(String field) {
        String s="";
        System.out.println("please enter a " + field+ " or click 'Enter' to continue");
        try {
            char c = (char)System.in.read();
            while(c != '\n') {
                s += c;
                c = (char)System.in.read();
            }
        }
            catch (Exception e) {}
        return s;
    }

    private LocalDate getDateInput(String field) {
        String date="";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String instrucion=  field.concat("in the next format dd/MM/yyyy");
        date= getStringInput(instrucion);
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    private Role getRoleInput() {
        System.out.println("These are the existing roles- ");
        System.out.println("(1) Regular employee");
        System.out.println("(2) Manager");
        System.out.println("(3) Manager assistant ");
        System.out.println("(4)- Secretary\n");
        switch (getIntInput("your choice:"))
        {
            case 1:
                return Role.EMPLOYEE;
            case 2:
                return Role.MANAGER;
            case 3:
                return Role.ASSISTANTMANAGER;
            case 4:
                return Role.SECRETARY;
            default:
                return getRoleInput();
        }
    }


    private String getStringInput(String field)  {
        String input;
        System.out.println("Please enter " + field);
        try {
            input= br.readLine();
        }
        catch (Exception e){
            System.out.println("ilegal input - try again");
            return getStringInput(field);
        }
        return input;
    }

    private Integer getIntInput(String field)  {
        System.out.println("Please enter " + field);
        int input;
        try {
            input =Integer.parseInt(br.readLine()); // for Integer Input
        }
        catch (Exception e)
        {
            System.out.println("Try again- Please enter a number");
            return getChoiceInput();
        }
        return input;
    }

    private int getChoiceInput() {
        int input;
        try {
           input =Integer.parseInt(br.readLine()); // for Integer Input
        }
        catch (Exception e)
        {
            System.out.println("Please enter a number according to the desired action");
            return getChoiceInput();
        }
        return input;
    }


}
