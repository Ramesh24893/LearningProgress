package View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
   boolean validateMobileNum(String mobileNum){

        Pattern pattern = Pattern.compile("[6-9]{1}[0-9]{9}");
        Matcher matcher = pattern.matcher(mobileNum);
        return matcher.matches();
    }
     boolean validateAccNumber(String accNum){

        Pattern pattern = Pattern.compile("[0-9]{14}");
        Matcher matcher = pattern.matcher(accNum);
        return matcher.matches();
    }
     boolean validateName(String name){

        Pattern pattern=Pattern.compile("[A-Za-z]{3,21}");
        Matcher matcher= pattern.matcher(name);
        return matcher.matches();
    }
    boolean validateAadhaar(String aadhaarNum){

       Pattern pattern = Pattern.compile("[0-9]{12}");
        Matcher matcher = pattern.matcher(aadhaarNum);
        return matcher.matches();
    }

    boolean validateGender(String gender){

        Pattern pattern=Pattern.compile("^[MFO]$");
        Matcher matcher=pattern.matcher(gender);
        return matcher.matches();
    }

    boolean validatePan(String pan){

       Pattern pattern=Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
        Matcher matcher=pattern.matcher(pan);
        return matcher.matches();
    }
    boolean validatePassword(String password){

        return password.length() >= 8;
    }
    boolean validateUserName(String name){

        Pattern pattern=Pattern.compile("^[A-Za-z][A-Za-z0-9_@]{7,29}$");
        Matcher matcher= pattern.matcher(name);
        return matcher.matches();

    }
}
