package it.develhope.shoppyz.repository;

import com.google.gson.Gson;
import it.develhope.shoppyz.entity.Account;
import com.google.gson.JsonObject;

import javax.xml.crypto.Data;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
    HttpResponse response = null;

    @Override
    public Account getAccount(int id) {
        // get account
        try {
            //endpoint provvisorio
            String endPoint = "https://gorest.co.in/public/v2/users/"+id;
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().
                    uri(uri).
                    build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body());
        //estrapolo il contenuto della response e lo trasformo in classe Account
        String responseString=response.body().toString();
        Account returnAcc = new Gson().fromJson(responseString, Account.class);

        return returnAcc;

}


    @Override
    public void deleteAccount(int id) {
        //delete account where id is equal to (delete)
        try {
            String endPoint = "https://gorest.co.in/public/v2/users/"+id;
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder()
                    .DELETE()
                    .uri(uri)
                    .header("Authorization", "Bearer 362916d01206eee14ed5b0b6db6127a8cb9ad2692bf197e086c0b4fbfdc5a058").build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }

    @Override
    public void saveAccount(Account account) {
        //save this account in the database (post)
        Gson json= new Gson();
        json.toJson(account);
        String jsonString = json.toString();

        try {
            String endPoint = "https://gorest.co.in/public/v2/users";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer 362916d01206eee14ed5b0b6db6127a8cb9ad2692bf197e086c0b4fbfdc5a058")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body());

    }

    @Override
    public void updateAccount(int id,Account account) {
        //modify the account (put)
        Gson json= new Gson();
        json.toJson(account);
        String jsonString = json.toString();

        try {
            String endPoint = "https://gorest.co.in/public/v2/users/"+id;
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept","application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer 362916d01206eee14ed5b0b6db6127a8cb9ad2692bf197e086c0b4fbfdc5a058")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body());

    }

    @Override
    public List<Account> getAccounts(List<Account> account) {
        //gets a list of all accounts in the db
        return null;
    }
}
