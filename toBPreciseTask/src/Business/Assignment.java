package Business;

import java.time.LocalDate;

public class Assignment {
    private String taskText;
    private LocalDate taskDate;
    private LocalDate dueDate;

    public String getTaskText() {
        return taskText;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Assignment(String taskText, LocalDate taskDate, LocalDate dueDate) {
        this.taskText = taskText;
        this.taskDate = taskDate;
        this.dueDate = dueDate;
    }

    public String toString(){
        String ans= "Assignment Date: ".concat(taskDate.toString());
        ans= ans.concat("\nAssignment due date: ").concat(dueDate.toString());
        ans= ans.concat("\nAssignment text: \n").concat(taskText);
        return ans;
    }
}
