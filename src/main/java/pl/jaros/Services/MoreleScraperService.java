package pl.jaros.Services;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MoreleScraperService implements WebScraperInterface {
	Document doc;
	String parameter;

	public MoreleScraperService(String word)
	{
		parameter = word;
	}

	public void getOffers()
	{
		try {
			doc = Jsoup 
					.connect("https://www.morele.net/wyszukiwarka/?q=" + parameter) 
			        .userAgent("Mozilla")
					.get();
	
			
			Elements products = doc.select(".card");

			for (Element product: products) {
				System.out.println(product.selectFirst(".productLink").attr("title"));
				System.out.println(product.selectFirst(".price-new").text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

