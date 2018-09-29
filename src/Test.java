import java.util.ArrayList;
import java.util.List;

public class Test {

    void method(double d, int i){
        System.out.println("I am in first");
    }

    void method(int i, double d){
        System.out.println("I am in Second");
    }

    void method(String s1, String s2){
        System.out.println("I am in third");
    }

    void method(ArrayList<String> list){
        System.out.println("I am in fourth");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.method(new ArrayList());
    }
}
