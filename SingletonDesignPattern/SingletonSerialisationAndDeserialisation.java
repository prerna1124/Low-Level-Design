package SingletonDesignPattern;

import java.io.*;

public class SingletonSerialisationAndDeserialisation {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DateUtil dateUtil = DateUtil.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(
                        new File("/Users/prernasharma/Downloads/Low-Level-Design/SingletonDesignPattern/File.ser")));
        objectOutputStream.writeObject(dateUtil);

        DateUtil dateUtil1 = null;
        ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(("/Users/prernasharma/Downloads/Low-Level-Design/SingletonDesignPattern/File.ser"))));
        dateUtil1 = (DateUtil) objectInputStream.readObject();

        objectOutputStream.close();
        objectInputStream.close();

        System.out.println(dateUtil.hashCode());
        System.out.println(dateUtil1.hashCode());

    }
}
