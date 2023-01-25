package learningLogic;

import java.util.ArrayList;
import java.util.List;

public class RetailAll {

	public static void main(String[] args) {
		List<String> data = new ArrayList<>();
		data.add("Nikh''il");
		data.add("test");

		List<String> filePathsFromHeaderSearch = new ArrayList<>();
		filePathsFromHeaderSearch.add("Nikh'il");

		List<String> retainedClientFilePaths = new ArrayList<>(data);
		retainedClientFilePaths.retainAll(filePathsFromHeaderSearch);

		List<String> filesNotUserAccessible = new ArrayList<>(data);
		filesNotUserAccessible.removeAll(filePathsFromHeaderSearch);

		System.out.println(retainedClientFilePaths);
		System.out.println(filesNotUserAccessible);

	}

}
