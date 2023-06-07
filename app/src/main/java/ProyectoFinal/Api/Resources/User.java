/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal.Api.Resources;

import java.util.List;

/**
 *
 * @author juanhernandez
 */
public class User {
  private int id;
  private String username;
  private String password;
  private List<Task> tasks;
  public User() {}

  public User(int id, String username, String password) {
    super();
    this.username = username;
    this.password = password;
  }
  //getters and setters
  public int getId() {
    return id;
  }
  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }
  public void setId(int id) {
    this.id = id;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  public List<Task> getTasks() {
    return tasks;
  }
}
