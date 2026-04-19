import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GUI {
    private JFrame mainFrame;
    private JTextField patientNameField, dobField, doctorField;
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup sexGroup;
    private JCheckBox ccTest, ldhTest, cbcTest, renalTest;
    private ArrayList<JPanel> subChemistryRows = new ArrayList<>();
    private ArrayList<JTextField> valueFields = new ArrayList<>();
    private ArrayList<JTextField> unitFields = new ArrayList<>();
    private ArrayList<String> subChemistryNames = new ArrayList<>();
    private JTextField ldhValueField;
    private JTextField ldhUnitField;
    private ArrayList<JTextField> cbcValueFields = new ArrayList<>();
    private ArrayList<JTextField> cbcUnitFields = new ArrayList<>();
    private ArrayList<JTextField> rftValueFields = new ArrayList<>();
    private ArrayList<JTextField> rftUnitFields = new ArrayList<>();
    private TestReport report;

    public GUI() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Diagnostic Test Program");
        mainFrame.setSize(1240, 863);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setIconImage(new ImageIcon("media/temp.jpg").getImage());

        JPanel mainPanel = new JPanel(new CardLayout());

        JPanel orderPanel = new JPanel();
        orderPanel.setBackground(Color.RED);
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));

            JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 21));
            JLabel titleLabel = new JLabel("Test Order");
            titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
            titleLabel.setForeground(Color.WHITE);
            titlePanel.setBackground(new Color(43, 105, 194));
            titlePanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, 70));
            titlePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
            titlePanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 70));
            titlePanel.add(titleLabel);

            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

                JPanel namePanel = new JPanel();
                namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
                JLabel nameLabel = new JLabel("Name of Patient");
                nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
                namePanel.add(nameLabel);
                patientNameField = new JTextField(15);
                namePanel.add(patientNameField);

                JPanel dobPanel = new JPanel();
                dobPanel.setLayout(new BoxLayout(dobPanel, BoxLayout.Y_AXIS));
                JLabel dobLabel = new JLabel("Date of Birth (MM-DD-YYYY)");
                dobLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
                dobPanel.add(dobLabel);
                dobField = new JTextField(10);
                dobPanel.add(dobField);

                JPanel sexPanel = new JPanel();
                sexPanel.setLayout(new BoxLayout(sexPanel, BoxLayout.Y_AXIS));
                JPanel sexLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
                JLabel sexLabel = new JLabel("Sex");
                sexLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
                sexLabelPanel.add(sexLabel);
                sexPanel.add(sexLabelPanel);

                JPanel sexButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
                maleButton = new JRadioButton("Male");
                maleButton.setFocusable(false);
                maleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
                femaleButton = new JRadioButton("Female");
                femaleButton.setFocusable(false);
                femaleButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

                sexGroup = new ButtonGroup();
                sexGroup.add(maleButton);
                sexGroup.add(femaleButton);
                sexButtonsPanel.add(maleButton);
                sexButtonsPanel.add(femaleButton);
                sexPanel.add(sexButtonsPanel);

                JPanel doctorPanel = new JPanel();
                doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.Y_AXIS));
                JLabel doctorLabel = new JLabel("Reference Doctor");
                doctorLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
                doctorPanel.add(doctorLabel);
                doctorField = new JTextField(15);
                doctorPanel.add(doctorField);

            inputPanel.add(namePanel);
            inputPanel.add(Box.createHorizontalStrut(20));
            inputPanel.add(dobPanel);
            inputPanel.add(Box.createHorizontalStrut(20));
            inputPanel.add(sexPanel);
            inputPanel.add(Box.createHorizontalStrut(20));
            inputPanel.add(doctorPanel);

            JPanel inputWrapper = new JPanel(new BorderLayout());
            inputWrapper.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
            inputWrapper.setMinimumSize(new Dimension(Integer.MAX_VALUE, 50));
            inputWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            inputWrapper.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));
            inputWrapper.add(inputPanel, BorderLayout.CENTER);

            JPanel testLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
            JLabel testLabel = new JLabel("Test Selection");
            testLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
            testLabelPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, 40));
            testLabelPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            testLabelPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
            testLabelPanel.add(testLabel);

            JPanel testSelectionPanel = new JPanel();
            testSelectionPanel.setLayout(new BoxLayout(testSelectionPanel, BoxLayout.Y_AXIS));
            testSelectionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            testSelectionPanel.setBackground(Color.WHITE);

                ccTest = new JCheckBox("Clinical Chemistry Test");
                ccTest.setBackground(new Color(214, 214, 214));
                ccTest.setFocusable(false);
                ccTest.setFont(new Font("Tahoma", Font.PLAIN, 16));
                ccTest.setIconTextGap(10);
                
                ldhTest = new JCheckBox("Lactate Dehydrogenase Test");
                ldhTest.setBackground(new Color(214, 214, 214));
                ldhTest.setFocusable(false);
                ldhTest.setFont(new Font("Tahoma", Font.PLAIN, 16));
                ldhTest.setIconTextGap(10);

                cbcTest = new JCheckBox("Complete Blood Count");
                cbcTest.setBackground(new Color(214, 214, 214));
                cbcTest.setFocusable(false);
                cbcTest.setFont(new Font("Tahoma", Font.PLAIN, 16));
                cbcTest.setIconTextGap(10);

                renalTest = new JCheckBox("Renal Function Test");
                renalTest.setBackground(new Color(214, 214, 214));
                renalTest.setFocusable(false);
                renalTest.setFont(new Font("Tahoma", Font.PLAIN, 16));
                renalTest.setIconTextGap(10);

                JPanel subChemistryPanel = new JPanel();
                subChemistryPanel.setLayout(new BoxLayout(subChemistryPanel, BoxLayout.Y_AXIS));
                subChemistryPanel.setBackground(Color.WHITE);
                String[] subTests = {
                    "Fasting Blood Sugar", "Random Blood Sugar", "Total Cholesterol",
                    "High-Density Lipoprotein", "Low-Density Lipoprotein", "Triglycerides",
                    "Creatinine", "Uric Acid", "Blood Urea Nitrogen",
                    "Serum Glutamic-Oxaloacetic Transaminase", "Serum Glutamic-Pyruvic Transaminase",
                    "Sodium", "Potassium", "Chloride", "Total Calcium", "Ionized Calcium"
                };

                for (String test : subTests) {
                    JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));
                    row.setBackground(new Color(252,252,252));
                    row.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(225, 225, 225)));

                    JLabel analyteLabel = new JLabel(test);
                    analyteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    analyteLabel.setPreferredSize(new Dimension(350, 40));

                    JLabel abbrevLabel = new JLabel("Abbreviation: " + CC.getAbbreviation(test));
                    abbrevLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    abbrevLabel.setPreferredSize(new Dimension(300, 30));

                    JLabel valueLabel = new JLabel("Value:");
                    valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

                    JLabel unitLabel = new JLabel("Unit:");
                    unitLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

                    JTextField valueField = new JTextField(8);
                    JTextField unitField = new JTextField(6);

                    row.add(analyteLabel);
                    row.add(abbrevLabel);
                    row.add(valueLabel);
                    row.add(valueField);
                    row.add(unitLabel);
                    row.add(unitField);

                    subChemistryPanel.add(row);

                    subChemistryRows.add(row);
                    valueFields.add(valueField);
                    unitFields.add(unitField);
                    subChemistryNames.add(test);
                }
                subChemistryPanel.setVisible(false);

                JPanel subLDHPanel = new JPanel();
                subLDHPanel.setLayout(new BoxLayout(subLDHPanel, BoxLayout.Y_AXIS));
                subLDHPanel.setBackground(Color.WHITE);
                JPanel ldhRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));
                ldhRow.setBackground(new Color(252,252,252));
                ldhRow.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(225, 225, 225)));

                JLabel ldhAnalyte = new JLabel("Lactate Dehydrogenase");
                ldhAnalyte.setFont(new Font("Tahoma", Font.PLAIN, 14));
                ldhAnalyte.setPreferredSize(new Dimension(350, 40));

                JLabel ldhAbbrev = new JLabel("LDH");
                ldhAbbrev.setFont(new Font("Tahoma", Font.PLAIN, 14));
                ldhAbbrev.setPreferredSize(new Dimension(300, 30));

                JLabel ldhValue = new JLabel("Value:");
                ldhValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
                ldhValueField = new JTextField(8);

                JLabel ldhUnit = new JLabel("Unit:");
                ldhUnit.setFont(new Font("Tahoma", Font.PLAIN, 14));
                ldhUnitField = new JTextField(6);

                ldhRow.add(ldhAnalyte);
                ldhRow.add(ldhAbbrev);
                ldhRow.add(ldhValue);
                ldhRow.add(ldhValueField);
                ldhRow.add(ldhUnit);
                ldhRow.add(ldhUnitField);

                subLDHPanel.add(ldhRow);
                subLDHPanel.setVisible(false);

                JPanel subCBCPanel = new JPanel();
                subCBCPanel.setLayout(new BoxLayout(subCBCPanel, BoxLayout.Y_AXIS));
                subCBCPanel.setBackground(Color.WHITE);

                CBC tempCBC = new CBC();

                for (Analyte analyte : tempCBC.getAnalyteList()) {
                    JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));
                    row.setBackground(new Color(252,252,252));
                    row.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(225,225,225)));

                    JLabel analyteLabel = new JLabel(analyte.getName());
                    analyteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    analyteLabel.setPreferredSize(new Dimension(350, 30));

                    JLabel abbrevLabel = new JLabel("Abbreviation: " + analyte.getAbbrev());
                    abbrevLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    abbrevLabel.setPreferredSize(new Dimension(300, 30));

                    JLabel valueLabel = new JLabel("Value:");
                    valueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    JTextField valueField = new JTextField(8);

                    JLabel unitLabel = new JLabel("Unit:");
                    unitLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    JTextField unitField = new JTextField(6);

                    row.add(analyteLabel);
                    row.add(abbrevLabel);
                    row.add(valueLabel);
                    row.add(valueField);
                    row.add(unitLabel);
                    row.add(unitField);

                    subCBCPanel.add(row);

                    cbcValueFields.add(valueField);
                    cbcUnitFields.add(unitField);
                }
                subCBCPanel.setVisible(false);

                JPanel subRFTPanel = new JPanel();
                subRFTPanel.setLayout(new BoxLayout(subRFTPanel, BoxLayout.Y_AXIS));
                subRFTPanel.setBackground(Color.WHITE);

                RFT tempRFT = new RFT();

                for (Analyte analyte : tempRFT.getAnalyteList()) {
                    JPanel rftRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));
                    rftRow.setBackground(new Color(252,252,252));
                    rftRow.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(225,225,225)));

                    JLabel rftAnalyte = new JLabel(analyte.getName());
                    rftAnalyte.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    rftAnalyte.setPreferredSize(new Dimension(350, 30));

                    JLabel rftAbbrev = new JLabel("Abbreviation: " + analyte.getAbbrev());
                    rftAbbrev.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    rftAbbrev.setPreferredSize(new Dimension(300, 30));

                    JLabel rftValue = new JLabel("Value:");
                    rftValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    JTextField rftValueField = new JTextField(8);

                    JLabel rftUnit = new JLabel("Unit:");
                    rftUnit.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    JTextField rftUnitField = new JTextField(6);

                    rftRow.add(rftAnalyte);
                    rftRow.add(rftAbbrev);
                    rftRow.add(rftValue);
                    rftRow.add(rftValueField);
                    rftRow.add(rftUnit);
                    rftRow.add(rftUnitField);

                    subRFTPanel.add(rftRow);

                    rftValueFields.add(rftValueField);
                    rftUnitFields.add(rftUnitField);
                }
                subRFTPanel.setVisible(false);
                
            testSelectionPanel.add(createTestPanel(ccTest, new Color(214, 214, 214)));   
            testSelectionPanel.add(subChemistryPanel);
            testSelectionPanel.add(createTestPanel(ldhTest, new Color(214, 214, 214)));
            testSelectionPanel.add(subLDHPanel);
            testSelectionPanel.add(createTestPanel(cbcTest, new Color(214, 214, 214)));
            testSelectionPanel.add(subCBCPanel);
            testSelectionPanel.add(createTestPanel(renalTest, new Color(214, 214, 214)));
            testSelectionPanel.add(subRFTPanel);

            ccTest.addActionListener(e -> {
                subChemistryPanel.setVisible(ccTest.isSelected());
                if (!ccTest.isSelected()) {
                    for (JTextField vf : valueFields) vf.setText("");
                    for (JTextField uf : unitFields) uf.setText("");
                }
                testSelectionPanel.revalidate();
                testSelectionPanel.repaint();
            });
            ldhTest.addActionListener(e -> {
                subLDHPanel.setVisible(ldhTest.isSelected());
                if (!ldhTest.isSelected()) {
                    ldhValueField.setText("");
                    ldhUnitField.setText("");
                }
                testSelectionPanel.revalidate();
                testSelectionPanel.repaint();
            });
            cbcTest.addActionListener(e -> {
                subCBCPanel.setVisible(cbcTest.isSelected());
                if (!cbcTest.isSelected()) {
                    for (JTextField vf : cbcValueFields) vf.setText("");
                    for (JTextField uf : cbcUnitFields) uf.setText("");
                }
                testSelectionPanel.revalidate();
                testSelectionPanel.repaint();
            });
            renalTest.addActionListener(e -> {
                subRFTPanel.setVisible(renalTest.isSelected());
                if (!renalTest.isSelected()) {
                    for (JTextField vf : rftValueFields) vf.setText("");
                    for (JTextField uf : rftUnitFields) uf.setText("");
                }
                testSelectionPanel.revalidate();
                testSelectionPanel.repaint();
            });

            JScrollPane testScrollPane = new JScrollPane(testSelectionPanel);
            testScrollPane.setPreferredSize(new Dimension(600, 300));
            testScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
            JButton submitButton = new JButton("Submit");
            submitButton.setBackground(Color.LIGHT_GRAY);
            submitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
            submitButton.setFocusable(false);
            submitPanel.add(submitButton);

            submitButton.addActionListener(e -> {
                String name = patientNameField.getText();
                String sex = maleButton.isSelected() ? "Male" : "Female";
                LocalDate dob = LocalDate.parse(dobField.getText(), java.time.format.DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                Patient patient = new Patient(name, sex, dob);

                String refDoctor = doctorField.getText();

                ArrayList<Test> selectedTests = new ArrayList<>();
                if (ccTest.isSelected()) {
                    CC cc = new CC();
                    for (int i = 0; i < subChemistryNames.size(); i++) {
                        String valText = valueFields.get(i).getText().trim();
                        if (!valText.isEmpty()) {
                            try {
                                double val = Double.parseDouble(valText);
                                Analyte analyte = new Analyte(subChemistryNames.get(i), CC.getAbbreviation(subChemistryNames.get(i)),CC.getPrice(subChemistryNames.get(i)));
                                analyte.setValue(val);
                                analyte.setUnit(unitFields.get(i).getText().trim());
                                cc.getAnalyteList().add(analyte);
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                    selectedTests.add(cc);
                }
                if (ldhTest.isSelected()) {
                    LDH ldh = new LDH();
                    for (Analyte analyte : ldh.getAnalyteList()) {
                        if (analyte.getName().equalsIgnoreCase("Lactate Dehydrogenase")) {
                            String valText = ldhValueField.getText().trim();
                            if (!valText.isEmpty()) {
                                try {
                                    double val = Double.parseDouble(valText);
                                    analyte.setValue(val);
                                    analyte.setUnit(ldhUnitField.getText().trim());
                                } catch (NumberFormatException ex) {
                                }
                            }
                        }
                    }
                    selectedTests.add(ldh);
                }
                if (cbcTest.isSelected()) {
                    CBC cbc = new CBC();

                    for (int i = 0; i < cbc.getAnalyteList().size(); i++) {
                        String valText = cbcValueFields.get(i).getText().trim();
                        if (!valText.isEmpty()) {
                            try {
                                double val = Double.parseDouble(valText);
                                Analyte analyte = cbc.getAnalyteList().get(i);
                                analyte.setValue(val);
                                analyte.setUnit(cbcUnitFields.get(i).getText().trim());
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                    selectedTests.add(cbc);
                }
                if (renalTest.isSelected()) {
                    RFT rft = new RFT();

                    for (int i = 0; i < rft.getAnalyteList().size(); i++) {
                        String valText = rftValueFields.get(i).getText().trim();
                        if (!valText.isEmpty()) {
                            try {
                                double val = Double.parseDouble(valText);
                                Analyte analyte = rft.getAnalyteList().get(i);
                                analyte.setValue(val);
                                analyte.setUnit(rftUnitFields.get(i).getText().trim());
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                    selectedTests.add(rft);

                }

                report = new TestReport(patient, selectedTests, refDoctor);

                StringBuilder sb = new StringBuilder();
                sb.append("Patient ID: ").append(report.getPatient().getPatientID()).append("\n");
                sb.append("Name: ").append(report.getPatient().getPatientName()).append("\n");
                sb.append("Sex: ").append(report.getPatient().getPatientSex()).append("\n");
                sb.append("Age: ").append(report.getPatient().getPatientAge()).append("\n");
                sb.append("Reference Doctor: ").append(report.getReferenceDoc()).append("\n");
                sb.append("Report Date: ").append(report.getReportDate()).append("\n\n");

                for (Test test : report.getTests()) {
                    sb.append(test.getTestName()).append("\n");
                    for (Analyte analyte : test.getAnalyteList()) {
                        sb.append("  ").append(analyte.getName())
                        .append(" (").append(analyte.getAbbrev()).append("): ")
                        .append(analyte.getValue()).append(" ").append(analyte.getUnit());

                        Test tempTest = null;
                        if (test instanceof CC) {
                            tempTest = new CC();
                        } else if (test instanceof CBC) {
                            tempTest = new CBC();
                        } else if (test instanceof LDH) {
                            tempTest = new LDH();
                        } else if (test instanceof RFT) {
                            tempTest = new RFT();
                        }

                        if (tempTest != null) {
                            tempTest.getAnalyteList().clear();
                            tempTest.getAnalyteList().add(analyte);

                            String interp = tempTest.interpret(
                                report.getPatient().getPatientSex(),
                                report.getPatient().getPatientAge()
                            );

                            if (!interp.isEmpty()) {
                                sb.append(" - ").append(interp);
                            }
                        }

                        sb.append("\n");
                    }
                    sb.append("\n");
                }

                JOptionPane.showMessageDialog(mainFrame, sb.toString(), "Test Report", JOptionPane.INFORMATION_MESSAGE);

                patientNameField.setText("");
                dobField.setText("");
                doctorField.setText("");
                sexGroup.clearSelection();

                ccTest.setSelected(false);
                ldhTest.setSelected(false);
                cbcTest.setSelected(false);
                renalTest.setSelected(false);

                subChemistryPanel.setVisible(false);
                subLDHPanel.setVisible(false);
                subCBCPanel.setVisible(false);
                subRFTPanel.setVisible(false);
            });

        orderPanel.add(createLogoPanel());
        orderPanel.add(titlePanel);
        orderPanel.add(createSpacePanel());
        orderPanel.add(inputWrapper);
        orderPanel.add(createSpacePanel());
        orderPanel.add(testLabelPanel);
        orderPanel.add(testScrollPane);
        orderPanel.add(submitPanel);

        mainPanel.add(orderPanel, "New Order");
        mainFrame.add(mainPanel, BorderLayout.CENTER);
    }

    public void show() {
        mainFrame.setVisible(true);
    }

    private JPanel createLogoPanel() {
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        ImageIcon logo = new ImageIcon(new ImageIcon("media/logo.png").getImage().getScaledInstance(960, 120, Image.SCALE_SMOOTH));
        JLabel logoLabel = new JLabel(logo);
        logoPanel.setBackground(Color.WHITE);
        logoPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, 150));
        logoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        logoPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 150));
        logoPanel.add(logoLabel);

        return logoPanel;
    }

    private JPanel createSpacePanel() {
        JPanel spacePanel = new JPanel();
        spacePanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, 20));
        spacePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
        spacePanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));

        return spacePanel;
    }
    private JPanel createTestPanel(JCheckBox checkbox, Color bgcolor) {
        JPanel testPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        testPanel.setBackground(bgcolor);
        testPanel.add(checkbox);

        Border lineBorder = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(190, 190, 190));
        Border paddingBorder = BorderFactory.createEmptyBorder(5, 6, 5, 10);
        testPanel.setBorder(BorderFactory.createCompoundBorder(lineBorder, paddingBorder));

        testPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        testPanel.setPreferredSize(new Dimension(600, 50));
        return testPanel;
    }
}
