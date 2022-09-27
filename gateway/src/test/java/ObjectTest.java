import org.junit.jupiter.api.Test;

public class ObjectTest {

    @Test
    public void test() throws InterruptedException {
        People people = new People();
//        people.wait();
    }

    class People {
        private String name;
        private int age;
    }
}
