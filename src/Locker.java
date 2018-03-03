public class Locker {

    private int id;
    private boolean isOpen;

    public Locker(int id) {
        this.id = id;
        this.isOpen = false;
    }

    public int getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
