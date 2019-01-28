import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame {

    private final JTextField num1, num2;
    private final JLabel result;

    private Calculator() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel enter1 = new JLabel("First: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(enter1, c);

        num1 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        add(num1, c);

        JLabel enter2 = new JLabel("Second: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(enter2, c);

        num2 = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 3;
        add(num2, c);

        JButton one = new JButton("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        add(one, c);

        JButton two = new JButton("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        add(two, c);

        JButton three = new JButton("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 1;
        add(three, c);

        JButton four = new JButton("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        add(four, c);

        JButton five = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        add(five, c);

        JButton six = new JButton("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        add(six, c);

        JButton seven = new JButton("7");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        add(seven, c);

        JButton eight = new JButton("8");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        add(eight, c);

        JButton nine = new JButton("9");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 1;
        add(nine, c);

        JButton zero = new JButton("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        add(zero, c);

        JButton add = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 5;
        c.gridwidth = 1;
        add(add, c);

        JButton subtract = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 4;
        add(subtract, c);

        JButton multiply = new JButton("*");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 3;
        add(multiply, c);

        JButton divide = new JButton("/");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 2;
        add(divide, c);

        result = new JLabel("");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 4;
        add(result, c);

        event a = new event();
        add.addActionListener(a);
        subtract.addActionListener(a);
        multiply.addActionListener(a);
        divide.addActionListener(a);
    }

    class event implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            double number1, number2;

            try {
                number1 = Double.parseDouble(num1.getText());
            } catch (NumberFormatException e) {
                result.setText("Illegal data in first field.");
                result.setForeground(Color.RED);
                return;
            }
            try {
                number2 = Double.parseDouble(num2.getText());
            } catch (NumberFormatException e) {
                result.setText("Illegal data in second field.");
                result.setForeground(Color.RED);
                return;
            }

            String operator = a.getActionCommand();

            switch (operator) {
                case "+":
                    double sum = number1 + number2;
                    result.setText(number1 + " + " + number2 + " = " + sum);
                    result.setForeground(Color.RED);
                    break;
                case "-":
                    double difference = number1 - number2;
                    result.setText(number1 + " - " + number2 + " = " + difference);
                    result.setForeground(Color.RED);
                    break;
                case "*":
                    double product = number1 * number2;
                    result.setText(number1 + " * " + number2 + " = " + product);
                    result.setForeground(Color.RED);
                    break;
                case "/":
                    if (number2 == 0) {
                        result.setText("Cannot divide by 0");
                        result.setForeground(Color.RED);
                    } else {
                        double quotient = number1 / number2;
                        result.setText(number1 + " / " + number2 + " = " + quotient);
                        result.setForeground(Color.RED);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args){
        Calculator gui = new Calculator();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(300, 250);
        gui.setTitle("Calculator");
    }
}
