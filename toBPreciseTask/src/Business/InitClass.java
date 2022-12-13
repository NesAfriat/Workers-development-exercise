package Business;

import java.time.LocalDate;
import java.util.HashMap;

public class InitClass {
    private EmployeeController employeeController;
    String password= "123";
    String CEOfirstName= "Mr.";
    String CEOlastName= "Nice";
    String CEOposition= "CEO";
    String phoneNumber= "0501234567";
    String adress= "Energy 77, Beer Sheba";
    String bankName= "Banky";
    Number acountNumber= 12345;
    String bankBranch= "What";
    String  managerName= "Yair";
    String  managerPosition= "Product manager";
    String employeesNames[] = {"Alon", "Ben","Galit","Evyatar"};
    String positions[] = {"Programmer", "QA","PM assistant","PM secretary"};
    Role roles[]= {Role.EMPLOYEE,Role.EMPLOYEE,Role.ASSISTANTMANAGER,Role.SECRETARY};
    String taskText[]= {"handle code","handle bugs","handle the rest", "handle the meetings"};
    String reportText1[]= {"went good", "went bad", "went well", "meeting executed"};
    Double workingHours1[]= {5.0,10.0,15.0,20.0};
    String reportText2[]= {"went good", "went bad", "went well", "meeting executed"};
    Double workingHours2[]= {10.0,20.0,30.0,40.0};
    public InitClass(EmployeeController employeeController) {
        this.employeeController= employeeController;
    }

    public void start() throws Exception {
        System.out.println("Start updating the data -");
        System.out.println("-------------------------");
        System.out.println("--------LOADING----------");
        System.out.println("-------------------------");
        //create root manager
        Integer ceoID= employeeController.CreateHeadManager(password,CEOfirstName,CEOlastName,CEOposition,phoneNumber,adress,bankName,acountNumber,bankBranch);
        //create a manager
        Integer managerID= employeeController.CreateNewEmployee(Role.MANAGER, ceoID,password,managerName,managerName,managerPosition,phoneNumber,adress,bankName,acountNumber,bankBranch);
        employeeController.login(managerID,password);
        //init 4 workers
        for(int i=0; i<4; i++) {
            //create 4 different employees of the manager
            Integer eID = employeeController.CreateNewEmployee(roles[i], managerID, password, employeesNames[i], employeesNames[i], positions[i], phoneNumber, adress, bankName, acountNumber, bankBranch);
            //create assignments for each employee
            employeeController.createAssignment(eID, taskText[i], LocalDate.now().minusDays(2), LocalDate.now().minusDays(1));
            employeeController.createAssignment(eID, taskText[i].concat("again"), LocalDate.now(), LocalDate.now());
        }
        employeeController.logout();
        //submit 2 reports from each employee
            for(int i=2; i<6; i++)
            {
            //submit 2 reports from each employee
                employeeController.login(i,password);
            employeeController.submitReport(reportText1[i-2],LocalDate.now(),workingHours1[i-2]);
            employeeController.submitReport(reportText2[i-2],LocalDate.now(),workingHours2[i-2]);
            employeeController.logout();
        }

    }
}
