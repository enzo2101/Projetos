package Funções;

public class ValidaCPF {
    
    private boolean validaCPF(String cpf) {       
        // Extrai os dígitos do CPF
        int num1 = Character.getNumericValue(cpf.charAt(0));
        int num2 = Character.getNumericValue(cpf.charAt(1));
        int num3 = Character.getNumericValue(cpf.charAt(2));
        int num4 = Character.getNumericValue(cpf.charAt(3));
        int num5 = Character.getNumericValue(cpf.charAt(4));
        int num6 = Character.getNumericValue(cpf.charAt(5));
        int num7 = Character.getNumericValue(cpf.charAt(6));
        int num8 = Character.getNumericValue(cpf.charAt(7));
        int num9 = Character.getNumericValue(cpf.charAt(8));
        int num10 = Character.getNumericValue(cpf.charAt(9));
        int num11 = Character.getNumericValue(cpf.charAt(10));

        // Validação dos CPFs inválidos conhecidos
        if (num1 == num2 && num2 == num3 && num3 == num4 && num4 == num5 && num5 == num6 && num6 == num7 && num7 == num8 && num8 == num9 && num9 == num10 && num10 == num11) {
            return false;
        } else {
            int soma1 = num1 * 10 + num2 * 9 + num3 * 8 + num4 * 7 + num5 * 6 + num6 * 5 + num7 * 4 + num8 * 3 + num9 * 2;
            int resto1 = (soma1 * 10) % 11;

            if (resto1 == 10) {
                resto1 = 0;
            }

            int soma2 = num1 * 11 + num2 * 10 + num3 * 9 + num4 * 8 + num5 * 7 + num6 * 6 + num7 * 5 + num8 * 4 + num9 * 3 + num10 * 2;
            int resto2 = (soma2 * 10) % 11;

            if (resto2 == 10) {
                resto2 = 0;
            }

            return (resto1 == num10) && (resto2 == num11);
        }
    }
    public boolean isCPFValido(String cpf) {
        return validaCPF(cpf);
    }
}
