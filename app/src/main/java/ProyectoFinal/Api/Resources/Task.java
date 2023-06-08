/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal.Api.Resources;

/**
 *
 * @author juanhernandez
 */
public class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private int userId;

  public Task() {}

  public Task(String title, String description, boolean completed) {
    super();
    this.title = title;
    this.description = description;
    this.completed = completed;
  }

  //getters and setters
  public int getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public String getDescription() {
    return description;
  }
  public boolean isCompleted() {
    return completed;
  }
  public void setId(int id) {
    this.id = id;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
  public int getUserId() {
    return this.userId;
  }
  public void setUserId(int userId) {
    this.userId = userId;
  }
}
