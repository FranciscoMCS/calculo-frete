package com.calculo.frete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreteApplication {

	// Exemplo de requisição HTTP para a API ViaCEP
	public static double[] obterCoordenadasPorCEP(String cep) {
		try {
			// Montar a URL da requisição
			String urlString = "https://viacep.com.br/ws/" + cep + "/json/";
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}

			// Fechar as conexões
			in.close();
			conn.disconnect();

			// Processar o JSON de resposta (dependendo do formato retornado)
			// Isso deve ser ajustado de acordo com a API que você estiver usando.
			// ViaCEP retorna endereço, não coordenadas.
			// Aqui você precisaria de outra API como Google Maps para converter o endereço
			// em coordenadas.

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // Retorna null caso falhe
	}

	public static void main(String[] args) {
		obterCoordenadasPorCEP("04851-280");
		SpringApplication.run(FreteApplication.class, args);
		obterCoordenadasPorCEP("04851-280");
	}

}
