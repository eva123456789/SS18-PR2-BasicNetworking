package networking.pingpong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class PingPongClient {

	public static void main(String[] args) {

		try (
				Socket s = new Socket("localhost",3333);
				
				//socket I/O streams
				BufferedReader br = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(s.getOutputStream()));	
				
				//console stdin
				BufferedReader stdin = new BufferedReader(
						new InputStreamReader(System.in));	
				
			) {

			System.out.print("prompt> ");
			String cmd;
			while((cmd = stdin.readLine())!=null) {
				if("quit".equalsIgnoreCase(cmd)) {
					break;
				}
				System.out.println(" <-- sending request: "+cmd);
				bw.write(cmd);
				bw.newLine();
				bw.flush();
				System.out.println(" --> received response: " + br.readLine());
				System.out.print("prompt> ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("exiting the ping-pong client");

	}
}
