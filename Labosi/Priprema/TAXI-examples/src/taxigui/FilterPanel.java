package taxigui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import taxigui.TableFrame;

/**
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class FilterPanel extends JPanel {

    private static final String[] DISTANCE_CONDITIONS = {"<", ">="};

    private JCheckBox skipCheckBox;
    private JTextField skipTextField;
    private JCheckBox leaveCheckBox;
    private JTextField leaveTextField;
    private JCheckBox paymentTypeCheckBox;
    private JRadioButton cashButton;
    private JCheckBox dateTimeCheckBox;
    private JTextField dateTimeTextField;
    private JCheckBox tripTimeCheckBox;
    private JTextField tripTimeTextField;
    private JTextField minTimeTextField;
    private JTextField maxTimeTextField;
    JRadioButton cardButton;
    JRadioButton unknownButton;
    JCheckBox distanceCheckBox;
    JComboBox<String> distanceCondition;
    JTextField distanceTextField;

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public FilterPanel() {
        super.setLayout(new SpringLayout());

        // row 0
        skipCheckBox = new JCheckBox("Skip records?");
        super.add(skipCheckBox);
        super.add(new JLabel("Number of records to skip:"));
        skipTextField = new JTextField(20);
        super.add(skipTextField);

        // row 1
        leaveCheckBox = new JCheckBox("Leave records?");
        super.add(leaveCheckBox);
        super.add(new JLabel("Number of records to leave:"));
        leaveTextField = new JTextField(20);
        super.add(leaveTextField);

        // row 2
        paymentTypeCheckBox = new JCheckBox("Filter by payment type?");
        super.add(paymentTypeCheckBox);
        super.add(new JLabel(""));
        JPanel paymentTypePanel = new JPanel();
        paymentTypePanel.setBorder(
                BorderFactory.createTitledBorder(null, "PaymentType?", TitledBorder.LEADING, TitledBorder.TOP));
        super.add(paymentTypePanel);
        paymentTypePanel.setLayout(new GridLayout(0, 1, 0, 0));
        ButtonGroup paymentTypeGroup = new ButtonGroup();
        cashButton = new JRadioButton("Cash (CHK)");
        paymentTypePanel.add(cashButton);
        paymentTypeGroup.add(cashButton);
        cardButton = new JRadioButton("Card (CRD)");
        paymentTypePanel.add(cardButton);
        paymentTypeGroup.add(cardButton);
        unknownButton = new JRadioButton("Unknown (UNK)");
        paymentTypePanel.add(unknownButton);
        paymentTypeGroup.add(unknownButton);

        // row 4
        distanceCheckBox = new JCheckBox("Limit distance?");
        super.add(distanceCheckBox);
        distanceCondition = new JComboBox(DISTANCE_CONDITIONS);
        super.add(distanceCondition);
        distanceTextField = new JTextField(20);
        super.add(distanceTextField);

        //row 5 // EXTRA //
        dateTimeCheckBox = new JCheckBox("Filter by pickup daytime?");
        super.add(dateTimeCheckBox);
        super.add(new JLabel("Pickup date:"));
        dateTimeTextField = new JTextField(20);
        super.add(dateTimeTextField);

        //row 6 // EXTRA //
        tripTimeCheckBox = new JCheckBox("Filter by trip length?");
        super.add(tripTimeCheckBox);
        super.add(new JLabel("Trip time in seconds (min/max):"));
        JPanel timePanel = new JPanel(new FlowLayout());
        minTimeTextField = new JTextField(10);
        timePanel.add(minTimeTextField);
        maxTimeTextField = new JTextField(10);
        timePanel.add(maxTimeTextField);
        //tripTimeTextField = new JTextField(20);
        super.add(timePanel);


        SpringUtilities.makeCompactGrid(this, 6, 3, 0, 0, 5, 5);
    }

    public TaxiRideFilter getFilter() throws ParseException {
        TaxiRideFilter filter = new TaxiRideFilter();

        if (skipCheckBox.isSelected()) {
            filter.toSkip(true);
            filter.setNumberToSkip(Integer.parseInt(skipTextField.getText()));
        } else {
            filter.toSkip(false);
        }

        if (leaveCheckBox.isSelected()) {
            filter.toLeave(true);
            filter.setNumberToLeave(Integer.parseInt(leaveTextField.getText()));
        } else {
            filter.toLeave(false);
        }

        if (paymentTypeCheckBox.isSelected()) {
            filter.setToFilterByPaymentType(true);
            if (cashButton.isSelected()) {
                filter.setPaymentType("CSH");
            } else if (cardButton.isSelected()) {
                filter.setPaymentType("CRD");
            } else {
                filter.setPaymentType("UNK");
            }
        } else {
            filter.setToFilterByPaymentType(false);
        }

        if (distanceCheckBox.isSelected()) {
            filter.toLimitDistance(true);
            filter.setDistanceCondition((String) distanceCondition.getSelectedItem());
            filter.setDistanceToLimit(Double.parseDouble(distanceTextField.getText()));
        } else {
            filter.toLimitDistance(false);
        }

        if (dateTimeCheckBox.isSelected()) {
            DateFormat format = DATE_FORMATTER;
            filter.toFilterByPickupDatetime(true);
            try {
                Date date = format.parse(dateTimeTextField.getText());

            } catch (ParseException ex) {
            }
            filter.setPickupDateTime(format.parse(dateTimeTextField.getText()));

        }

        return filter;
    }

    public class TaxiRideFilter {

        private boolean toSkip, toLeave, toFilterByPaymentType, toLimitDistance, toFilterByPickupDatetime, toFilterByTripTime;
        private int numberToSkip, numberToLeave;
        private double distanceToLimit;
        private String paymentType, distanceCondition;
        private Date pickupDateTime;
        private int tripTimeInSeconds;

        public boolean toSkip() {
            return toSkip;
        }

        public void toSkip(boolean toSkip) {
            this.toSkip = toSkip;
        }

        public boolean toLeave() {
            return toLeave;
        }

        public void toLeave(boolean toLeave) {
            this.toLeave = toLeave;
        }

        public boolean toFilterByPaymentType() {
            return toFilterByPaymentType;
        }

        public void setToFilterByPaymentType(boolean toFilterByPaymentType) {
            this.toFilterByPaymentType = toFilterByPaymentType;
        }

        public boolean toLimitDistance() {
            return toLimitDistance;
        }

        public void toLimitDistance(boolean toLimitDistance) {
            this.toLimitDistance = toLimitDistance;
        }

        public int getNumberToSkip() {
            return numberToSkip;
        }

        public void setNumberToSkip(int numberToSkip) {
            this.numberToSkip = numberToSkip;
        }

        public int getNumberToLeave() {
            return numberToLeave;
        }

        public void setNumberToLeave(int numberToLeave) {
            this.numberToLeave = numberToLeave;
        }

        public double getDistanceToLimit() {
            return distanceToLimit;
        }

        public void setDistanceToLimit(double distanceToLimit) {
            this.distanceToLimit = distanceToLimit;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        public String getDistanceCondition() {
            return distanceCondition;
        }

        public void setDistanceCondition(String distanceCondition) {
            this.distanceCondition = distanceCondition;
        }

        /////
        public boolean toFilterByPickupDatetime() {
            return toFilterByPickupDatetime;
        }

        public void toFilterByPickupDatetime(boolean toFilter) {
            this.toFilterByPickupDatetime = toFilter;
        }

        public boolean toFilterByTripTime() {
            return toFilterByTripTime;
        }

        public void toFilterByTripTime(boolean toFilter) {
            this.toFilterByTripTime = toFilter;
        }

        public Date getPickupDateTime() {
            return pickupDateTime;
        }

        public void setPickupDateTime(Date pickupDateTime) {
            this.pickupDateTime = pickupDateTime;
        }

        public int getTripTimeInSeconds() {
            return tripTimeInSeconds;
        }

        public void setTripTimeInSeconds(int tripTimeInSeconds) {
            this.tripTimeInSeconds = tripTimeInSeconds;
        }
    }
}
