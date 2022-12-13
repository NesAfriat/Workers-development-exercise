package Business;

public class Secretary extends Employee {


    public Secretary(int eID, String password, String firstName, String lastName, String position, String phoneNumber, String adress, String bankName, Number acountNumber, String bankBranch) {
        super(eID, password, firstName, lastName, position, phoneNumber, adress, bankName, acountNumber, bankBranch);
    }

    public Double CalculateSalary(){
        double hours= this.calculateTotalHours();
        double salary= (hours * 12)*1.085;
        return salary;
    }

    public String editEmployee(Employee employee, String newPhone, String newAddress) {
        String response= employee.getFullName();
        boolean changed= false;
        if (newPhone != null && newPhone.length()>0) {
            employee.setPhoneNumber(newPhone);
            changed=true;
        }
        if (newAddress != null && newAddress.length()>0) {
            employee.setAddress(newAddress);
            changed=true;
        }
        if (changed)
            response= response.concat(" details has changed succesfully");
        else
            response= response.concat(" details has not changed - empty fields");
        return response;
    }

    public void addEmployee(Employee emp) throws Exception {
        throw new Exception("Non Manager Employee cannot assign new worker");
    }

    @Override
    public String getRole() {
        return "Secretary";
    }

}
