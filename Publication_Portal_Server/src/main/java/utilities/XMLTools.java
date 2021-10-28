package utilities;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLTools {
	public static StringBuilder getReqBodyAsString(InputStream reqReader) throws IOException {
		BufferedReader reqBuffer=new BufferedReader(new InputStreamReader(reqReader));
		StringBuilder stringBuilder = new StringBuilder("");
		String temp=reqBuffer.readLine();
		while(temp != null && !temp.equals("")){
			stringBuilder.append(temp);
			temp=reqBuffer.readLine();
		}
		return stringBuilder;
		}
	public static XMLDocument parseXML(InputStream reqReader) throws Exception {
		StringBuilder bodyString=getReqBodyAsString(reqReader);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bodyString.toString().getBytes("UTF-8"));
		// System.out.println(bodyString);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document=builder.parse(byteArrayInputStream);
		document.getDocumentElement().normalize();
		return new XMLDocument(document.getDocumentElement());
		}

}
