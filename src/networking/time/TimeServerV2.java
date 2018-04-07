package networking.time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServerV2 {
	
	public static final int MAX_REQUESTS = 3;

	public static void main(String[] args) {
		
		try (ServerSocket ss = new ServerSocket(1111)) {
			
		    int counter = 0;
			
		    while(true) {
				
		        if(++counter > MAX_REQUESTS) {
					System.out.println("reached "+ MAX_REQUESTS +
							" connection requests -> quitting now...");
					break;
				}
		        
		        System.out.println("waiting for client connections...");
				
		        try(
					Socket client = ss.accept();
					BufferedWriter bw = new BufferedWriter(
								new OutputStreamWriter(
										client.getOutputStream()));
				) {
					System.out.println("client "+counter+" connected");
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
		
		System.out.println("exiting the time server");
		
	}
	
}
