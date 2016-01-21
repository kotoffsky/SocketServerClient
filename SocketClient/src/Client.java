import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class Client {
	static Socket sock;
	
	public static void main(String[] args) {
		try {
			sock = new Socket("localhost",5555);
			System.out.println("sock="+sock);
			BufferedWriter outputMsg = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

			//ecriture du message
			outputMsg.write("ECRIRE");
			outputMsg.flush();
			outputMsg.write("Bonjour");
			outputMsg.flush();
			
			//lecture du message
			outputMsg.write("LIRE");
			outputMsg.flush();
			
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String inputMsg = inputStream.readLine();
			System.out.println(inputMsg);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
