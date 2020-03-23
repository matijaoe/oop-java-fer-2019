package data_element;

/**
 *
 * @author Matija
 */
class Util {

    public static void processData(DataElement el) {
        try {

            if (el.check()) {
                System.out.println("OK");
            } else {
                System.out.println("ERROR");
            }

        } catch (Exception ex) {
            System.out.println(ex.getClass().getSimpleName());
            throw ex;
        }
    }

    public static void main(String[] args) {

        DataElement de1 = new DataElement();
        DataElement de2 = new DataElement();
        DataElement de3 = new DataElement();

        processData(de1);
        processData(de2);
        processData(de3);
    }

}
