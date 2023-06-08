/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal.Api;
import ProyectoFinal.Api.Resources.Task;
import ProyectoFinal.Api.Resources.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.net.URI;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

/**
 *
 * @author juanhernandez
 */
public class ApiClient {
    private static final String API_URL = "http://localhost:8080/";
    private HttpClient httpClient;
    public ApiClient() {
        httpClient = HttpClients.createDefault();
    }

    public int createUser(String username, String password) {
        try {
            URI uri = new URIBuilder(API_URL + "user")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .build();

            HttpPost postRequest = new HttpPost(uri);
            postRequest.setHeader("Accept", "application/json");

            HttpResponse response = httpClient.execute(postRequest);
            String responseBody = EntityUtils.toString(response.getEntity());

            // Procesar la respuesta JSON
            System.out.println(responseBody);
            return response.getStatusLine().getStatusCode();
            // Actualizar la interfaz de usuario de Swing según la respuesta obtenida
            // ...
        } catch (Exception ex) {
            ex.printStackTrace();
            return 404;
        }
    }
    
    public User existUser(String username) {
        try {
            
        URI uri = new URIBuilder(API_URL + "user")
        .setParameter("username", username)
        .build();
        HttpGet getRequest = new HttpGet(uri);
        getRequest.setHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(getRequest);
        String responseBody = EntityUtils.toString(response.getEntity());

        // Procesar la respuesta JSON
        if (response.getStatusLine().getStatusCode() == 200) {
            // Si la respuesta es exitosa, crea un objeto User a partir del JSON y devuélvelo
            User user = parseUserFromJson(responseBody);
            return user;
        } else {
            // En caso de error, lanza una excepción o devuelve null
            System.out.println("Error al obtener el usuario");
            return null;
        }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public Task updateTask(int id, String title, String description, boolean status) {
        try {
            URI uri = new URIBuilder(API_URL + "task")
            .build();
            Task updatedTask = new Task();
            //create task
            updatedTask.setTitle(title);
            updatedTask.setId(id);
            updatedTask.setCompleted(status);
            updatedTask.setDescription(description);
            
            //generar JSON
            Gson gson = new Gson();
            String requestBodyJson = gson.toJson(updatedTask);
            HttpPut putRequest = new HttpPut(uri);
            putRequest.setHeader("Accept", "application/json");
            
            //parsearlo para mandarlo como body
            StringEntity stringEntity = new StringEntity(requestBodyJson, ContentType.APPLICATION_JSON);
            
            putRequest.setEntity(stringEntity);
            
            HttpResponse response = httpClient.execute(putRequest);
            String responseBody = EntityUtils.toString(response.getEntity());

            // Procesar la respuesta JSON
            System.out.println(responseBody);
            if (response.getStatusLine().getStatusCode() == 200) {
                return parseTaskFromJson(responseBody);
            } else {
                System.out.println("Error al obtener el usuario");
                return null;
            }
            // Actualizar la interfaz de usuario de Swing según la respuesta obtenida
            // ...
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public int deleteTask(int id) {
        try {
            URI uri = new URIBuilder(API_URL + "task")
            .setParameter("id", String.valueOf(id))
            .build();            
            
            HttpDelete deleteRequest = new HttpDelete(uri);
            deleteRequest.setHeader("Accept", "application/json");
            
            
            HttpResponse response = httpClient.execute(deleteRequest);
            String responseBody = EntityUtils.toString(response.getEntity());

            // Procesar la respuesta JSON
            System.out.println(responseBody);
            return response.getStatusLine().getStatusCode();
            // Actualizar la interfaz de usuario de Swing según la respuesta obtenida
            // ...
        } catch (Exception ex) {
            ex.printStackTrace();
            return 404;
        }
    }   
    private User parseUserFromJson(String json) {
        Gson gson = new Gson();
        try {
            User user = gson.fromJson(json, User.class);
            return user;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Task parseTaskFromJson(String json) {
        Gson gson = new Gson();
        try {
            Task task = gson.fromJson(json, Task.class);
            return task;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    
    }
}
