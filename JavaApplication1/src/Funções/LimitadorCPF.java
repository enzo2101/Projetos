package Funções;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.JTextField;

public class LimitadorCPF {
    public static void limitarTamanhoCPF(JTextField textField) {
        Document document = new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null)
                    return;

                String text = getText(0, getLength());
                String newText = text.substring(0, offset) + str.replaceAll("\\D++", "") + text.substring(offset);

                if (newText.length() <= 11) {
                    super.remove(0, getLength());
                    super.insertString(0, newText, attr);
                }
            }
        };

        textField.setDocument(document);
    }
}
