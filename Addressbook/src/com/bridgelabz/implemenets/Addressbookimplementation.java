package com.bridgelabz.implemenets;

public class Addressbookimplementation implements Addressbookinterface {
public void createAddress() {
	JSONParser jsonparser=new JSONParser();
	try {
		FileReader reader= new FileReader("addresbook.json");
		Object obj=JSONParser.parse(reader);
		JSONArray addressList=(JSONArray) obj;
		System.out.println("====>>>"+addressList);
		System.out.println(obj);
addressList.foreach(ads->parseAddressObject((JSONObject)ads))
	}
	catch (Exception e) {
		e.printStackTrace();
		
	}
}
private void  parseAddressObject(JSONObject ads) {
	JSONObject addressObject=(JSONObject) ads.get("address");
	String name=(String) addressObject.get("name");
	System.out.println(name);
	
	JSONObject state=(JSONObject) ads.get("state");
	String name=(String) addressObject.get("state");
	System.out.println(state);
	
	JSONObject district=(JSONObject) ads.get("district");
	String name=(String) addressObject.get("district");
	System.out.println(district);
	
	JSONObject area =(JSONObject) ads.get("area");
	String name=(String) addressObject.get("area");
	System.out.println(area);
	
	JSONObject landmark=(JSONObject) ads.get("landmark");
	String name=(String) addressObject.get("landmark");
	System.out.println(landmark);
}
}
}
}
}
}
