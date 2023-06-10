package Funções;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class ValidadorIdade {
    public static boolean validarIdade(int dia, int mes, int ano) {
        // Obtém a data atual
        Calendar dataAtual = Calendar.getInstance();
        int anoAtual = dataAtual.get(Calendar.YEAR);
        int mesAtual = dataAtual.get(Calendar.MONTH) + 1; // O mês é baseado em zero, então adicionamos 1
        int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);

        int idade = anoAtual - ano;

        // Verifica se o mês atual é menor que o mês de aniversário ou se o mês é igual, mas o dia atual é menor
        if (mesAtual < mes || (mesAtual == mes && diaAtual < dia)) {
            idade--; // Ainda não fez aniversário, então subtrai 1 da idade
        }

        // Verifica se a idade é maior que 120
        if (idade > 120) {
            JOptionPane.showMessageDialog(null, "Idade inválida. A pessoa não pode ter mais de 120 anos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
