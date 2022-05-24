package validation;

public class Validator {

    // Username should contains at least 2 letters - upper or lower case
    public static boolean validateUsername(String username){
        return username.matches("[a-zA-Z]{2,}");
    }

    // Phone should contains two groups of digits surrounded by parenthesis.
    public static boolean validatePhone(String phone){
        return phone.matches("[(]\\d{4}[)]\\s[(]\\d{7}[)]");
    }

    // Email should contains only lowercase letters, no duplicate @, dots and spaces inside.
    public static boolean validateEmail(String email){
        return email.matches("([a-z]+([.]|[a-z]*))+[@][a-z]+[.][a-z]+");
    }

    // Confirm password should be identical to password.
    public static boolean validateConfirmPassword(String password, String confirmPassword){
        return password.equals(confirmPassword);
    }
}
