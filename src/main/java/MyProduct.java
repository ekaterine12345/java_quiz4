public class MyProduct {
    private String name;
    private Long count;

    public MyProduct(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyProduct{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
