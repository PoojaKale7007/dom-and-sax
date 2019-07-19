package com.jbk;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXml {
	public static void main(String[] args) {
		try{
			File fxmlFile=new File("E:/jbk work/DomAndSax/Sax.XML");
			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
			Document doc=dBuilder.parse(fxmlFile);
			System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
			NodeList nList=doc.getElementsByTagName("staff");
			System.out.println("_________"+nList.getLength());
			for(int temp=0;temp<nList.getLength();temp++){
				Node nNode=nList.item(temp);
				System.out.println("\ncurrent element:"+nNode.getNodeName());
				if(nNode.getNodeType()==Node.ELEMENT_NODE){
					Element eElement=(Element) nNode;
					System.out.println("staff id:"+eElement.getAttribute("id"));
					System.out.println("firstname:"+eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("lastname:"+eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("nickname:"+eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("salary:"+eElement.getElementsByTagName("salary").item(0).getTextContent());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
