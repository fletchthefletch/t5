package nz.ac.massey.cs.sdc.parsers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class CustomRssReader {


	public static void main(String[] args) {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance( "nz.ac.massey.cs.sdc.parsers" );
			
			Unmarshaller parser;
		
			parser = jc.createUnmarshaller();
		
			File file = new File("nzhrsscid_000000005.xml");
	    
			JAXBElement mail = (JAXBElement) parser.unmarshal(file);
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        


	}

}
