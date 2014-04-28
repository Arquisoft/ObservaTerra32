package clientejson;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ClienteJSON {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://data.undp.org/resource/e6xu-b22v.xml");
		URLConnection conexion = url.openConnection();
		/*
		 * BufferedReader lector = new BufferedReader(new
		 * InputStreamReader(conexion.getInputStream())); String linea;
		 * StringBuilder sb = new StringBuilder(); while ((linea =
		 * lector.readLine()) != null) { sb.append(linea); }
		 * 
		 * lector.close(); String json = sb.toString();
		 * 
		 * System.out.println(json);
		 */
		DocumentBuilder db = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		InputStream is = conexion.getInputStream();
		Document docXML = db.parse(is);
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression xpathRegistros = xpath.compile("/response/row/row");
		XPathExpression xpathNombre = xpath.compile("name/text()");
		XPathExpression xpathPopulation = xpath
				.compile("_2012_population/text()");
		NodeList registros = (NodeList) xpathRegistros.evaluate(docXML,
				XPathConstants.NODESET);
		for (int i = 0; i < registros.getLength(); i++) {
			String nombre = xpathNombre.evaluate(registros.item(i));
			String population = xpathPopulation.evaluate(registros.item(i));

			System.out.println(nombre + " " + population);

		}
	}
}
