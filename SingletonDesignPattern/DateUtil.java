package SingletonDesignPattern;

import java.io.Serializable;

public class DateUtil implements Serializable {

/* Eager Initailisation
    1.) private static DateUtil instance = new DateUtil();

    2.)
    private static DateUtil instance;

    static {
        instance = new DateUtil();
    }
*/
    private static volatile DateUtil instance;

    private DateUtil() {
    }

    public static DateUtil getInstance() {
        if(instance == null) {
            synchronized (DateUtil.class) {
                instance = new DateUtil();
            }
        }
        return instance;
    }
    //Internally called by ObjectInputStream while deserialisation
    public Object readResolve() {
        return instance;
    }
}
