package jvreis.webcrawler.filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jvreis.webcrawler.filmes.services.WebcrawlerConfiguration;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		new WebcrawlerConfiguration();
	}

}
