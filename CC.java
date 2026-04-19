// Clinical Chemistry

public class CC extends Test {
    CC() {
        setTestName("Clinical Chemistry Test");
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

            switch (analyte.getName().toLowerCase()) {
                case "fasting blood sugar":
                    if (value > 100) {
                        interpretation = "HIGH";
                    } else if (value < 74) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "random blood sugar":
                    if (value > 140) {
                        interpretation = "HIGH";
                    } else if (value < 70) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "total cholesterol":
                    if (value > 200) {
                        interpretation = "HIGH";
                    } else if (value < 150) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "high-density lipoprotein":
                    if (sex.equalsIgnoreCase("Male")) {
                        if (value > 80) {
                            interpretation = "HIGH";
                        } else if (value < 35) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 88) {
                            interpretation = "HIGH";
                        } else if (value < 42) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                    break;
                case "low-density lipoprotein":
                    if (value > 130) {
                        interpretation = "HIGH";
                    } else if (value < 50) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "triglycerides":
                    if (sex.equalsIgnoreCase("Male")) {
                        if (value > 165) {
                            interpretation = "HIGH";
                        } else if (value < 60) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 140) {
                            interpretation = "HIGH";
                        } else if (value < 40) {
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
                case "blood urea nitrogen":
                    if (value > 20) {
                        interpretation = "HIGH";
                    } else if (value < 6) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "serum glutamic-oxaloacetic transaminase":
                    if (value >= 46) {
                        interpretation = "HIGH";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "serum glutamic-pyruvic transaminase":
                    if (value >= 49) {
                        interpretation = "HIGH";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "sodium":
                    if (value > 145) {
                        interpretation = "HIGH";
                    } else if (value < 135) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "potassium":
                    if (value > 5) {
                        interpretation = "HIGH";
                    } else if (value < 3.5) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "chloride":
                    if (value > 110) {
                        interpretation = "HIGH";
                    } else if (value < 96) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "total calcium":
                    if (value > 10.28) {
                        interpretation = "HIGH";
                    } else if (value < 8.6) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "ionized calcium":
                    if (value > 5.2) {
                        interpretation = "HIGH";
                    } else if (value < 4.4) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
            }
        }
        return interpretation;
    }

    public static String getAbbreviation(String name) {
        switch (name.toLowerCase()) {
            case "fasting blood sugar": return "FBS";
            case "random blood sugar": return "RBS";
            case "total cholesterol": return "TC";
            case "high-density lipoprotein": return "HDL";
            case "low-density lipoprotein": return "LDL";
            case "triglycerides": return "TG";
            case "creatinine": return "sCr";
            case "uric acid": return "UA";
            case "blood urea nitrogen": return "BUN";
            case "serum glutamic-oxaloacetic transaminase": return "AST / SGOT";
            case "serum glutamic-pyruvic transaminase": return "ALT / SGPT";
            case "sodium": return "Na";
            case "potassium": return "K";
            case "chloride": return "Cl";
            case "total calcium": return "TCa";
            case "ionized calcium": return "iCa";
            default: return name.substring(0, Math.min(3, name.length())).toUpperCase();
        }
    }

    public static double getPrice(String name) {
        switch (name.toLowerCase()) {
            case "fasting blood sugar": return 100.0;
            case "random blood sugar": return 100.0;
            case "total cholesterol": return 150.0;
            case "high-density lipoprotein": return 120.0;
            case "low-density lipoprotein": return 120.0;
            case "triglycerides": return 130.0;
            case "creatinine": return 80.0;
            case "uric acid": return 90.0;
            case "blood urea nitrogen": return 110.0;
            case "serum glutamic-oxaloacetic transaminase": return 140.0;
            case "serum glutamic-pyruvic transaminase": return 140.0;
            case "sodium": return 70.0;
            case "potassium": return 70.0;
            case "chloride": return 70.0;
            case "total calcium": return 100.0;
            case "ionized calcium": return 120.0;
            default: return 0.0;
        }
    }
}
