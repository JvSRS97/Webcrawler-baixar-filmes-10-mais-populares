package jvreis.webcrawler.filmes.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import jvreis.webcrawler.filmes.classes.Filmes;

public class WebcrawlerConfiguration {
	private String path = "C:\\Users\\jvict\\eclipse-workspace\\webcrawler.filmes\\Webcrawler-10-Filmes-Populares.txt";
	private String path_2 = "C:\\Users\\jvict\\eclipse-workspace\\webcrawler.filmes\\Webcrawler-Filmes-Populares.txt";
	
	private OutputStreamWriter writer;// para escrever no arquivo

	public WebcrawlerConfiguration() {// construtor que chamar� m�todo
		executar();// m�todo para executar scraping
	}

	// ------------------------------------------------------------------
	private void escreverFile(String texto, String caminho) {
		try {
			File arquivo = new File(caminho);
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			writer = new OutputStreamWriter(new FileOutputStream(arquivo));
			writer.write(texto);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ------------------------------------------------------------------
	private void executar() {
		Filmes filmes;
		filmes = new Filmes();

		filmes = Webcrawler.search();

		imprimir_lista_parcial(filmes,10);
		escreverFile(list_to_txt_parcial(filmes,10), path);
		
		//imprimir_lista_completa(filmes);
		escreverFile(list_to_txt_completa(filmes), path_2);
	}

	private void imprimir_lista_parcial(Filmes filmes,int numero) {
		int i;
		String titulo, link;
		for (i = 0; i < numero; i++) {
			titulo = filmes.titulos.get(i);
			link = filmes.links.get(i);
			
			System.out.println("Numero: "+(i+1)+"\nTitulo: "+titulo + "\nLink: " + link + "\n");
		}
	}
	private void imprimir_lista_completa(Filmes filmes) {
		int i;
		String titulo, link;
		for (i = 0; i < filmes.titulos.size(); i++) {
			titulo = filmes.titulos.get(i);
			link = filmes.links.get(i);
			
			System.out.println("Numero: "+(i+1)+"\nTitulo: "+titulo + "\nLink: " + link + "\n");
		}
	}

	private String list_to_txt_completa(Filmes filmes) {// convertendo lista em texto numa única variável
		String texto = "";
		int i;
		String titulo, link;
		for (i = 0; i < filmes.titulos.size(); i++) {
			titulo = filmes.titulos.get(i);
			link = filmes.links.get(i);

			texto += "Numero: "+(i+1)+"\nTitulo: "+titulo + "\nLink: " + link + "\n\n";
		}
		return texto;
	}
	private String list_to_txt_parcial(Filmes filmes, int numero) {// convertendo lista em texto numa única variável
		String texto = "";
		int i;
		String titulo, link;
		for (i = 0; i < numero; i++) {
			titulo = filmes.titulos.get(i);
			link = filmes.links.get(i);

			texto += "Numero: "+(i+1)+"\nTitulo: "+titulo + "\nLink: " + link + "\n\n";
		}
		return texto;
	}
}
