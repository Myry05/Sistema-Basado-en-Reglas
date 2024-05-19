import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RuleBasedSystem extends JFrame {
    private JTextField inputField1;
    private JTextField inputField2;
    private JTextArea resultArea;
    private JButton evaluateButton;

    public RuleBasedSystem() {
        setTitle("Sistema Basado en Reglas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        inputField1 = new JTextField(10);
        inputField2 = new JTextField(10);
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        evaluateButton = new JButton("Evaluar Reglas");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Entrada 1:"));
        inputPanel.add(inputField1);
        inputPanel.add(new JLabel("Entrada 2:"));
        inputPanel.add(inputField2);

        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateRules();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        panel.add(evaluateButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void evaluateRules() {
        String input1 = inputField1.getText();
        String input2 = inputField2.getText();

        StringBuilder result = new StringBuilder("Resultados de la evaluación:\n");

        if (rule1(input1, input2)) {
            result.append("Regla 1: Ambas entradas son números positivos.\n");
        } else {
            result.append("Regla 1: Fallo.\n");
        }

        if (rule2(input1, input2)) {
            result.append("Regla 2: La suma de ambas entradas es mayor a 100.\n");
        } else {
            result.append("Regla 2: Fallo.\n");
        }

        resultArea.setText(result.toString());
    }

    private boolean rule1(String input1, String input2) {
        try {
            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);
            return num1 > 0 && num2 > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean rule2(String input1, String input2) {
        try {
            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);
            return (num1 + num2) > 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RuleBasedSystem().setVisible(true);
            }
        });
    }
}
