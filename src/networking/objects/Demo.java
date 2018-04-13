package networking.objects;

import java.util.List;

public class Demo {

	public static void main(String[] args) {

		try {
			String filePath = "data/csv/addressBook1.csv";
			List<Address> addresses = AddressManager.loadFromCsv(filePath);
			System.out.println("loaded "+addresses.size() + " address(es) from CSV file "+filePath);
			System.out.println(addresses);
		} catch (AddressLoadException e) {
			e.printStackTrace();
		}
			
	}

}
