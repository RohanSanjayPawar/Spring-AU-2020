package com.rohan.accolite.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	private List<Players> playerList = null;
	private Players player = null;
	private StringBuilder data = null;

	// getter method for employee list
	public List<Players> getEmpList() {
		return playerList;
	}
	
	boolean bID = false;
	boolean bAge = false;
	boolean bFirstName = false;
	boolean bLastName = false;
	boolean bGender = false;
	boolean bNationality = false;
	boolean bClub = false;
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("player")) {
			player = new Players();
			if (playerList == null)
				playerList = new ArrayList<>();
		} else if (qName.equalsIgnoreCase("id")) {
			bID = true;
		} else if (qName.equalsIgnoreCase("first_name")) {
			bFirstName = true;
		} else if (qName.equalsIgnoreCase("last_name")) {
			bLastName = true;
		} else if (qName.equalsIgnoreCase("age")) {
			bAge = true;
		} else if (qName.equalsIgnoreCase("club")) {
			bClub = true;
		} else if (qName.equalsIgnoreCase("nationality")) {
			bNationality = true;
		}
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (bID) {
			player.setId(Integer.parseInt(data.toString()));
			bID = false;
		} else if (bAge) {
			player.setAge(Integer.parseInt(data.toString()));
			bAge = false;
		} else if (bFirstName) {
			player.setFirstname(data.toString());
			bFirstName = false;
		} else if (bLastName) {
			player.setLastname(data.toString());
			bLastName = false;
		} else if (bNationality) {
			player.setNationality(data.toString());
			bNationality = false;
		} else if (bClub) {
			player.setClub(data.toString());
			bClub = false;
		}
		
		if (qName.equalsIgnoreCase("player")) {
			// add Employee object to list
			playerList.add(player);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}
