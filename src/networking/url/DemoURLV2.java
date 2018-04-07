package networking.url;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DemoURLV2 {

	public static void main(String[] args) {

		try (// open stream for reading using BufferedReader
			 BufferedReader br = new BufferedReader(new InputStreamReader(
				new URL("https://en.wikipedia.org/wiki/OSI_model").openStream()));

			// using FileWriter for writing to output file
			// make sure that the output path exists otherwise
			// create the folder structure first
			FileWriter fw = new FileWriter("data/output/local_osi.html");
		) {
			// read form the url stream line by line
			// and write to the file writer
			String line;
			while ((line = br.readLine()) != null) {
				fw.write(line + System.lineSeparator());
			}
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
