package pl.jaros.Services;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pl.jaros.Models.Product;
import pl.jaros.Models.ProductDAO;


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
	        ProductDAO productDAO = new ProductDAO();

			for (Element product: products) {
				String name = product.selectFirst(".productLink").attr("title");
				String price = product.selectFirst(".price-new").text();
				
				Product productToAdd = new Product(name, price, "Morele");
				productDAO.insert(productToAdd);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}

