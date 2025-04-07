public class Turtle2D implements AutoCloseable {
    private TurtleClient turtleClient;

    public Turtle2D() {
        turtleClient = new TurtleClient();
    }

    @Override
    public void close() {
        turtleClient.close();
    }

    public void penUp() {
        this.turtleClient.sendSingleAction(TurtleAction.PENUP);
    }

    public void penDown() {
        this.turtleClient.sendSingleAction(TurtleAction.PENDOWN);
    }

    public void move(double length) {
        this.turtleClient.sendMoveAction(length);
    }

    public void left(double degrees) {
        this.turtleClient.sendRotationAction(TurtleAction.PITCH, degrees);
    }

    public void right(double degrees) {
        this.left(-degrees);
    }

    public void clockwise(double degrees) {
        this.left(degrees);
    }

    public void counterclockwise(double degrees) {
        this.right(degrees);
    }

    public void clear() {
        this.turtleClient.sendSingleAction(TurtleAction.CLEAR);
    }

    public void start() {
        this.turtleClient.sendSingleAction(TurtleAction.START);
    }

    public void color(double r, double g, double b) {
        if (r >= 0.0 && r <= 1.0 && g >= 0.0 && g <= 1.0 && b >= 0.0 && b <= 1.0) {
            this.turtleClient.sendColorAction(r, g, b);
        } else {
            String errString = String.format(
                    "Invalid color value; values must be in range betwen 0.0 and 1.0:(%f, %f, %f)\n",
                    r, g, b);
            System.err.println(errString);
        }
    }
}
