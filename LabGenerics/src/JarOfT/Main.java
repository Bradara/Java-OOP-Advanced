package JarOfT;

public class Main {
    public static void main(String[] args) {
        Pickle p = new Pickle();
        Pickle n = new Pickle();
        Pickle o = new Pickle();
        Jar<Pickle> jar = new Jar<>();

        jar.add(p);
        jar.add(o);
        jar.add(n);

        System.out.println(jar.remove());
    }
}
