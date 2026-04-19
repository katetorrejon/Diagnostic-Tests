import java.time.LocalDate;
import java.time.Period;

public class Patient {
    private String patientName, patientSex, patientID;
    private static int ID_Count = 1;
    private LocalDate patientDOB;
    private int patientAge;

    Patient(String patientName, String patientSex, LocalDate patientDOB) {
        this.patientName = patientName;
        this.patientSex = patientSex;
        this.patientID = String.format("PAT-%03d", ID_Count++);
        this.patientDOB = patientDOB;
        this.patientAge = Period.between(this.patientDOB, LocalDate.now()).getYears();
    }

    public String getPatientName() {
        return patientName;
    }
    public String getPatientSex() {
        return patientSex;
    }
    public String getPatientID() {
        return patientID;
    }
    public LocalDate getPatientDOB() {
        return patientDOB;
    }
    public int getPatientAge() {
        return patientAge;
    }
}