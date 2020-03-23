package hr.fer.oop.primjer03;

public class PrimjerMetode {
    
    public static void main(String[] args) {
        
        Integer broj1 = 27;
        Integer broj2 = -13;
        String ime1 = "Pero";
        String ime2 = "Ivo";
        
        System.out.println(paranSazetak(broj1)); // false
        System.out.println(paranSazetak(ime1)); // true

        Integer broj3 = veciSazetak(broj1, broj2);
        String ime3 = veciSazetak(ime1, ime2);
        
        System.out.println(broj3); // 27
        System.out.println(ime3); // Pero

        System.out.println(veciSazetak("Jasna", "Petra").substring(1));
    }
    
    public static <T> boolean paranSazetak(T objekt) {
        int sazetak = objekt.hashCode();
        return sazetak % 2 == 0;
    }
    
    public static <T> T veciSazetak(T o1, T o2) {
        int sazetak1 = o1.hashCode();
        int sazetak2 = o2.hashCode();
        return sazetak1 >= sazetak2 ? o1 : o2;
    }
}
