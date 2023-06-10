package Funções;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class Campo_data {
    private JTextField dia;
    private JTextField mes;
    private JTextField anoTextField; // Renomeada para evitar conflito de nomes

    public Campo_data(JTextField dia, JTextField mes, JTextField ano) {
        this.dia = dia;
        this.mes = mes;
        this.anoTextField = ano; // Atribuído ao novo nome da variável

        adicionarOuvintesCamposData();
    }

    private void adicionarOuvintesCamposData() {
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarTamanhoCampo((JTextField) e.getDocument().getProperty("owner"));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarTamanhoCampo((JTextField) e.getDocument().getProperty("owner"));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarTamanhoCampo((JTextField) e.getDocument().getProperty("owner"));
            }

            private void verificarTamanhoCampo(JTextField textField) {
                int maxLength = 2; // Defina o número máximo de caracteres permitidos para os campos Dia e Mês
                int maxLengthAno = 4; // Defina o número máximo de caracteres permitidos para o campo Ano

            if (textField.equals(dia) && textField.getText().length() >= maxLength) {
                mes.requestFocusInWindow(); // Mover o foco para o campo Mês
            } else if (textField.equals(mes) && textField.getText().length() >= maxLength) {
                anoTextField.requestFocusInWindow(); // Mover o foco para o campo Ano
            } else if (textField.equals(anoTextField) && textField.getText().length() >= maxLengthAno) {
                anoTextField.transferFocus(); // Pular para o próximo campo após digitar os 4 dígitos do ano
            }
            }
        };

        ((AbstractDocument) dia.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d")) { // Verificar se é um dígito numérico
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d")) { // Verificar se é um dígito numérico
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) mes.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d")) { // Verificar se é um dígito numérico
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d")) { // Verificar se é um dígito numérico
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) anoTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("\\d")) { // Verificar se é um dígito numérico
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("\\d")) { // Verificar se é um dígito numérico
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        dia.getDocument().putProperty("owner", dia);
        dia.getDocument().addDocumentListener(listener);

        mes.getDocument().putProperty("owner", mes);
        mes.getDocument().addDocumentListener(listener);

        anoTextField.getDocument().putProperty("owner", anoTextField);
        anoTextField.getDocument().addDocumentListener(listener);
    }
}
