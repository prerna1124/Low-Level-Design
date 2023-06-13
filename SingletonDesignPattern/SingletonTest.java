package SingletonDesignPattern;

public class SingletonTest {
    public static void main(String[] args) {
        DateUtil instance1 = DateUtil.getInstance();
        DateUtil instance2 = DateUtil.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());


    }
}
