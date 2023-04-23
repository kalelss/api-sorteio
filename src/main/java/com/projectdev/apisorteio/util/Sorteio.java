package com.projectdev.apisorteio.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sorteio {
	public static void main(String[] args) {
		bilhetesSorteados();
	}
	@Scheduled(cron = "0 30 19 * * 6") //Executa ás 19h30m todos os sábados.
	public static List<Integer> bilhetesSorteados() {
		try {
			URL url = new URL("https://supersena.com.br/federal-loteria-resultado-hoje");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				Document htmlDocument = Jsoup.parse(connection.getInputStream(), null, url.toString());
				Element resultTable = htmlDocument.select("div.table-responsive table").first();
				Elements results = resultTable.select("tbody tr");
				List<Integer> bilhetesSorteados = new ArrayList<>();

				for (Element result : results) {
					bilhetesSorteados.add(Integer.parseInt(result.select("td:nth-child(2)").text()));
				}

				System.out.println(bilhetesSorteados);
				return bilhetesSorteados;
			} else {
				throw new RuntimeException(
						"Erro ao acessar a página. Código de resposta: " + connection.getResponseCode());
			}
		} catch (IOException e) {
			throw new RuntimeException("Erro ao acessar a página. Mensagem: " + e.getMessage());
		}
	}
}