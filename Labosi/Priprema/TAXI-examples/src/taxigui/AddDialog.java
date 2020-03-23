package taxigui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AddDialog extends JFrame {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    GenericTablePanel<TaxiRideRecord> tablePanel;
    private JPanel panel1;
    private JPanel panel2;
    private JTextField tfMedallion;
    private JTextField tfHackLicense;
    private JTextField tfPickupDateTime;
    private JTextField tfDropoffDateTime;
    private JTextField tfTripTime;
    private JTextField tfTripDistance;
    private JTextField tfPickupLongitude;
    private JTextField tfPickupLatitude;
    private JTextField tfDropoffLatitude;
    private JTextField tfDropoffLongitude;
    private JTextField tfPaymentType;
    private JTextField tfFareAmount;
    private JTextField tfSurcharge;
    private JTextField tfTax;
    private JTextField tfTip;
    private JTextField tfTolls;
    private JTextField tfTotal;
    private JLabel lbMedallion;
    private JLabel lbHackLicense;
    private JLabel lbPickupDateTime;
    private JLabel lbDropoffDateTime;
    private JLabel lbTripTime;
    private JLabel lbTripDistance;
    private JLabel lbPickupLongitude;
    private JLabel lbPickupLatitude;
    private JLabel lbDropoffLongitude;
    private JLabel lbDropoffLatitude;
    private JLabel lbPaymentType;
    private JLabel lbFareAmount;
    private JLabel lbSurcharge;
    private JLabel lbTax;
    private JLabel lbTip;
    private JLabel lbTolls;
    private JLabel lbTotal;
    private JButton input;
    private JButton drop;

    public AddDialog(GenericTablePanel<TaxiRideRecord> tablePanel) {

        this.tablePanel = tablePanel;
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.panel1 = new JPanel(new SpringLayout());
        this.panel2 = new JPanel(new FlowLayout());

        this.tfMedallion = new JTextField(10);
        this.tfHackLicense = new JTextField(10);
        this.tfPickupDateTime = new JTextField(10);
        this.tfDropoffDateTime = new JTextField(10);
        this.tfTripTime = new JTextField(10);
        this.tfTripDistance = new JTextField(10);
        this.tfPickupLongitude = new JTextField(10);
        this.tfPickupLatitude = new JTextField(10);
        this.tfDropoffLatitude = new JTextField(10);
        this.tfDropoffLongitude = new JTextField(10);
        this.tfPaymentType = new JTextField(10);
        this.tfFareAmount = new JTextField(10);
        this.tfSurcharge = new JTextField(10);
        this.tfTax = new JTextField(10);
        this.tfTip = new JTextField(10);
        this.tfTolls = new JTextField(10);
        this.tfTotal = new JTextField(10);
        this.lbMedallion = new JLabel("Medallion");
        this.lbHackLicense = new JLabel("HackLicense");
        this.lbPickupDateTime = new JLabel("Pickup datetime");
        this.lbDropoffDateTime = new JLabel("Dropoff datetime");
        this.lbTripTime = new JLabel("Trip time");
        this.lbTripDistance = new JLabel("Trip distance");
        this.lbPickupLongitude = new JLabel("Pickup longitude");
        this.lbPickupLatitude = new JLabel("Pickup latitude");
        this.lbDropoffLongitude = new JLabel("Dropoff longitude");
        this.lbDropoffLatitude = new JLabel("Dropoff latitude");
        this.lbPaymentType = new JLabel("Payment Type");
        this.lbFareAmount = new JLabel("Fare Amount");
        this.lbSurcharge = new JLabel("Surcharge");
        this.lbTax = new JLabel("Tax");
        this.lbTip = new JLabel("Tip");
        this.lbTolls = new JLabel("Tolls");
        this.lbTotal = new JLabel("Total");
        this.input = new JButton("Input");
        this.drop = new JButton("Drop");

        panel1.add(lbMedallion);
        panel1.add(tfMedallion);
        panel1.add(lbTripDistance);
        panel1.add(tfTripDistance);
        panel1.add(lbPaymentType);
        panel1.add(tfPaymentType);
        panel1.add(lbTolls);
        panel1.add(tfTolls);
        panel1.add(lbHackLicense);
        panel1.add(tfHackLicense);
        panel1.add(lbPickupLongitude);
        panel1.add(tfPickupLongitude);
        panel1.add(lbFareAmount);
        panel1.add(tfFareAmount);
        panel1.add(lbTotal);
        panel1.add(tfTotal);
        panel1.add(lbPickupDateTime);
        panel1.add(tfPickupDateTime);
        panel1.add(lbPickupLatitude);
        panel1.add(tfPickupLatitude);
        panel1.add(lbSurcharge);
        panel1.add(tfSurcharge);
        panel1.add(new JLabel());
        panel1.add(new JLabel());
        panel1.add(lbDropoffDateTime);
        panel1.add(tfDropoffDateTime);
        panel1.add(lbDropoffLongitude);
        panel1.add(tfDropoffLongitude);
        panel1.add(lbTax);
        panel1.add(tfTax);
        panel1.add(new JLabel());
        panel1.add(new JLabel());
        panel1.add(lbTripTime);
        panel1.add(tfTripTime);
        panel1.add(lbDropoffLatitude);
        panel1.add(tfDropoffLatitude);
        panel1.add(lbTip);
        panel1.add(tfTip);
        panel1.add(new JLabel());
        panel1.add(new JLabel());
        SpringUtilities.makeCompactGrid(panel1, 5, 8, 5, 5, 5, 5);

        panel2.add(input, FlowLayout.LEFT);
        panel2.add(drop, FlowLayout.LEFT);

        input.addActionListener(a -> {
            tablePanel.update(addData());
            tablePanel.getParent().revalidate();
        });

        drop.addActionListener(a -> this.dispose());

        this.add(panel1, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.SOUTH);
        this.pack();


    }

    private List<TaxiRideRecord> addData() {

        if (tfMedallion.getText() == null || tfHackLicense.getText() == null || tfPickupDateTime.getText() == null ||
                tfDropoffDateTime.getText() == null || tfPickupLatitude.getText() == null || tfDropoffLongitude.getText() == null ||
                tfTripTime.getText() == null || tfTripDistance.getText() == null || tfPickupLongitude.getText() == null ||
                tfDropoffLatitude.getText() == null || tfPaymentType.getText() == null || tfFareAmount.getText() == null ||
                tfSurcharge.getText() == null || tfTax.getText() == null || tfTip.getText() == null || tfTolls.getText() == null ||
                tfTotal.getText() == null) {
            throw new IllegalArgumentException("Ni jedno polje ne smije biti NULL");
        }


        DateFormat format = DATE_FORMATTER;


        try {
            tablePanel.getRecords().add(new TaxiRideRecord(tfMedallion.getText(), tfHackLicense.getText(),
                    format.parse(tfPickupDateTime.getText()), format.parse(tfDropoffDateTime.getText()), Integer.parseInt(tfTripTime.getText()),
                    Double.parseDouble(tfTripDistance.getText()), Double.parseDouble(tfPickupLongitude.getText()), Double.parseDouble(tfPickupLatitude.getText()),
                    Double.parseDouble(tfDropoffLongitude.getText()), Double.parseDouble(tfDropoffLatitude.getText()), tfPaymentType.getText(),
                    Double.parseDouble(tfFareAmount.getText()), Double.parseDouble(tfSurcharge.getText()), Double.parseDouble(tfTax.getText()),
                    Double.parseDouble(tfTip.getText()), Double.parseDouble(tfTolls.getText()), Double.parseDouble(tfTotal.getText()),
                    tablePanel.getRecords().size()));
        } catch (ParseException e) {
            System.err.println("Wrong date format! Must be (yyyy-MM-dd hh:mm:ss)");
        }

        return tablePanel.getRecords();
    }
}