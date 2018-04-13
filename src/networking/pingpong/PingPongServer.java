package networking.pingpong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(3333)) {
        	
			while(true) {
				System.out.println("waiting for connections");
				Socket client = ss.accept();
				System.out.println("client connected");
				processClient(client);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void processClient(Socket client) {
		
		try (
				BufferedReader br = new BufferedReader(
						new InputStreamReader(client.getInputStream()));

				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));
				) { 
						
			String line; 
			while((line = br.readLine()) != null) {
				System.out.println(" --> received: "+line);
				switch(line.toLowerCase()) {
					case "ping":
						System.out.println(" <-- sending pong response");
						bw.write("pong");
						break;
					case "pong":
						System.out.println(" <-- sending ping response");
						bw.write("ping");
						break;
					default: 
						System.out.println("error: "+line+" is invalid command!");
						System.out.println(" <-- sending error response");
						bw.write("error");
				}
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
