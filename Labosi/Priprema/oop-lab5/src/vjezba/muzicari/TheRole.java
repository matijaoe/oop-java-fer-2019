package vjezba.muzicari;

import java.util.function.Predicate;

class TheRole implements Predicate<String> {

    private String role;

    public TheRole(String s) {
        this.role = s;
    }

    @Override
    public boolean test(String theRole) {
        return theRole.equals(this.role);
    }

}
