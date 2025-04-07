public class Main {
    static void Tree(
            Turtle3D turtle,
            double length,
            double angle,
            int maxHeight,
            int height) {
        if (height >= maxHeight) {
            return;
        }
        turtle.yaw(angle);
        turtle.move(length);
        turtle.pitch(-angle);
        Tree(turtle, length * 0.8, angle, maxHeight, height + 1);
        turtle.pitch(angle * 2.0);
        Tree(turtle, length * 0.8, angle, maxHeight, height + 1);
        turtle.pitch(-angle);
        turtle.move(-length);
        turtle.yaw(-angle);
    }

    static void Tree(
            Turtle2D turtle,
            double length,
            double angle,
            int maxHeight,
            int height) {
        if (height >= maxHeight) {
            return;
        }
        turtle.color(0, 1.0 / (maxHeight - height), 0);
        turtle.move(length);
        turtle.right(angle);
        Tree(turtle, length * 0.8, angle, maxHeight, height + 1);
        turtle.color(0, 1.0 / (maxHeight - height), 0);
        turtle.left(angle * 2.0);
        Tree(turtle, length * 0.8, angle, maxHeight, height + 1);
        turtle.color(1.0 / (maxHeight - height), 0, 0);
        turtle.right(angle);
        turtle.move(-length);
    }

    public static void main(String[] args) {
        try (Turtle3D turtle3d = new Turtle3D(); Turtle2D turtle2d = new Turtle2D();) {
            turtle3d.clear();
            turtle3d.pitch(90);
            Tree(turtle2d, 2, 15, 6, 0);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
