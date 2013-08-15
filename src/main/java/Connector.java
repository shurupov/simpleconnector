import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: Eugene Shurupov
 * Date: 15.08.13
 * Time: 12:30
 */
public class Connector {

    public static void main(String[] args) throws IOException {

        String host = args[0];
        int port = Integer.valueOf(args[1]);
        int count = Integer.valueOf(args[2]);

        List<Socket> sockets = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            try {
            sockets.add(new Socket(host, port));
            System.out.println("Socket " + i + " created");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Enter smth");
        String smth = scanner.nextLine();

        for (Socket socket : sockets) {
            socket.close();
        }

        System.out.println(smth);

    }

}
