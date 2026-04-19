// Complete Blood Count

public class CBC extends Test {
    CBC() {
        setTestName("Complete Blood Count");

        getAnalyteList().add(new Analyte("White Blood Count", "WBC", 0));
        getAnalyteList().add(new Analyte("Hemoglobin", "Hb", 0));
        getAnalyteList().add(new Analyte("Packed Cell Volume", "PCV", 0));
        getAnalyteList().add(new Analyte("Platelets", "PLT", 0));
        getAnalyteList().add(new Analyte("Red Blood Count", "RBC", 0));
        getAnalyteList().add(new Analyte("Red Blood Cell Distribution Width", "RDW", 0));
        getAnalyteList().add(new Analyte("Mean Corpuscular Volume", "MCV", 0));
        getAnalyteList().add(new Analyte("Mean Platelet Volume", "MPV", 0));
        getAnalyteList().add(new Analyte("Mean Corpuscular Hemoglobin", "MCH", 0));
        getAnalyteList().add(new Analyte("Mean Corpuscular Hemoglobin Concentration", "MCHC", 0));
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
                case "white blood count":
                    if (age > 17) {
                        if (value > 10.5) {
                            interpretation = "HIGH";
                        } else if (value < 3.7) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 5) {
                        if (value > 13) {
                            interpretation = "HIGH";
                        } else if (value < 4.5) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 3) {
                        if (value > 15.5) {
                            interpretation = "HIGH";
                        } else if (value < 5) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 1) {
                        if (value > 15.5) {
                            interpretation = "HIGH";
                        } else if (value < 5.5) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age == 1) {
                        if (value > 17) {
                            interpretation = "HIGH";
                        } else if (value < 6) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 17.5) {
                            interpretation = "HIGH";
                        } else if (value < 6) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }

                    if (value >= 50 || value <= 1) {
                        interpretation = "CRITICAL";
                    }
                    break;
                case "hemoglobin":
                    if (age > 17) {
                        if (sex.equalsIgnoreCase("Male")) {
                            if (value > 17.7) {
                                interpretation = "HIGH";
                            } else if (value < 13.2) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        } else {
                            if (value > 15.5) {
                                interpretation = "HIGH";
                            } else if (value < 11.9) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        }
                    } else if (age > 10) {
                        if (sex.equalsIgnoreCase("Male")) {
                            if (value > 17) {
                                interpretation = "HIGH";
                            } else if (value < 12.7) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        } else {
                            if (value > 15) {
                                interpretation = "HIGH";
                            } else if (value < 11.9) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        }
                    } else if (age > 4) {
                        if (value > 15) {
                            interpretation = "HIGH";
                        } else if (value < 11.9) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 0) {
                        if (value > 15) {
                            interpretation = "HIGH";
                        } else if (value < 10.9) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 14.1) {
                            interpretation = "HIGH";
                        } else if (value < 11.3) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                    break;
                case "packed cell volume":
                    if (age > 17) {
                        if (sex.equalsIgnoreCase("Male")) {
                            if (value > 52) {
                                interpretation = "HIGH";
                            } else if (value < 40) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        } else {
                            if (value > 47) {
                                interpretation = "HIGH";
                            } else if (value < 35) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        }
                    } else if (age > 10) {
                        if (sex.equalsIgnoreCase("Male")) {
                            if (value > 48) {
                                interpretation = "HIGH";
                            } else if (value < 37) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        } else {
                            if (value > 44) {
                                interpretation = "HIGH";
                            } else if (value < 34) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        }
                    } else if (age > 4) {
                        if (value > 44) {
                            interpretation = "HIGH";
                        } else if (value < 35) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 0) {
                        if (value > 44) {
                            interpretation = "HIGH";
                        } else if (value < 31) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 41) {
                            interpretation = "HIGH";
                        } else if (value < 31) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                    if (value >= 55 || value <= 18) {
                        interpretation = "CRITICAL";
                    }
                    break;
                case "platelets":
                    if (value > 400) {
                        interpretation = "HIGH";
                    } else if (value < 150) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    if (value >= 1000 || value <= 10) {
                        interpretation = "CRITICAL";
                    }
                    break;
                case "red blood count":
                    if (age > 17) {
                        if (sex.equalsIgnoreCase("Male")) {
                            if (value > 6.2) {
                                interpretation = "HIGH";
                            } else if (value < 4.5) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        } else {
                            if (value > 5.2) {
                                interpretation = "HIGH";
                            } else if (value < 4) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        }
                    } else if (age > 10) {
                        if (sex.equalsIgnoreCase("Male")) {
                            if (value > 5.6) {
                                interpretation = "HIGH";
                            } else if (value < 4.3) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        } else {
                            if (value > 5.1) {
                                interpretation = "HIGH";
                            } else if (value < 3.9) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        }
                    } else if (age > 4) {
                        if (sex.equalsIgnoreCase("Male")) {
                            if (value > 5.5) {
                                interpretation = "HIGH";
                            } else if (value < 4.3) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        } else {
                            if (value > 5.2) {
                                interpretation = "HIGH";
                            } else if (value < 4.1) {
                                interpretation = "LOW";
                            } else {
                                interpretation = "NORMAL";
                            }
                        }
                    } else if (age > 0) {
                        if (value > 5.2) {
                            interpretation = "HIGH";
                        } else if (value < 3.8) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 5.5) {
                            interpretation = "HIGH";
                        } else if (value < 3.9) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                    break;
                case "red blood cell distribution width":
                    if (value > 14.5) {
                        interpretation = "HIGH";
                    } else if (value < 9) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "mean corpuscular volume":
                    if (age > 17) {
                        if (value > 99) {
                            interpretation = "HIGH";
                        } else if (value < 82) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 11) {
                        if (value > 95) {
                            interpretation = "HIGH";
                        } else if (value < 79) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 5) {
                        if (value > 90) {
                            interpretation = "HIGH";
                        } else if (value < 77) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 0) {
                        if (value > 90) {
                            interpretation = "HIGH";
                        } else if (value < 75) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 85) {
                            interpretation = "HIGH";
                        } else if (value < 70) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                    break;
                case "mean platelet volume":
                    if (value > 12.3) {
                        interpretation = "HIGH";
                    } else if (value < 9.4) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
                case "mean corpuscular hemoglobin":
                    if (age > 10) {
                        if (value > 35) {
                            interpretation = "HIGH";
                        } else if (value < 25) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else if (age > 4) {
                        if (value > 33) {
                            interpretation = "HIGH";
                        } else if (value < 25) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    } else {
                        if (value > 31) {
                            interpretation = "HIGH";
                        } else if (value < 23) {
                            interpretation = "LOW";
                        } else {
                            interpretation = "NORMAL";
                        }
                    }
                    break;
                case "mean corpuscular hemoglobin concentration":
                    if (value > 36) {
                        interpretation = "HIGH";
                    } else if (value < 32) {
                        interpretation = "LOW";
                    } else {
                        interpretation = "NORMAL";
                    }
                    break;
            }
        }
        return interpretation;
    }
}
