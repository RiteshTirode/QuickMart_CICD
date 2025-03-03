package quickmart.ecommerce.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonDataReader {

	
	public static List<HashMap<String, String>> readJsonToHashMap(String path) throws IOException {
		String jsonData=FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> jsonToMapObject=mapper.readValue(jsonData, new com.fasterxml.jackson.core.type.TypeReference<List<HashMap<String,String>>>() {});
		return jsonToMapObject;
	}
}
