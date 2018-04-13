package networking.objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressManager {

	public static List<Address> loadFromCsv(String path)
												throws AddressLoadException {
		
		List<Address> addresses = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {	
			String record;
			while((record = br.readLine()) != null) {
				String[] columns = record.split(";");
				
				if(record.equals("")) {
					continue;
				}
				
				if(columns.length != 4) {
					throw new AddressCsvFormatException(
							"error: invalid CSV record ["+ record +"]"
					);
				}		
				addresses.add(new Address(columns[0], columns[1], columns[2], columns[3]));				
			}
			return addresses;
		} catch (IOException e) {
			throw new AddressLoadException("error: failed to load from CSV",e);
		}
		
	}
	
}
