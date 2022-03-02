package jvreis.webcrawler.filmes.classes;

import java.util.ArrayList;
import java.util.List;

public class Filmes {
	public List<String> titulos = new ArrayList<>();
	public List<String> links = new ArrayList<>();
	
    public Filmes(List<String> titulos, List<String> links) {
    	this.titulos = titulos;
    	this.links = links;

    }

	public Filmes() {
    	
    }

	public List<String> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<String> titulos) {
		this.titulos = titulos;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

}

