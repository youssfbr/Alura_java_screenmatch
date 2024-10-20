package com.github.youssfbr.screenmatch.principal;

import com.github.youssfbr.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalComBusca {
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String HOST = "https://www.omdbapi.com/";
    private static final String URL = HOST + "?i=tt3896198&apikey=" + API_KEY;

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        final String json = response.body();
        System.out.println(json);

        final Gson gson = new Gson();
        final Titulo meuTitulo = gson.fromJson(json , Titulo.class);
        System.out.println(meuTitulo.getNome());
        System.out.println(meuTitulo.getAnoDeLancamento());
    }
}
