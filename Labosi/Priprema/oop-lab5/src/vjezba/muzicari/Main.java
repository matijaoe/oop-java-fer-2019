package vjezba.muzicari;

import java.util.HashMap;
import java.util.Map;

import static vjezba.muzicari.Util.fullfillTheRole;
import static vjezba.muzicari.Util2.bestQualifications;
import static vjezba.muzicari.Util3.averageSkillFiltrered;

public class Main {
    public static void main(String[] args) {

        Map<String, Map<String, Integer>> map = new HashMap<>();

        {
            Map<String, Integer> im1 = new HashMap<>();
            Map<String, Integer> im2 = new HashMap<>();
            Map<String, Integer> im3 = new HashMap<>();
            Map<String, Integer> im4 = new HashMap<>();

            im1.put("Bassist", 75);
            im1.put("Singer", 90);
            im2.put("Drummer", 90);
            im2.put("Bassist", 90);
            im2.put("Singer", 54);
            im3.put("Singer", 100);
            im4.put("Bassist", 35);
            im4.put("Drummer", 90);
            im4.put("Singer", 55);
            im4.put("Guitarist", 30);
            im4.put("Pianist", 99);

            map.put("Johnny", im1);
            map.put("Arthur", im2);
            map.put("Goran", im3);
            map.put("Donald", im4);
        }

        //System.out.println(fullfillTheRole(map, new TheRole("Bassist")));

        //System.out.println(bestQualifications(map));

        System.out.println(averageSkillFiltrered(map, "Drummer"));


    }
}
