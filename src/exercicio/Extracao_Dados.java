package exercicio;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Extracao_Dados {
	public static void main(String[] args) {
		try {
			File arquivoXML = new File("passageiros.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documento = dBuilder.parse(arquivoXML);
            documento.getDocumentElement().normalize();
            NodeList lista = documento.getElementsByTagName("passageiro");
            int numPassageiros = lista.getLength();
            System.out.println("Número de passageiros: " + numPassageiros);
            System.out.println();
            
            for (int i = 0; i < lista.getLength(); i++) {
                Node node = lista.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String origem = element.getElementsByTagName("origem").item(0).getTextContent();
                    String destino = element.getElementsByTagName("destino").item(0).getTextContent();

                    System.out.println("Passageiro " + (i + 1));
                    System.out.println("Origem: " + origem);
                    System.out.println("Destino: " + destino);
                    System.out.println();
                }
            }
		}
		
		catch(Exception e) {
			System.out.println("Passageiro não encontrado");
		}
	}
}
