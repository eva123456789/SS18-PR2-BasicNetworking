package networking.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class DemoSocketV2 {
	
	public static void main(String[] args) {
		
		//using the try with resources construct
		try (
			Socket s = new Socket("news.orf.at",80);
			
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(s.getOutputStream()));
				
			BufferedReader br = 
				new BufferedReader(
					new InputStreamReader(s.getInputStream()));
		) {	
			//sending a valid HTTP 1.1 GET request
			bw.write("GET / HTTP/1.1\r\nHost: news.orf.at\r\n\r\n");
			bw.flush();
						
			//reading line by line and printing to console
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
