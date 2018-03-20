import org.junit.Test;

public class Testtest {

    @Test
    public void testest() {
        Object object = "1";
        try {
            String s = (String) object;
            if (!s.equals("")) {
                Integer id = Integer.valueOf(s);
            }
        } catch (NumberFormatException e) {
            System.out.println("Wprowadź liczbę całkowitą");
        }
    }

}
