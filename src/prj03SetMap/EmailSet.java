package prj03SetMap;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSet {
    private static final HashSet<String> emailSet = new HashSet<>();

    public static void main(String[] args) {
        String[] emails = {"email@email.com", "email@email.", "emailemail.ru",
                "@email.ru", "email2@email.ru", "email3@email.ru", "email2@email.ru", "email6@email.ru"};
        for (String email : emails) {
            if (checkEmail(email)) {
                System.out.println("email - " + email + " good");
                if (!existEmailInSet(email)) {
                    emailSet.add(email);
                    System.out.println("email " + email + " added to emailSet");
                } else {
                    System.out.println("email " + email + " is alreadey exist in emailSet");
                }
            } else {
                System.out.println("email - " + email + " bad");
            }
        }
        System.out.println("show added emails");
        showEmailSet(emailSet);
    }

    private static boolean existEmailInSet(String email) {
        if (emailSet == null) {
            System.out.println("Email set is null");
            return false;
        }
        return emailSet.contains(email);
    }

    private static boolean checkEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static void showEmailSet(HashSet<String> emailSet) {
        for (String email : emailSet) {
            System.out.println(email);
        }
    }
}
