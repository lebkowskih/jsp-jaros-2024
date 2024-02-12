package pl.jaros.Services;

import org.jsoup.*; 
import org.jsoup.nodes.*; 
import org.jsoup.select.*;

import pl.jaros.Models.Product;
import pl.jaros.Models.ProductDAO;

import java.io.IOException;
import java.sql.SQLException;

public class XKomScraperService implements WebScraperInterface {
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
	        ProductDAO productDAO = new ProductDAO();

			for (Element product: products) {
				String name = product.selectFirst("h3").text();
				String price = product.select("span[data-name='productPrice']").text();

				Product productToAdd = new Product(name, price, "X-KOM");
				productDAO.insert(productToAdd);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
