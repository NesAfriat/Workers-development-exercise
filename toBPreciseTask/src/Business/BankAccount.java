package Business;

public class BankAccount {
    private String bankName;
    private Number acountNumber;
    private String bankBranch;

    public BankAccount(String bankName, Number acountNumber, String bankBranch) {
        this.bankName = bankName;
        this.acountNumber = acountNumber;
        this.bankBranch = bankBranch;
    }
}
