package learningLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SplitFunction {

	private static final String BACKWARD_SLASH = "\\";

	private static final String FORWARD_SLASH = "/";

	private static final String UPLOAD_PATH = "UPLOAD_PATH";
	private static final String BASE_PATH = "BASE_PATH";

	public static void main(String[] args) {
		String basePath = "LamData";
		Map<String, String> m = computeBaseAndUploadPath(basePath);
		System.out.println("Upload Path is : ");
		System.out.println(m.get("UPLOAD_PATH"));
		System.out.println("Base Path is :");
		System.out.println(m.get("BASE_PATH"));

	}

	public static HashMap<String, String> computeBaseAndUploadPath(String basePath) {
		HashMap<String, String> map = new HashMap<>();
		String clientFolderUploadPath;

		if (basePath.contains(FORWARD_SLASH)) {
			clientFolderUploadPath = basePath.split(FORWARD_SLASH)[0];
			basePath = basePath.replace(clientFolderUploadPath + FORWARD_SLASH, "");
		} else if (basePath.contains(BACKWARD_SLASH)) {
			clientFolderUploadPath = basePath.split(Pattern.quote(BACKWARD_SLASH))[0];
			basePath = basePath.replace(clientFolderUploadPath + BACKWARD_SLASH, "");
		} else {
			clientFolderUploadPath = basePath;
			basePath = basePath.replace(clientFolderUploadPath, "");
		}
		map.put(BASE_PATH, basePath);
		map.put(UPLOAD_PATH, clientFolderUploadPath);
		return map;

	}

}
