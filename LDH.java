// Lactate Dehydrogenase Test

public class LDH extends Test {
    LDH() {
        setTestName("Lactate Dehydrogenase Test");

        getAnalyteList().add(new Analyte("Lactate Dehydrogenase", "LDH", 0));
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
            if (analyte.getName().equalsIgnoreCase("Lactate Dehydrogenase")) {
                if (sex.equalsIgnoreCase("Male")) {
                    if (age > 19) {
                        if (value > 225) {
                            interpretation = "HIGH";
                        } else if (value < 135) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 16) {
                        if (value > 235) {
                            interpretation = "HIGH";
                        } else if (value < 105) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 10) {
                        if (value > 290) {
                            interpretation = "HIGH";
                        } else if (value < 120) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 7) {
                        if (value > 300) {
                            interpretation = "HIGH";
                        } else if (value < 145) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 1) {
                        if (value > 345) {
                            interpretation = "HIGH";
                        } else if (value < 155) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 450) {
                            interpretation = "HIGH";
                        } else if (value < 170) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                } else {
                    if (age > 19) {
                        if (value > 214) {
                            interpretation = "HIGH";
                        } else if (value < 135) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 16) {
                        if (value > 230) {
                            interpretation = "HIGH";
                        } else if (value < 105) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 13) {
                        if (value > 275) {
                            interpretation = "HIGH";
                        } else if (value < 100) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 10) {
                        if (value > 260) {
                            interpretation = "HIGH";
                        } else if (value < 120) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 7) {
                        if (value > 280) {
                            interpretation = "HIGH";
                        } else if (value < 140) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 4) {
                        if (value > 345) {
                            interpretation = "HIGH";
                        } else if (value < 135) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 1) {
                        if (value > 395) {
                            interpretation = "HIGH";
                        } else if (value < 165) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 420) {
                            interpretation = "HIGH";
                        } else if (value < 190) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                }
            }
        }
        return interpretation;
    }
}
