package abnormal;

public class AbnormalClass extends Exception{
    public AbnormalClass(){
    }

    public AbnormalClass(String message) {
        super(message);
    }
}
