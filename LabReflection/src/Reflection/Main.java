package Reflection;
;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cl = Reflection.class;
        System.out.println("class " + cl.getSimpleName());
        System.out.println(cl.getSuperclass());
        Class[] interfaces = cl.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection rf = (Reflection) cl.newInstance();

        System.out.println(rf);

    }
}
