package jvreis.webcrawler.filmes.services;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import jvreis.webcrawler.filmes.classes.Filmes;

public class Webcrawler {
	// retorna uma lista de Linhas (olhar classe Dados)
	public static Filmes search() {
		// 1 - URL do site a ser acessado
		String link = ("https://www.baixarfilmetorrent.com/"); // WebScraping

		Document documento = null;
		try {
			// 2 - Conectando e obtendo uma cópia do html inteiro da página
			documento = Jsoup.connect(link).get();
		} catch (Exception e) {
			System.out.println("Site Indisponível ou falha na requisição!");
		}

		// 3 - Obtendo primeiro elemento da classe dada
		Element listagem = documento.getElementsByClass("listagem").first();

		// 4 - Criando uma lista de todos os elementos da classe dada
		List<Element> filmes = listagem.getElementsByClass("item");
		
		// 5 - Criando lista de Titulos e Links
//--------------------------------------------------------------------	
		List<Element> Elementos_tag_a = new ArrayList<>();
		Filmes dados = new Filmes();
		
		// Adicionando à lista os elemento de tag a. (possuem o título do filme)
		for (Element elemento : filmes) {
			Elementos_tag_a.add(elemento.getElementsByTag("a").first());
			dados.titulos.add(elemento.getElementsByTag("a").first().text());
		}

		// Adicionando à lista os elemento de atributos href, que estão na lista de elementos de tag a. (possuem a URL)
		for (Element elemento : Elementos_tag_a) {
			dados.links.add(elemento.attr("href"));
		}
//--------------------------------------------------------------------		
		return dados;
	}
}