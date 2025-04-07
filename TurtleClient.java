import java.io.*;
import java.net.*;
import org.json.*;

public class TurtleClient implements AutoCloseable {
    private Socket soc;
    private PrintWriter out;
    private BufferedReader in;

    public TurtleClient() {
        try {
            this.startConnection("127.0.0.1", 21327);
        } catch (Exception e) {
            String errString = String.format("Failed to connect: %s\n", e);
            System.err.println(errString);
        }

    }

    private void startConnection(String ip, int port) throws Exception {
        try {
            soc = new Socket(ip, port);
            out = new PrintWriter(soc.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        } catch (IOException e) {
            String errString = String.format("Failed to start connection: %s\n", e.toString());
            System.err.println(errString);
            System.exit(1);
            throw e;
        }
    }

    private void stopConnection() throws Exception {
        in.close();
        out.close();
        soc.close();

    }

    @Override
    public void close() {
        try {
            this.stopConnection();
        } catch (Exception e) {
            String errString = String.format("Failed to close connection: %s\n", e.toString());
            System.err.println(errString);
            System.exit(1);
        }
    }

    private String sendMessage(String msg) {
        out.println(msg);
        try {
            String resp = in.readLine();
            return resp;
        } catch (Exception e) {
            System.err.printf("Failed to read response: %s\n", e.toString());
            return null;
        }

    }

    public void sendSingleAction(TurtleAction action) {
        JSONObject obj = new JSONObject();
        obj.put("action", action.toString());
        String resp = sendMessage(obj.toString());
        if (resp != null) {

        }
    }

    public void sendMoveAction(double length) {
        JSONObject obj = new JSONObject();
        obj.put("action", TurtleAction.MOVE.toString());
        obj.put("value", length);
        String resp = sendMessage(obj.toString());
        if (resp != null) {
            System.out.println(resp);
        }
    }

    public void sendRotationAction(TurtleAction rotation, double degrees) {
        JSONObject obj = new JSONObject();
        obj.put("action", rotation.toString());
        obj.put("value", degrees);
        String resp = sendMessage(obj.toString());
        if (resp != null) {
            System.out.println(resp);
        }
    }

    public void sendColorAction(double r, double g, double b) {
        JSONObject obj = new JSONObject();
        obj.put("action", TurtleAction.COLOR.toString());
        JSONObject colorObj = new JSONObject();
        colorObj.put("r", r);
        colorObj.put("g", g);
        colorObj.put("b", b);
        obj.put("color", colorObj);
        String resp = sendMessage(obj.toString());
        if (resp != null) {
            System.out.println(resp);
        }
    }
}