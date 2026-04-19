// Renal or Kidney Function Test

public class RFT extends Test {
    RFT() {
        setTestName("Renal Function Test");

        getAnalyteList().add(new Analyte("Estimated Glomerular Filtration Rate", "eGFR", 0));
        getAnalyteList().add(new Analyte("Urine Albumin-to-Creatinine Ratio", "uACR", 0));
        getAnalyteList().add(new Analyte("Blood Urea Nitrogen", "BUN", 0));
        getAnalyteList().add(new Analyte("Uric Acid", "UA", 0));
        getAnalyteList().add(new Analyte("Creatinine", "sCr", 0));
    }

    @Override
    public String interpret(String sex, int age) {
        String interpretation = "";
        for (Analyte analyte : getAnalyteList()) {
            double value = analyte.getValue();
            String unit = analyte.getUnit();

            if (analyte.isSIUnit(unit)) {
                value = analyte.convertToConventional();
                unit = analyte.getConventionalUnit(analyte.getName());
            }

            switch(analyte.getName().toLowerCase()) {
                case "estimated glomerular filtration rate":
                    if (value >= 90) {
                        interpretation = "NORMAL";
                    } else if (value > 59) {
                        interpretation = "Slightly decreased";
                    } else if (value > 44) {
                        interpretation = "Mildly decreased";
                    } else if (value > 29) {
                        interpretation = "Moderately decreased";
                    } else if (value > 14) {
                        interpretation = "Severely decreased";
                    } else {
                        interpretation = "Kidney failure";
                    }
                    break;
                case "urine albumin-to-creatinine ratio":
                    if (value >= 300) {
                        interpretation = "Severely increased";
                    } else if (value >= 30) {
                        interpretation = "Moderately increased";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "blood urea nitrogen":
                    if (value > 20) {
                        interpretation = "HIGH";
                    } else if (value < 6) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "uric acid":
                    if (sex.equalsIgnoreCase("Male")) {
                        if (value > 7.2) {
                            interpretation = "HIGH";
                        } else if (value < 3.5) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 6.0) {
                            interpretation = "HIGH";
                        } else if (value < 2.6) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                    break;
                case "creatinine":
                    if (sex.equalsIgnoreCase("Male")) {
                        if (value > 1.3) {
                            interpretation = "HIGH";
                        } else if (value < 0.9) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 1.2) {
                            interpretation = "HIGH";
                        } else if (value < 0.6) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }       
                    break;         
            }
        }
        return interpretation;
    }
}
