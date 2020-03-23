package zad2;

/**
 *
 * @author Matija
 */
class ObradaPodataka {

    static DataSource ds = new DataSource();
    static DataProcessUtil util = new DataProcessUtil();

    static int num = 0;
    static int processedNum = 0;
    static int sum = 0;

    public static int obradi() {

        for (int i = 1; i < DataSource.size(); i++) {

            try {
                num = DataSource.getNextNumber();
            } catch (Exception ex) {
                num = DataSource.getNextNumber();
            } finally {
                try {
                    processedNum = util.processNumber(num);
                    sum += processedNum;

                } catch (Exception ex) {
                    processedNum = util.handleException(ex, num);
                    sum += processedNum;
                }
            }

        }
        return sum;
    }

}
