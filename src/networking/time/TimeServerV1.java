package networking.time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServerV1 {
	
	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(1111)) {
			
			while(true) {
				
				System.out.println("waiting for client connections...");
				
				try(Socket client = ss.accept();	
					BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(client.getOutputStream()));
				) {
					System.out.println("handling the client");
					LocalDateTime datetime = LocalDateTime.now();
					System.out.println("  <-- sending local date time "+datetime);
					bw.write(datetime.toString());
					bw.newLine();
					bw.flush();				
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
