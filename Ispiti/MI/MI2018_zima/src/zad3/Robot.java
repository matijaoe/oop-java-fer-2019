package zad3;

/**
 *
 * @author Matija
 */
public class Robot implements Player {

    private final String model;
    private final String serial;

    private Person contactPerson;

    public Robot(String model, String serial) {
        this.model = model;
        this.serial = serial;
    }

    public String getSerial() {
        return serial;
    }

    public String getModel() {
        return model;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Person p) {
        this.contactPerson = p;
    }

    @Override
    public String getNickname() {
        return this.serial;
    }

}
