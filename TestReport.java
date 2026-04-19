import java.time.LocalDate;
import java.util.ArrayList;

public class TestReport {
    private Patient patient;
    private ArrayList<Test> tests = new ArrayList<>();
    private String referenceDoc;
    private LocalDate reportDate;

    public TestReport(Patient patient, ArrayList<Test> tests, String referenceDoc) {
        this.patient = patient;
        this.tests = tests;
        this.referenceDoc = referenceDoc;
        this.reportDate = LocalDate.now();
    }

    public Patient getPatient() { 
        return patient; 
    }
    public String getReferenceDoc() { 
        return referenceDoc; 
    }
    public ArrayList<Test> getTests() { 
        return tests; 
    }
    public LocalDate getReportDate() { 
        return reportDate; 
    }
}
