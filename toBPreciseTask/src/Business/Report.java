package Business;

import java.time.LocalDate;

public class Report {
    private String reportText;
    private LocalDate reportDate;
    private Double workingHours;

    public Report(String reportText, LocalDate reportDate, Double workingHours) {
        this.reportText = reportText;
        this.reportDate = reportDate;
        this.workingHours = workingHours;
    }
    public String getReportText() {
        return reportText;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public Double getWorkingHours() {
        return workingHours;
    }
    public String toString(){
        String ans= "Report Date: ".concat(reportDate.toString());
        ans= ans.concat("\nWorking Hours: ").concat(workingHours.toString());
        ans= ans.concat("\nReport text: \n").concat(reportText).concat("\n");
    return ans;
    }
}


