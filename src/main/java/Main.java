import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by sa on 13.01.17.
 */
public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext context=new GenericXmlApplicationContext();
        context.load("task-namespace-app-context.xml");
        context.refresh();
        System.out.println("start");
        while (true){

        }
    }
}
