package learningLogic.own;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxParser {

	public static void main(String[] args) throws XMLStreamException, FileNotFoundException, IOException {
		try (InputStream stream = new FileInputStream("src\\employees.xml")) {
			XMLInputFactory inputFactory = XMLInputFactory.newFactory();
			inputFactory.setProperty(XMLInputFactory.IS_COALESCING, true);

			XMLStreamReader reader = inputFactory.createXMLStreamReader(stream);

			while (reader.hasNext()) {
				switch (reader.next()) {
				case XMLStreamConstants.START_ELEMENT:
					System.out.println("Start " + reader.getName());
					for (int i = 0, count = reader.getAttributeCount(); i < count; i++) {
						System.out.println(reader.getAttributeName(i) + "=" + reader.getAttributeValue(i));
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					System.out.println("End " + reader.getName());
					break;
				case XMLStreamConstants.CHARACTERS:
				case XMLStreamConstants.SPACE:
					//System.out.println(reader.getName().getLocalPart());
					String text = reader.getText();
					if (!text.trim().isEmpty()) {
						System.out.println("text: " + text);
					}
					break;
				}
			}
		}
	}

}
