package com.muaki.snippets;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

public class ParseadorSax extends Activity
{
	 String externalStoragePath;
	
	@Override 
	public void onCreate(Bundle icicle) { 
	  super.onCreate(icicle); 
	  setContentView(R.layout.activity_snippets); 
	  
	
	  // start the parser and get back the Data object, which you can do whatever you want with 
	  Data data = _parseXml(); 
	  
	  
	  TextView tv = new TextView(this);
	  tv.setText(""+data.sectionId);
	  setContentView(tv);
	 
	  
	  
	  
	} 
	 
	private Data _parseXml() { 
	  Data data = null; 
	 
	  // sax stuff 
	  try { 
		  
		  externalStoragePath = Environment.getExternalStorageDirectory()
	                .getAbsolutePath();
	                
	                
	    SAXParserFactory spf = SAXParserFactory.newInstance(); 
	    SAXParser sp = spf.newSAXParser(); 
	 
	    XMLReader xr = sp.getXMLReader(); 
	 
	    DataHandler dataHandler = new DataHandler(); 
	    xr.setContentHandler(dataHandler); 
	 
	    xr.parse(new InputSource(new FileInputStream(externalStoragePath+"/muakibooks/contodavaca/landscape/conto2.xml"))); 
	 
	    data = dataHandler.getData(); 
	    
	    
	    
	    
	  } catch(ParserConfigurationException pce) { 
	    Log.e("SAX XML", "sax parse error", pce); 
	  } catch(SAXException se) { 
	    Log.e("SAX XML", "sax error", se); 
	  } catch(IOException ioe) { 
	    Log.e("SAX XML", "sax parse io error", ioe); 
	  } 
	 
	  return data; 
	} 
	
	
	

}
