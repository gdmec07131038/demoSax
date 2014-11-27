package cn.gdmec.s07131038.demo_sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	private List<User> users;
	private User user;
	private String content;
	
	public List<User> getUsers(){
		return users;
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		content=new String(ch,start,length);
	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if("name".equals(localName)){
			user.setName(content);
		}
		if("password".equals(localName)){
			user.setPassword(content);
		}
		if("user".equals(localName)){
			users.add(user);
			user=null;
		}
	}

	@Override
	public void startDocument() throws SAXException {
		this.users=new ArrayList<User>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("user".equals(localName)){
			user=new User();
			user.setUid(Integer.parseInt(attributes.getValue("id")));
		}
	}
	
}
