package networking.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {

	public static void main(String[] args) {

		System.out.println("client connecting to timeserver...");
		
		try (Socket s = new Socket("localhost", 1111);
			 BufferedReader br = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
		) {
			
			String line = br.readLine();
			if(line!=null) {
			    System.out.println(line);
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("exiting the time client");

	}

}
