public enum TurtleAction {
    PENUP,
    PENDOWN,
    MOVE,
    YAW,
    PITCH,
    ROLL,
    COLOR,
    CLEAR,
    START;

    @Override
    public String toString() {
        switch (this) {
            case PENUP: return "penup";
            case PENDOWN: return "pendown";
            case MOVE: return "move";
            case YAW: return "yaw";
            case PITCH: return "pitch";
            case ROLL: return "roll";
            case COLOR: return "color";
            case CLEAR: return "clear";
            case START: return "start";
        }
        return null;
    }
}
