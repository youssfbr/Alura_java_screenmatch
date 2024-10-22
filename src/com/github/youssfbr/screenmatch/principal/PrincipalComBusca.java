package com.github.youssfbr.screenmatch.principal;

import com.github.youssfbr.screenmatch.excecoes.ErroDeConversaoDeAnoException;
import com.github.youssfbr.screenmatch.modelos.Titulo;
import com.github.youssfbr.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String HOST = "https://www.omdbapi.com/";


    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String url = "";
        String busca = "";
        final List<Titulo> titulos = new ArrayList<>();

        final Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
        System.out.print("\nDigite um nome de filme para buscar: ");
        busca = sc.nextLine();

        if (busca.equalsIgnoreCase("sair")) break;

        try {
            url = HOST + "?t=" + busca.replace(" " , "+").toLowerCase() + "&apikey=" + API_KEY;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            final String json = response.body();
            System.out.println('\n' + json);

            // final Gson gson = new Gson();
            // final Titulo meuTitulo = gson.fromJson(json , Titulo.class);

            final TituloOmdb meuTituloOmdb = gson.fromJson(json , TituloOmdb.class);

            final Titulo meuTitulo = new Titulo(meuTituloOmdb);

            titulos.add(meuTitulo);

//            final FileWriter escrita = new FileWriter("filmes.txt");
//            escrita.write(meuTitulo.toString());
//            escrita.close();

        }
        catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro:");
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("\nAconteceu um erro:");
            System.out.println("Há um erro na url (endereco web), talvez espaco");
            System.out.println('\n' + url);
            System.out.println('\n' + e.getMessage());
        }
        catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        }
        }
        sc.close();
        System.out.println();
        System.out.println(gson.toJson(titulos));
        System.out.println("\nO programa finalizou corretamente");
    }
}
