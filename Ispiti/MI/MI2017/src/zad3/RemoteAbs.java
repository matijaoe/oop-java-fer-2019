package zad3;

/**
 *
 * @author Matija
 */
public abstract class RemoteAbs extends Device implements Remote {

    private boolean isRemoteSessionActive;

    public RemoteAbs(String id, boolean isPoweredOn, boolean isRemoteSessionActive) {
        super(id, isPoweredOn);
        this.isRemoteSessionActive = isRemoteSessionActive;
    }

    @Override
    public void startRemoteSession() {
        this.isRemoteSessionActive = true;
    }

    @Override
    public void endRemoteSession() {
        this.isRemoteSessionActive = false;
    }

    public boolean isIsRemoteSessionActive() {
        return isRemoteSessionActive;
    }

}
