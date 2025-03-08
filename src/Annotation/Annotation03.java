package Annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author TuanFans
 * &#064;date 2025/3/8
 */
public class Annotation03 {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49,50);
        trackUseCases(useCases, PasswordUtils.class);
    }

    public static void trackUseCases(List<Integer> useCases, Class<?> cl){
        for(Method m : cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null){
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(uc.id());
            }
        }
        for(int i : useCases){
            System.out.println("Warning: Missing use case " + i);
        }
    }
}

class PasswordUtils{
    @UseCase(id = 47, description =
            "Passwords must contain at least one numeric")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description =
            "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password){
        return !prevPasswords.contains(password);
    }
}
