import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter extends JFrame {
    private JComboBox<String> fromCurrency, toCurrency;
    private JTextField amountField, resultField;
    private JLabel fromFlag, toFlag, bgImageLabel;
    private ImageIcon fromIcon, toIcon;

    private static final String API_KEY = "APIKEY"; //Give your own api-key in place of "APIKEY"
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String[] CURRENCIES = {
            "USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD",
            "MXN", "SGD", "HKD", "NOK", "KRW", "TRY", "INR", "BRL", "RUB", "ZAR"
    };

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(600, 400); // Increased size to accommodate the header
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Load background image
        ImageIcon bgImage = new ImageIcon(getClass().getResource("/background.png"));
        bgImageLabel = new JLabel(bgImage);
        bgImageLabel.setBounds(0, 0, 600, 400);
        setContentPane(bgImageLabel);

        // Add header
        JLabel headerLabel = new JLabel("Currency-Convert", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Georgia", Font.BOLD, 24));
        headerLabel.setBounds(0, 10, 600, 30); // Position the header
        headerLabel.setForeground(Color.ORANGE); // Adjust color as needed
        add(headerLabel);

        // Add components
        fromCurrency = new JComboBox<>(CURRENCIES);
        toCurrency = new JComboBox<>(CURRENCIES);

        amountField = new JTextField("1");
        resultField = new JTextField();
        resultField.setEditable(false);

        fromFlag = new JLabel();
        toFlag = new JLabel();

        // Position components
        fromCurrency.setBounds(50, 60, 120, 30);
        toCurrency.setBounds(400, 60, 120, 30);
        amountField.setBounds(50, 110, 120, 30);
        resultField.setBounds(400, 110, 120, 30);
        fromFlag.setBounds(50, 160, 120, 30);
        toFlag.setBounds(400, 160, 120, 30);

        add(fromCurrency);
        add(toCurrency);
        add(amountField);
        add(resultField);
        add(fromFlag);
        add(toFlag);

        // Add action listeners
        fromCurrency.addItemListener(new CurrencyItemListener());
        toCurrency.addItemListener(new CurrencyItemListener());
        amountField.addActionListener(new ConvertActionListener());

        // Initial conversion
        convertCurrency();
    }

    private class CurrencyItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                convertCurrency();
            }
        }
    }

    private class ConvertActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            convertCurrency();
        }
    }

    private void convertCurrency() {
        String from = (String) fromCurrency.getSelectedItem();
        String to = (String) toCurrency.getSelectedItem();
        double amount = Double.parseDouble(amountField.getText());

        double rate = getConversionRate(from, to);
        double result = amount * rate;

        resultField.setText(String.format("%.2f", result));
    }

    private double getConversionRate(String from, String to) {
        double rate = 1.0;
        try {
            URL url = new URL(API_URL + API_KEY + "/latest/" + from);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(content.toString());
            rate = json.getJSONObject("conversion_rates").getDouble(to);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rate;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverter converter = new CurrencyConverter();
            converter.setVisible(true);
        });
    }
}
