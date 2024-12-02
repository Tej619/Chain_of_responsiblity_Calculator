package com.lengthConverter.cor.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.lengthConverter.cor.handler.FootHandler;
import com.lengthConverter.cor.handler.Handler;
import com.lengthConverter.cor.handler.MileHandler;
import com.lengthConverter.cor.handler.YardHandler;
import com.lengthConverter.cor.model.ConversionModel;

public class LengthConverterGUI {
	private JFrame frame;
	private JTextField inputField;
	private JComboBox<String> unitSelector;
	private JLabel resultLabel;
	private Handler chain;

	public LengthConverterGUI() {
		chain = initializeHandlers();

		frame = new JFrame("Length Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 200);
//        frame.setLayout(new GridLayout(4, 1, 10, 10));
		frame.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; // Column index
        gbc.gridy = 0; // Row index
        
		JLabel inputLabel = new JLabel(" Enter distance in kilometers:");
//		inputField = new JTextField();
		frame.add(inputLabel, gbc);
		gbc.gridx = 1;
        inputField = new JTextField(15);
        frame.add(inputField, gbc);

//		JLabel unitLabel = new JLabel(" Select target unit:");
//		String[] units = { "mile", "yard", "foot" };
//		unitSelector = new JComboBox<>(units);
//
//		JButton convertButton = new JButton("Convert");
//		convertButton.addActionListener(new ConvertButtonListener());
//
//		resultLabel = new JLabel("Result will be displayed here.");
//		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//		frame.add(inputLabel);
//		frame.add(inputField);
//		frame.add(unitLabel);
//		frame.add(unitSelector);
//		frame.add(convertButton);
//		frame.add(resultLabel);
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel unitLabel = new JLabel("Select target unit:");
        frame.add(unitLabel, gbc);
        gbc.gridx = 1;
        String[] units = {"mile", "yard", "foot"};
        unitSelector = new JComboBox<>(units);
        frame.add(unitSelector, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Spanning two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center alignment
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertButtonListener());
        frame.add(convertButton, gbc);

        gbc.gridy = 3;
        resultLabel = new JLabel("Result will be displayed here.");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(resultLabel, gbc);

		frame.setVisible(true);
	}

	private Handler initializeHandlers() {
		Handler mileHandler = new MileHandler();
		Handler yardHandler = new YardHandler();
		Handler footHandler = new FootHandler();

		mileHandler.setSuccessor(yardHandler);
		yardHandler.setSuccessor(footHandler);

		return mileHandler;
	}

	private class ConvertButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				double kilometers = Double.parseDouble(inputField.getText());
				String targetUnit = unitSelector.getSelectedItem().toString();

				ConversionModel request = new ConversionModel(kilometers, targetUnit);
				String result = chain.handleRequest(request);
				resultLabel.setText(result);
			} catch (NumberFormatException ex) {
				resultLabel.setText("Please enter a valid number.");
			}
		}
	}
}
