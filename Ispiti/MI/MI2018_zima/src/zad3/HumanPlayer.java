package zad3;

/**
 *
 * @author Matija
 */
public class HumanPlayer extends Person implements Player {

    private final String nickname;

    public HumanPlayer(String nickname, String id, String name) {
        super(id, name);
        this.nickname = nickname;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

}
