package client.enums;

public enum LoginStateType {
    LOGGED_OUT(0),
    LOGIN_TRANSITION(1),
    LOGGED_IN(2);

    private final byte type;

    public byte getType() {
        return type;
    }

    LoginStateType(int type) {
        this.type = (byte) type;
    }
}
