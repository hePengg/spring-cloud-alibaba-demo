import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import reactor.cache.CacheFlux;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheFluxTest {

    static Map<String, Map<String, String>> map1 = new ConcurrentHashMap<>();
    static Map<String, List> map2 = new ConcurrentHashMap<>();

    static Map<String, Flux<String>> map3 = new ConcurrentHashMap<>();

    @BeforeTestClass
    public static void init() {
        map1.putIfAbsent("1", new HashMap<>());
        map1.putIfAbsent("2", new HashMap<>());
        map1.putIfAbsent("3", new HashMap<>());
        map1.get("2").put("1", "1");

//        System.out.println(map1);
//        System.out.println(map2);
//        System.out.println(map3);
//        System.out.println();

        map3.putIfAbsent("2", CacheFlux.lookup(map2, "2", String.class).onCacheMissResume(() -> Flux.fromIterable(map1.get("2").values())));

//        System.out.println(map1);
//        System.out.println(map2);
//        System.out.println(map3);
//        System.out.println();

        map1.get("2").put("2", "2");
        map1.get("2").put("4", "4");
        map1.get("2").put("5", "5");
//        map3.putIfAbsent("2", CacheFlux.lookup(map2, "2", String.class).onCacheMissResume(() -> Flux.fromIterable(map1.get("2").values())));
    }

    @Test
    public void test() {
//        Flux<String> flux = map3.get("2");
//        flux.subscribe(System.out::println);
//
//        flux.doOnError((throwable) -> {
////            System.out.println("v :" + v);
////            System.out.println(throwable);
//        }).subscribe(
//            s -> {
//                if (s.equals("2")) {
//                    throw new RuntimeException("test throw exp");
//                } else {
//                    System.out.println(s);
//                }
//            }
//        );
//
//        flux.subscribe(System.out::println);
    }
}
