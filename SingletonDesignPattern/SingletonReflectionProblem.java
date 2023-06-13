package SingletonDesignPattern;

import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonReflectionProblem {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        DateUtil dateUtil1 = DateUtil.getInstance();
        DateUtil dateUtil2 = null;

        Constructor[] constructors = DateUtil.class.getDeclaredConstructors();
        for (Constructor construtor: constructors) {
            construtor.setAccessible(true);
            try {
                dateUtil2 = (DateUtil) construtor.newInstance();
            } catch (NullPointerException exception){
                exception.getMessage();
            }

        }

        System.out.println(dateUtil1.hashCode());
        System.out.println(dateUtil2.hashCode());
    }
}
