public class Main {
    public static void main(String[] args) {
        try (Turtle3D turtle3d = new Turtle3D(); Turtle2D turtle2d = new Turtle2D();) {
            turtle3d.clear();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
