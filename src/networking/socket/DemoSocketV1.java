package networking.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;

public class DemoSocketV1 {
	
	public static void main(String[] args) {
		
		Socket s = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		//using the try catch finally construct
		try {
			s = new Socket("news.orf.at", 80);
			
			bw = new BufferedWriter(
						new OutputStreamWriter(s.getOutputStream())
					);
			
			//sending a valid HTTP 1.1 GET request
			bw.write("GET / HTTP/1.1\r\nHost: news.orf.at\r\n\r\n");
			bw.flush();
						
			//open stream for reading
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			//reading line by line and printing to console
			String line;
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(s != null)
					s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}

}
