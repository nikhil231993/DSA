package learningLogic;

public class SplitFunction {

	public static void main(String[] args) {
		String basePath = "LamData";
		String clientFolderUploadPath = basePath.split("/")[0];
		basePath = basePath.replace(clientFolderUploadPath, "");
		System.out.println(clientFolderUploadPath);
		System.out.println(basePath);

	}

}
