package com.rohan.accolite.xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLParserSax {
	public static void main(String[] args) {
	    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    try {
	        SAXParser saxParser = saxParserFactory.newSAXParser();
	        Handler handler = new Handler();
	        saxParser.parse(new File("players.xml"), handler);
	        List<Players> playerList = handler.getEmpList();
	        for(int i=0;i<playerList.size();i++) {
	            System.out.println(playerList.get(i));
	        	System.out.println("=================================");
	        }
	    } catch (ParserConfigurationException | SAXException | IOException e) {
	        e.printStackTrace();
	    }
	}
}
