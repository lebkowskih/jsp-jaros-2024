package pl.jaros.Services;

import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;

import java.io.IOException;
import java.util.ArrayList; 


public class XKomScraperService implements WebScrapperInterface {
	String parameter;
	Document doc;

	public XKomScraperService(String word) {
		parameter = word;
	}

	public void getOffers()
	{
		try {
			doc = Jsoup 
					.connect("https://www.x-kom.pl/szukaj?q=" + parameter) 
			        .userAgent("Mozilla")
					.get();
	
			Elements products = doc.select("div[data-name='productCard']");
			for (Element product: products) {
				System.out.println(product.selectFirst("h3").text());
				System.out.println(product.select("span[data-name='productPrice']").text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
