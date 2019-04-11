public class PojoDemo {
    String a;
    String b;

    @Override
    public String toString() {
        return "PojoDemo{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    public PojoDemo(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
