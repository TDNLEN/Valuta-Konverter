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
    private JLabel ratesLabel;

    public CurrencyConverterApp() {
        frame = new JFrame("Valuta Konverter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Valuta Konverter", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(titleLabel);

        amountField = new JTextField();
        panel.add(new JLabel("Add meg az összeget (HUF):"));
        panel.add(amountField);

        currencyBox = new JComboBox<>(new String[]{"EUR", "USD", "GBP", "TRL"});
        panel.add(new JLabel("Válassz valutát:"));
        panel.add(currencyBox);

        JButton convertButton = new JButton("Konvertál");
        JButton refreshButton = new JButton("Frissítés");

        resultLabel = new JLabel("Eredmény: ");
        ratesLabel = new JLabel("Árfolyamok: betöltés...");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        refreshButton.addActionListener(e -> refreshRates());

        panel.add(convertButton);
        panel.add(refreshButton);
        panel.add(resultLabel);
        panel.add(ratesLabel);

        frame.add(panel);
        frame.setVisible(true);

        refreshRates();
    }

    public class ExchangeRateFetcherProxy {
        private boolean hasFetched = false;

        public void fetchAndUpdateRates() {
            if (!hasFetched) {
                ExchangeRateFetcher.fetchAndUpdateRates();
                hasFetched = true;
            } else {
                System.out.println("Cache-ből szolgáltatott árfolyam.");
            }
        }
    }

    private final ExchangeRateFetcherProxy fetcherProxy = new ExchangeRateFetcherProxy();

    private void refreshRates() {
        try {
            fetcherProxy.fetchAndUpdateRates();
            ratesLabel.setText(String.format("EUR: %.2f | USD: %.2f | GBP: %.2f",
                    ValtoRataSzerviz.getInstance().getEuroRate(),
                    ValtoRataSzerviz.getInstance().getUsdRate(),
                    ValtoRataSzerviz.getInstance().getGbpRate()));
        } catch (Exception e) {
            ratesLabel.setText("Hiba az árfolyam frissítésben!");
        }
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
        SwingUtilities.invokeLater(CurrencyConverterApp::new);
    }
}