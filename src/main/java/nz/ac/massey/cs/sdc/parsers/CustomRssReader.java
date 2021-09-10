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
		
			File file = new File("rss_source.xml");
			Rss source = (Rss) parser.unmarshal(file);
			RssChannel channel = source.getChannel();
			
			java.util.List<RssItem> rss_items = null;
			
			// Get rss items
			rss_items = channel.getItem();
			
			// Print title, link, & description of each rss item
			for (RssItem rsi : rss_items)
			{
				java.util.List<Object> rsi_items = null;
				rsi_items =  rsi.getTitleOrDescriptionOrLink();
				
				for (Object obj : rsi_items)
				{
					
					JAXBElement<?> obj_jaxb = (JAXBElement<?>) obj;
					String itemType = obj_jaxb.getName().getLocalPart();
					if (!itemType.equals("title") && !itemType.equals("link") && !itemType.equals("description"))
					{
						continue;
					}
					String itemValue =  obj_jaxb.getValue().toString();

					System.out.print(itemType.toString());	
					System.out.println(": " + itemValue.toString());	
				}
				System.out.println("");
			}
					
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
