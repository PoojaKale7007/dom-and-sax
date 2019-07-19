package com.jbk;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CreateXml {
public static void main(String[] args) throws Exception {
	DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();
	DocumentBuilder b=f.newDocumentBuilder();
	Document doc=b.newDocument();
	
	Element rootele=doc.createElement("students");
	Element studenttele=doc.createElement("student");
	Element nameele=doc.createElement("name");
	Element emailele=doc.createElement("email");
	Element mobileele=doc.createElement("mobile");
	Element addele=doc.createElement("address");
	
	 Text t1=doc.createTextNode("pooja");
	 Text t2=doc.createTextNode("poojikale@gmail.com");
	 Text t3=doc.createTextNode("12345");
	 Text t4=doc.createTextNode("nagpur");
	 
	 studenttele.appendChild(t1);
	 emailele.appendChild(t2);
	 mobileele.appendChild(t3);
	 addele.appendChild(t4);
	 
	 studenttele.appendChild(nameele);
	 studenttele.appendChild(emailele);
	 studenttele.appendChild(mobileele);
	 studenttele.appendChild(addele);
	 
	 rootele.appendChild(studenttele);
	 doc.appendChild(rootele);
	 Transformer t=TransformerFactory.newInstance().newTransformer();
	 t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("E:\\File.xml")));
	System.out.println("XML file generated");
	
}
}

