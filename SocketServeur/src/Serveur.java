import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Serveur {

	public static void main(String[] args) {
		new Serveur().demmareServeur();
	}
	public void demmareServeur() {
		ServerSocket serveurSocket;
		ArrayList<String> messageList = new ArrayList<>();
		try {
			serveurSocket = new ServerSocket(5555);
			while (true) {
				{
					System.out.println("Attente de clients : accept()");
					Socket socket = serveurSocket.accept();
					System.out.println("accept() est debloqué : client connecté");
					BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String inputMsg = inputStream.readLine();
					BufferedWriter outputMsg = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					switch (inputMsg) {
					case "ECRIRE":
						String msg = inputStream.readLine();
						messageList.add(msg);
						System.out.println(msg);
						break;
						
					case "LIRE":
						outputMsg.write(messageList.get(messageList.size()-1));
						outputMsg.flush();
						break;
					default:
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
