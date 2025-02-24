import java.util.ArrayList;
import java.util.List;

public class UncheckedWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List rawList = new ArrayList(); 
        rawList.add("Java");
        rawList.add("Annotations");

        for (Object item : rawList) {
            System.out.println(item);
        }
    }
}
