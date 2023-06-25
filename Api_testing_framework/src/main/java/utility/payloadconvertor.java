package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadconvertor {
	
	public static String generatepayload(String filename) throws IOException {
	
	String filepath ="C://Users//shash//Documents//workspace-spring-tool-suite-4-4.19.0.RELEASE//Api_testing_framework//src/test//resources//"+filename;
	return new String(Files.readAllBytes(Paths.get(filepath)));
	}

}
