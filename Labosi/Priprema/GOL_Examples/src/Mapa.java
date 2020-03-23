import java.util.HashMap;
import java.util.Map;

public class Mapa {


    public static void main(String[] args) {

        Map<String, Integer> mapa = new HashMap<>();



        mapa.put("Ivana", 5);
        mapa.put("Marko", null);
        mapa.put("Josipa", 9);

        System.out.println(mapa);

        //mapa.merge("Ivana", 2, (vo, vi) -> return vo+vi); // FALSE
        //mapa.merge("Ivana", 2, Integer::sum(a,b)); // FALSE
        //mapa.merge("Ivana", 2, vo, vi -> vo+vi); // FALSE

        //mapa.merge("Ivana", 2, Integer::sum);
        mapa.merge("Ivana", 2, (vo, vi) -> vo+vi);

        //mapa.merge("Ivana", 2, (vo, vi) -> Integer::sum); // FALSE

        System.out.println(mapa);
    }
}
