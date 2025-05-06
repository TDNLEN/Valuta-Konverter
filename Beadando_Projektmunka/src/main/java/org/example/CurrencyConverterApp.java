package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface CurrencyConverter {
    double convert(double hufAmount);
}

public class CurrencyConverterApp {
    private JFrame frame;
    private JTextField amountField;
    private JComboBox<String> currencyBox;
    private JLabel resultLabel;

    public CurrencyConverterApp() {
        frame = new JFrame("Valuta Konverter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        amountField = new JTextField();
        panel.add(new JLabel("Add meg az összeget (HUF):"));
        panel.add(amountField);

        currencyBox = new JComboBox<>(new String[]{"EUR", "USD", "GBP"});
        panel.add(new JLabel("Válassz valutát:"));
        panel.add(currencyBox);

        JButton convertButton = new JButton("Konvertál");
        resultLabel = new JLabel("Eredmény: ");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        panel.add(convertButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String currency = (String) currencyBox.getSelectedItem();

            CurrencyConverter converter = KonverterGyar.getConverter(currency);
            double result = converter.convert(amount);

            resultLabel.setText(String.format("Eredmény: %.2f %s", result, currency));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Hibás összeg!", "Hiba", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverterApp());
    }
}
