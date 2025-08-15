package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculadoraSwing extends JFrame {

    private JTextField campoNum1, campoNum2, campoResultado;
    private JComboBox<String> comboOperacoes;

    public CalculadoraSwing() {
        // Configuração da Janela
        setTitle("Calculadora Swing");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes
        add(new JLabel("Número 1:"));
        campoNum1 = new JTextField();
        add(campoNum1);

        add(new JLabel("Operação:"));
        comboOperacoes = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        add(comboOperacoes);

        add(new JLabel("Número 2:"));
        campoNum2 = new JTextField();
        add(campoNum2);

        add(new JLabel("Resultado:"));
        campoResultado = new JTextField();
        campoResultado.setEditable(false);
        add(campoResultado);

        // Botão de Calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(campoNum1.getText());
                    double num2 = Double.parseDouble(campoNum2.getText());
                    String operacao = (String) comboOperacoes.getSelectedItem();
                    double resultado = calcular(num1, num2, operacao);
                    campoResultado.setText(String.format("%.2f", resultado));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite números válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (DivisaoPorZeroException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(btnCalcular);
    }

    private double calcular(double num1, double num2, String operacao) throws DivisaoPorZeroException {
        switch (operacao) {
            case "+":
                return Operacoes.somar(num1, num2);
            case "-":
                return Operacoes.subtrair(num1, num2);
            case "*":
                return Operacoes.multiplicar(num1, num2);
            case "/":
                return Operacoes.dividir(num1, num2);
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraSwing calculadora = new CalculadoraSwing();
            calculadora.setVisible(true);
        });
    }
}
