package com.cep.cep.utils;

public class CPFUtils {

    public static boolean validarCPF(String cpf) {
        // Verifica se o CPF é nulo ou está vazio
        if (cpf == null || cpf.trim().isEmpty()) {
            return false;
        }

        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
            digitoCPF = Integer.parseInt(cpf.substring(nCount - 1, nCount));

            // multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
            d1 += (11 - nCount) * digitoCPF;

            // para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
            d2 += (12 - nCount) * digitoCPF;
        }

        // Primeiro resto da divisão por 11.
        resto = (d1 % 11);
        digito1 = (resto < 2) ? 0 : 11 - resto;

        d2 += 2 * digito1;

        // Segundo resto da divisão por 11.
        resto = (d2 % 11);
        digito2 = (resto < 2) ? 0 : 11 - resto;

        // Verifica se os dígitos calculados conferem com os dígitos do CPF
        return cpf.charAt(9) == (char) ('0' + digito1) && cpf.charAt(10) == (char) ('0' + digito2);
    }
}
