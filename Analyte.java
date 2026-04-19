public class Analyte {
    private String name;
    private String abbreviation;
    private double price;
    private double value;
    private String unit;

    Analyte(String name, String abbreviation, double price) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.price = price;
    }

    public void setValue(double value) {
        this.value = value;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getName() {
        return name;
    }
    public String getAbbrev() {
        return abbreviation;
    }
    public double getPrice() {
        return price;
    }
    public double getValue() {
        return value;
    }
    public String getUnit() {
        return unit;
    }

    public double convertToConventional() {
        double newValue = getValue();
        double conversionRate = 1;

        switch (getName().toLowerCase()) {
            case "fasting blood sugar":
            case "random blood sugar":
                conversionRate = 0.055;
                break;
            case "total cholesterol":
            case "high-density lipoprotein":
            case "low-density lipoprotein":
                conversionRate = 0.026;
                break;
            case "triglycerides":
                conversionRate = 0.0114;
                break;
            case "creatinine":
                conversionRate = 88.4;
                break;
            case "uric acid":
                conversionRate = 0.06;
                break;
            case "blood urea nitrogen":
                conversionRate = 0.357;
                break;
            case "serum glutamic-oxaloacetic transaminase":
            case "serum glutamic-pyruvic transaminase":
            case "lactate dehydrogenase":
                conversionRate = 0.017;
                break;
            case "total calcium":
            case "ionized calcium":
                conversionRate = 0.25;
                break;
            case "urine albumin-to-creatinine ratio":
                conversionRate = 0.113; 
                break;
            default:
                return newValue;
        }

        newValue /= conversionRate;
        return newValue;
    }

    public String getConventionalUnit(String name) {
        switch (name.toLowerCase()) {
            case "fasting blood sugar":
            case "random blood sugar": return "mg/dL";
            case "total cholesterol":
            case "high-density lipoprotein":
            case "low-density lipoprotein":
            case "triglycerides": return "mg/dL";
            case "creatinine": return "mg/dL";
            case "uric acid": return "mg/dL";
            case "blood urea nitrogen": return "mg/dL";
            case "serum glutamic-oxaloacetic transaminase":
            case "serum glutamic-pyruvic transaminase":
            case "lactate dehydrogenase": return "U/L";
            case "sodium":
            case "potassium":
            case "chloride": return "mEq/L";
            case "total calcium":
            case "ionized calcium": return "mg/dL";
            case "urine albumin-to-creatinine ratio": return "mg/g";
            case "platelets":
            case "white blood count": return "k/mm3";
            case "hemoglobin":
            case "mean corpuscular hemoglobin concentration": return "g/dL";
            case "packed cell volume":
            case "red blood cell distribution width": return "%";
            case "red blood count": return "millions/mm3";
            case "mean corpuscular volume":
            case "mean platelet volume": return "fL";
            case "mean corpuscular hemoglobin": return "pg";
            default: return "";
        }
    }

    public boolean isSIUnit(String unit) {
        switch (unit.toLowerCase()) {
            case "mmol/l":
            case "µmol/l":
            case "ukat/l":
            case "meq/l":
            case "mg/mmol":
            case "mg/g": 
                return true;
            default:
                return false;
        }
    }

}
