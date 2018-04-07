package networking.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DemoURLV1 {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			// a few different constructor overloadings e.g.
			URL myUrl1 = new URL("https://en.wikipedia.org/wiki/OSI_model");

			// open stream for reading
			br = new BufferedReader(new InputStreamReader(myUrl1.openStream()));

			// read form the url stream line by line
			// and print the HTML to the console...
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
