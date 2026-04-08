package ContactManager.util;

import java.util.regex.Pattern;

public class Validador {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static boolean emailValido(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Verifica formato básico
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            return false;
        }

        // Verifica domínios permitidos 
        String lower = email.toLowerCase();
        return lower.endsWith("@gmail.com") ||
               lower.endsWith("@outlook.com") ||
               lower.endsWith("@hotmail.com");
    }
}
