import java.io.*;
import java.net.*;

public class ShakespeareClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server. Waiting for sonnet...");

            // Получение соннета от сервера
            StringBuilder sonnet = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sonnet.append(line).append("\n");
            }

            System.out.println("Received sonnet:\n" + sonnet);

        } catch (IOException e) {
            System.err.println("Client exception: " + e.getMessage());
        }
    }
}

