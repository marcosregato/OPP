package AC_2_1;

public class HandleNumber {
    private int handleNumber;
    private Utils utils = new Utils();

    public void newHandleNumber(String message) {
        setHandleNumber(utils.showIntJOptionPane(message));
    }

    public int getHandleNumber() {
        return handleNumber;
    }

    public void setHandleNumber(int handleNumber) {
        this.handleNumber = handleNumber;
    }

}
