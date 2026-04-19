import java.util.ArrayList;

public abstract class Test {
    private String name;
    private ArrayList<Analyte> analytes = new ArrayList<>();

    public Analyte findAnalyte(String aName) {
        for (Analyte analyte : analytes) {
            if (analyte.getName().equalsIgnoreCase(aName)) {
                return analyte;
            }
        }
        return null;
    }
    
    public abstract String interpret(String sex, int age);

    public void setTestName(String name) {
        this.name = name;
    }
    public String getTestName() {
        return name;
    }
    public ArrayList<Analyte> getAnalyteList() {
        return analytes;
    }
}