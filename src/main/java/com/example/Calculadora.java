package com.example;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calculadora extends JFrame implements ActionListener {

    // operaciones matemáticas
private JTextField txtNum1, txtNum2, txtResultadoMat;
    // conversión temperatura
private JTextField txtTempEntrada, txtResultadoTemp;
    // conversión moneda
private JTextField txtMonedaEntrada, txtResultadoMoneda;
    // tasa fija USD → COP
private static final double TASA_COP = 3800.0;
    // constructor
public Calculadora() {
        setTitle("TALLER FINAL");
        setSize(600, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // panel principal
        JPanel panelPrincipal = new JPanel();
        // organiza verticalmente
        panelPrincipal.setLayout(
                new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        // espacio interno
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(12, 16, 12, 16));
        panelPrincipal.setBackground(
                new Color(245, 247, 250));
        // agregar paneles
        panelPrincipal.add(crearPanelMatematicas());
        panelPrincipal.add(Box.createVerticalStrut(12));
        panelPrincipal.add(crearPanelTemperatura());
        panelPrincipal.add(Box.createVerticalStrut(12));
        panelPrincipal.add(crearPanelMoneda());
        // scroll
        JScrollPane scroll =
                new JScrollPane(panelPrincipal);

        scroll.setBorder(null);

        add(scroll);

        setVisible(true);
    }

    // ─────────────────────────────────────────────
    // PANEL MATEMÁTICAS
    // ─────────────────────────────────────────────

    private JPanel crearPanelMatematicas() {

        JPanel panel =
                new JPanel(new GridBagLayout());

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(70, 130, 180), 2),
                        "Operaciones Matemáticas"));

        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(6, 8, 6, 8);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // etiquetas
        gbc.gridy = 0;

        gbc.gridx = 0;
        panel.add(labelCampo("Número 1:"), gbc);

        gbc.gridx = 1;
        panel.add(labelCampo("Número 2:"), gbc);

        gbc.gridx = 2;
        panel.add(labelCampo("Resultado:"), gbc);

        // campos
        gbc.gridy = 1;

        gbc.gridx = 0;
        txtNum1 = campoTexto("");
        panel.add(txtNum1, gbc);

        gbc.gridx = 1;
        txtNum2 = campoTexto("");
        panel.add(txtNum2, gbc);

        gbc.gridx = 2;

        txtResultadoMat = campoTexto("");

        txtResultadoMat.setEditable(false);

        txtResultadoMat.setBackground(
                new Color(235, 245, 255));

        panel.add(txtResultadoMat, gbc);

        // botones
        gbc.gridy = 2;

        gbc.gridx = 0;

        gbc.gridwidth = 3;

        JPanel botones =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                10,
                                0));

        botones.setBackground(Color.WHITE);

        botones.add(
                boton("Sumar",
                        "SUMAR",
                        new Color(46, 139, 87)));

        botones.add(
                boton("Restar",
                        "RESTAR",
                        new Color(205, 92, 92)));

        botones.add(
                boton("Multiplicar",
                        "MULTIPLICAR",
                        new Color(70, 130, 180)));

        botones.add(
                boton("Dividir",
                        "DIVIDIR",
                        new Color(184, 134, 11)));

        panel.add(botones, gbc);

        return panel;
    }

    // ─────────────────────────────────────────────
    // PANEL TEMPERATURA
    // ─────────────────────────────────────────────

    private JPanel crearPanelTemperatura() {

        JPanel panel =
                new JPanel(new GridBagLayout());

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 80, 40), 2),
                        "Conversión de Temperatura"));

        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(6, 8, 6, 8);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // etiquetas
        gbc.gridy = 0;

        gbc.gridx = 0;
        panel.add(labelCampo("Temperatura:"), gbc);

        gbc.gridx = 1;
        panel.add(labelCampo("Resultado:"), gbc);

        // campos
        gbc.gridy = 1;

        gbc.gridx = 0;

        txtTempEntrada = campoTexto("");

        panel.add(txtTempEntrada, gbc);

        gbc.gridx = 1;

        txtResultadoTemp = campoTexto("");

        txtResultadoTemp.setEditable(false);

        txtResultadoTemp.setBackground(
                new Color(255, 245, 235));

        panel.add(txtResultadoTemp, gbc);

        // botones
        gbc.gridy = 2;

        gbc.gridx = 0;

        gbc.gridwidth = 2;

        JPanel botones =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                10,
                                0));

        botones.setBackground(Color.WHITE);

        botones.add(
                boton("°C → °F",
                        "C_A_F",
                        new Color(220, 80, 40)));

        botones.add(
                boton("°F → °C",
                        "F_A_C",
                        new Color(100, 60, 180)));

        panel.add(botones, gbc);

        return panel;
    }

    // ─────────────────────────────────────────────
    // PANEL MONEDA
    // ─────────────────────────────────────────────

    private JPanel crearPanelMoneda() {

        JPanel panel =
                new JPanel(new GridBagLayout());

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(34, 139, 34), 2),
                        "Conversión de Moneda"));

        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(6, 8, 6, 8);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // etiquetas
        gbc.gridy = 0;

        gbc.gridx = 0;
        panel.add(labelCampo("Valor:"), gbc);

        gbc.gridx = 1;
        panel.add(labelCampo("Resultado:"), gbc);

        // campos
        gbc.gridy = 1;

        gbc.gridx = 0;

        txtMonedaEntrada = campoTexto("");

        panel.add(txtMonedaEntrada, gbc);

        gbc.gridx = 1;

        txtResultadoMoneda = campoTexto("");

        txtResultadoMoneda.setEditable(false);

        txtResultadoMoneda.setBackground(
                new Color(235, 255, 235));

        panel.add(txtResultadoMoneda, gbc);

        // botones
        gbc.gridy = 2;

        gbc.gridx = 0;

        gbc.gridwidth = 2;

        JPanel botones =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                10,
                                0));

        botones.setBackground(Color.WHITE);

        botones.add(
                boton("USD → COP",
                        "USD_A_COP",
                        new Color(34, 139, 34)));

        botones.add(
                boton("COP → USD",
                        "COP_A_USD",
                        new Color(184, 134, 11)));

        panel.add(botones, gbc);

        return panel;
    }

    // ─────────────────────────────────────────────
    // MÉTODOS AUXILIARES
    // ─────────────────────────────────────────────

    private JLabel labelCampo(String texto) {

        JLabel lbl = new JLabel(texto);

        lbl.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12));

        return lbl;
    }

    private JTextField campoTexto(String texto) {

        JTextField tf =
                new JTextField(texto, 10);

        tf.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13));

        tf.setPreferredSize(
                new Dimension(130, 30));

        return tf;
    }

    private JButton boton(String texto,
                          String comando,
                          Color color) {

        JButton btn = new JButton(texto);

        btn.setActionCommand(comando);

        btn.addActionListener(this);

        btn.setBackground(color);

        btn.setForeground(Color.WHITE);

        btn.setFocusPainted(false);

        btn.setBorderPainted(false);

        btn.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR));

        return btn;
    }

    // ─────────────────────────────────────────────
    // VALIDACIÓN
    // ─────────────────────────────────────────────

    private double validarCampo(
            JTextField campo,
            String nombreCampo,
            boolean permitirNegativos) {

        String texto =
                campo.getText().trim();

        // vacío
        if (texto.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "El campo " +
                            nombreCampo +
                            " está vacío",
                    "Campo vacío",
                    JOptionPane.WARNING_MESSAGE);

            campo.requestFocus();

            throw new IllegalArgumentException();
        }

        try {

            double valor =
                    Double.parseDouble(texto);

            // negativos
            if (!permitirNegativos && valor < 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se permiten números negativos.",
                        "Número inválido",
                        JOptionPane.ERROR_MESSAGE);

                campo.selectAll();

                campo.requestFocus();

                throw new IllegalArgumentException();
            }

            return valor;

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "\"" + texto +
                            "\" no es un número válido.",
                    "Dato inválido",
                    JOptionPane.ERROR_MESSAGE);

            campo.selectAll();

            campo.requestFocus();

            throw new IllegalArgumentException();
        }
    }

    // ─────────────────────────────────────────────
    // EVENTOS BOTONES
    // ─────────────────────────────────────────────

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd =
                e.getActionCommand();

        switch (cmd) {

            // SUMAR
            case "SUMAR":

                try {

                    double n1 =
                            validarCampo(
                                    txtNum1,
                                    "Número 1",
                                    true);

                    double n2 =
                            validarCampo(
                                    txtNum2,
                                    "Número 2",
                                    true);

                    txtResultadoMat.setText(
                            formatear(n1 + n2));

                } catch (Exception ignored) {}

                break;

            // RESTAR
            case "RESTAR":

                try {

                    double n1 =
                            validarCampo(
                                    txtNum1,
                                    "Número 1",
                                    true);

                    double n2 =
                            validarCampo(
                                    txtNum2,
                                    "Número 2",
                                    true);

                    txtResultadoMat.setText(
                            formatear(n1 - n2));

                } catch (Exception ignored) {}

                break;

            // MULTIPLICAR
            case "MULTIPLICAR":

                try {

                    double n1 =
                            validarCampo(
                                    txtNum1,
                                    "Número 1",
                                    true);

                    double n2 =
                            validarCampo(
                                    txtNum2,
                                    "Número 2",
                                    true);

                    txtResultadoMat.setText(
                            formatear(n1 * n2));

                } catch (Exception ignored) {}

                break;

            // DIVIDIR
            case "DIVIDIR":

                try {

                    double n1 =
                            validarCampo(
                                    txtNum1,
                                    "Número 1",
                                    true);

                    double n2 =
                            validarCampo(
                                    txtNum2,
                                    "Número 2",
                                    true);

                    if (n2 == 0) {

                        JOptionPane.showMessageDialog(
                                this,
                                "No se puede dividir por cero");

                        break;
                    }

                    txtResultadoMat.setText(
                            formatear(n1 / n2));

                } catch (Exception ignored) {}

                break;

            // CELSIUS → FAHRENHEIT
            case "C_A_F":

                try {

                    double c =
                            validarCampo(
                                    txtTempEntrada,
                                    "Temperatura",
                                    true);

                    double f =
                            (c * 9 / 5) + 32;

                    txtResultadoTemp.setText(
                            formatear(c) +
                                    " °C = " +
                                    formatear(f) +
                                    " °F");

                } catch (Exception ignored) {}

                break;

            // FAHRENHEIT → CELSIUS
            case "F_A_C":

                try {

                    double f =
                            validarCampo(
                                    txtTempEntrada,
                                    "Temperatura",
                                    true);

                    double c =
                            (f - 32) * 5 / 9;

                    txtResultadoTemp.setText(
                            formatear(f) +
                                    " °F = " +
                                    formatear(c) +
                                    " °C");

                } catch (Exception ignored) {}

                break;

            // USD → COP
            case "USD_A_COP":

                try {

                    double usd =
                            validarCampo(
                                    txtMonedaEntrada,
                                    "USD",
                                    false);

                    double cop =
                            usd * TASA_COP;

                    txtResultadoMoneda.setText(
                            formatearMoneda(cop)
                                    + " COP");

                } catch (Exception ignored) {}

                break;

            // COP → USD
            case "COP_A_USD":

                try {

                    double cop =
                            validarCampo(
                                    txtMonedaEntrada,
                                    "COP",
                                    false);

                    double usd =
                            cop / TASA_COP;

                    txtResultadoMoneda.setText(
                            formatear(usd)
                                    + " USD");

                } catch (Exception ignored) {}

                break;
        }
    }

    // ─────────────────────────────────────────────
    // FORMATEAR
    // ─────────────────────────────────────────────

    private String formatear(double valor) {

        if (valor == Math.floor(valor)) {

            return String.valueOf(
                    (long) valor);
        }

        return String.format(
                "%.2f",
                valor);
    }

    private String formatearMoneda(double valor) {

        return String.format(
                "%,.2f",
                valor);
    }

    // ─────────────────────────────────────────────
    // MAIN
    // ─────────────────────────────────────────────

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new Calculadora();
        });
    }
}