import java.io.*;
import java.net.*;
import java.util.*;

public class ShakespeareServer {
    private static final int PORT = 12345;
    private static final String FILE_PATH = "shakespeare_sonnets.txt";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    // Чтение файла с соннетами
                    List<String> sonnets = readSonnetFile(FILE_PATH);
                    if (sonnets.isEmpty()) {
                        out.println("No sonnets found in the file.");
                        continue;
                    }

                    // Выбор случайного соннета
                    Random random = new Random();
                    String randomSonnet = sonnets.get(random.nextInt(sonnets.size()));

                    // Отправка соннета клиенту
                    out.println(randomSonnet);

                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }

    private static List<String> readSonnetFile(String filePath) throws IOException {
        List<String> sonnets = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder currentSonnet = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    if (currentSonnet.length() > 0) {
                        sonnets.add(currentSonnet.toString());
                        currentSonnet = new StringBuilder();
                    }
                } else {
                    currentSonnet.append(line).append("\n");
                }
            }
            if (currentSonnet.length() > 0) {
                sonnets.add(currentSonnet.toString());
            }
        }
        return sonnets;
    }
}
