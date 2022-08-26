import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FluxTest {

    @BeforeAll
    public static void init() {
        System.out.println("init--------------------------");
    }

    @Test
    public void testSubscriber() {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
        map.put(2, 2);

        Flux f = Flux.fromIterable(map.values());

        map.put(3, 3);

        f.subscribe(System.out::println);

        map.remove(1);

        f.subscribe(System.out::println);
    }

    @Test
    public void testJust() {
        Flux f2 = Flux.just(1, 2, 3);
        Flux f3 = f2.take(4);

        f2.subscribe(System.out::print);
        System.out.println();
        f3.subscribe(System.out::print);

        f2.then();
    }
}
