package taxigui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.*;

import taxigui.FilterPanel.TaxiRideFilter;
import taxigui.FilterPanel;
import taxigui.GenericTablePanel;
import taxigui.TaxiRideRecord;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class TableFrame extends JFrame {

	private GenericTablePanel tablePanel;
	private JTextField loadField;
	private JTextArea logArea;
	private JFrame filterFrame;
	private FilterPanel filterPanel;
	private JButton loadButton, applyFilterButton;
	private int sum;

	public TableFrame() {
		// Creates the toolbar
		JToolBar toolbar = new JToolBar();
		super.add(toolbar, BorderLayout.NORTH);

		JButton exitButton = new JButton("Exit");
		toolbar.add(exitButton);
		exitButton.addActionListener(actionEvent -> System.exit(0));

		loadField = new JTextField(30);
		toolbar.add(loadField);
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));

		loadButton = new JButton("Load file");
		loadButton.addActionListener(e -> {

			logArea.append("Loading records from \"" + loadField.getText() + "\"\n");
			loadButton.setEnabled(false);
			applyFilterButton.setEnabled(false);

			SwingWorker<List<TaxiRideRecord>, Void> worker = new SwingWorker<>() {

				Stream<String> lines;

				@Override
				protected List<TaxiRideRecord> doInBackground() throws Exception {

					lines = Files.lines(Paths.get(loadField.getText()));
					// reset the counter when loading
					TaxiRideRecord.resetCounter();
					List<TaxiRideRecord> records = lines.map(line -> new TaxiRideRecord(line))
							.collect(Collectors.toList());
					return records;
				}

				protected void done() {

					try {
						tablePanel.update(this.get());
						logArea.append("Loaded " + this.get().size() + " records\n");

						loadButton.setEnabled(true);
						applyFilterButton.setEnabled(true);
					} catch (Exception e) {
					}

				};
			};

			worker.execute();

		});
		toolbar.add(loadButton);
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton defineFilterButton = new JButton("Define Filter");
		defineFilterButton.addActionListener(e -> {
			if (filterFrame.isVisible()) {
				filterFrame.setVisible(false);
			} else {
				filterFrame.setVisible(true);
			}
		});
		toolbar.add(defineFilterButton);

		applyFilterButton = new JButton("Apply Filter");
		applyFilterButton.addActionListener(e -> {

			loadButton.setEnabled(false);
			applyFilterButton.setEnabled(false);

			TaxiRideFilter filter = null;
			try {
				filter = filterPanel.getFilter();
			} catch (ParseException e1) {

			}
			if (filter.toLeave() || filter.toSkip() || filter.toFilterByPaymentType() || filter.toLimitDistance()) {
				logArea.append("Applying defined filter\n");
			}

			List<TaxiRideRecord> records = tablePanel.getRecords();

			TaxiRideFilter finalFilter = filter;
			SwingWorker<List<TaxiRideRecord>, Void> worker = new SwingWorker<>() {

				Stream<TaxiRideRecord> stream = records.stream();

				@Override
				protected List<TaxiRideRecord> doInBackground() throws Exception {

					if (finalFilter.toSkip()) {
						stream = stream.skip(finalFilter.getNumberToSkip());
					}

					if (finalFilter.toLeave()) {
						stream = stream.limit(finalFilter.getNumberToLeave());
					}

					if (finalFilter.toFilterByPaymentType()) {
						stream = stream.filter(record -> record.getPaymentType().equals(finalFilter.getPaymentType()));
					}

					if (finalFilter.toFilterByPickupDatetime()) {
						stream = stream.filter(record -> record.getPickup().compareTo(finalFilter.getPickupDateTime()) == 0);
						sum = stream.mapToInt(value -> value.getDuration()).sum();

					}

					List<TaxiRideRecord> filteredRecords = stream.collect(Collectors.toList());
					return filteredRecords;
				}

				protected void done() {

					if (finalFilter.toSkip()) {
						logArea.append("Skipping first " + finalFilter.getNumberToSkip() + " records\n");
					}

					if (finalFilter.toLeave()) {
						logArea.append("Leaving first " + finalFilter.getNumberToLeave() + " records\n");
					}

					if (finalFilter.toFilterByPaymentType()) {
						logArea.append("Keeping records with " + finalFilter.getPaymentType() + " payment type\n");
					}

					if(finalFilter.toFilterByPickupDatetime()) {
						logArea.append(("Keeping record on pickup time of " + finalFilter.getPickupDateTime()) + "\n");
						logArea.append("Total miles: " + getSum() + "\n");
					}

					try {
						tablePanel.update(this.get());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}

					loadButton.setEnabled(true);
					applyFilterButton.setEnabled(true);

				};
			};
			worker.execute();
		});
		toolbar.add(applyFilterButton);

		JButton addButton = new JButton("Add entry");
		JFrame addDialog = new AddDialog(tablePanel);
		addButton.addActionListener(e -> addDialog.setVisible(true));
		toolbar.add(addButton);


		// add the empty table
		tablePanel = new GenericTablePanel<>(TaxiRideRecord.class);
		tablePanel.setPreferredSize(new Dimension(1920, 700));
		super.add(tablePanel, BorderLayout.CENTER);

		// creates the log panel
		ScrollPane logPane = new ScrollPane();
		logArea = new JTextArea();
		logPane.add(logArea);
		super.add(logPane, BorderLayout.SOUTH);

		// filter frame
		filterFrame = new JFrame();
		filterFrame.setBounds(100, 100, 600, 500);
		filterFrame.add(filterPanel = new FilterPanel());
		filterFrame.pack();
	}

	public int getSum() {
		return sum;
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> {
			TableFrame window = new TableFrame();
			window.setLocation(20, 20);
			window.setVisible(true);
			window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			window.setTitle("Taxi Record Viewer");
			window.pack();
		});
	}
}
