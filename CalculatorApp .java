import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalButton, clearButton;
    private double firstNumber, secondNumber;
    private char operation;

    public CalculatorApp() {
        // Setup the JFrame
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // Create GUI components
        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(JTextField.RIGHT);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new NumberButtonListener());
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        // Add components to the JFrame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(addButton);

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subtractButton);

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(multiplyButton);

        buttonPanel.add(clearButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalButton);
        buttonPanel.add(divideButton);

        // Add components to JFrame
        add(inputField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Set up listeners
        addButton.addActionListener(new OperationButtonListener('+'));
        subtractButton.addActionListener(new OperationButtonListener('-'));
        multiplyButton.addActionListener(new OperationButtonListener('*'));
        divideButton.addActionListener(new OperationButtonListener('/'));
        equalButton.addActionListener(new EqualButtonListener());
        clearButton.addActionListener(new ClearButtonListener());
    }

    private class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            inputField.setText(inputField.getText() + buttonText);
        }
    }

    private class OperationButtonListener implements ActionListener {
        private char op;

        public OperationButtonListener(char op) {
            this.op = op;
        }

        public void actionPerformed(ActionEvent e) {
            firstNumber = Double.parseDouble(inputField.getText());
            operation = op;
            inputField.setText("");
        }
    }

    private class EqualButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            secondNumber = Double.parseDouble(inputField.getText());
            double result = 0;

            switch (operation) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        inputField.setText("Error");
                        return;
                    }
                    break;
            }

            inputField.setText(String.valueOf(result));
        }
    }

    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
            firstNumber = 0;
            secondNumber = 0;
            operation = '\0';
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp calculator = new CalculatorApp();
            calculator.setVisible(true);
        });
    }
}
