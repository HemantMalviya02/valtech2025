

public class CheckPassword {
	
    public static String checkPasswordStrength(String password) {
        if (password.length() < 6) {
            return "Weak password";
        }

        boolean hasLetter = false, hasDigit = false, hasSpecialChar = false;
        String specialChars = "!@#$%^&*()-+=<>?/{}[]|";

        for (char ch : password.toCharArray()) {
            if (Character.isLetter(ch)) hasLetter = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.indexOf(ch) != -1) hasSpecialChar = true;
        }

        if (hasLetter && hasDigit && hasSpecialChar && password.length() >= 8) {
            return "Strong";
        } else if (hasLetter && hasDigit) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {
        String[] passwords = {"abcde", "abc123", "Abc@1234", "123456", "password"};

        for (String password : passwords) {
            System.out.println("Password: " + password + " -> Strength: " + checkPasswordStrength(password));
        }
    }
}
