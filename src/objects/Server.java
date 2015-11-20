package objects;


import java.rmi.Naming;
public class Server {
    private String url;
    public Server(String url) {
        this.url = url;
        try {
            RegisterInt b = new RegisterRMI();
            Naming.rebind(url, b);
            System.out.println("Server running...");
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

    // run the program using
    // java Server <host> <port>

    public static void main(String args[]) {
        String url = new String("rmi://" + args[0] + ":" + args[1] + "/Service");
        new Server(url);
    }
}