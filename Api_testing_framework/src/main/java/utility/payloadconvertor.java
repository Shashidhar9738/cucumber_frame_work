package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadconvertor {
	
	public static String generatepayload(String filename) throws IOException {
	
	String filepath ="src//test//resources//"+filename;
	return new String(Files.readAllBytes(Paths.get(filepath)));
	}

}
