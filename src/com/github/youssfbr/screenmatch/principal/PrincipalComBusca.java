package com.github.youssfbr.screenmatch.principal;

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
import java.util.Scanner;

public class PrincipalComBusca {
    private static final String API_KEY = System.getenv("API_KEY");
    private static final String HOST = "https://www.omdbapi.com/";

//    public static final String MOVIE = "i=tt3896198";
    //public static final String MOVIE = "t=divertidamente";
//    private static final String URL = HOST + "?" + MOVIE + "&apikey=" + API_KEY;
    // https://www.omdbapi.com/?t=divertidamente&apikey=3a7f4d77

    public static void main(String[] args) throws IOException, InterruptedException {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nDigite um nome de filme para buscar: ");
            String busca = sc.nextLine();

            String URL = HOST + "?t=" + busca + "&apikey=" + API_KEY;
            URL = URL.replace(" " , "+").toLowerCase();

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            final String json = response.body();
            System.out.println(json);

            // final Gson gson = new Gson();
            // final Titulo meuTitulo = gson.fromJson(json , Titulo.class);

            final Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy
                            .UPPER_CAMEL_CASE)
                    .create();

            final TituloOmdb meuTituloOmdb = gson.fromJson(json , TituloOmdb.class);

            System.out.println(meuTituloOmdb.title());
            System.out.println(meuTituloOmdb.year());
            System.out.println(meuTituloOmdb.runtime());

            System.out.println("\nTitulo ja convertido");
            final Titulo meuTitulo = new Titulo(meuTituloOmdb);

            //        System.out.println(meuTitulo.getNome());
            //        System.out.println(meuTitulo.getAnoDeLancamento());
            //        System.out.println(meuTitulo.getDuracaoEmMinutos() + " min");

            System.out.println(meuTitulo);
        }
        catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro:");
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Aconteceu um erro:");
            System.out.println(e.getMessage());
        }
        System.out.println("O programa finalizou corretamente");
    }
}
