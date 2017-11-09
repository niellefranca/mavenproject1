/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste2.mavenproject1;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author niellefranca
 */
@Path("generic")
public class ProjectResource {

  int hora = 0;
  int minuto = 0;
  double angulo1 = 0.0D;
  
  @Context
  private UriInfo context;

  /**
   * Creates a new instance of GenericResource
   */
  public ProjectResource() {
  }

  public ProjectResource(int hora,
          int minuto,
          double angulo1) {

    this.hora = hora;
    this.minuto = minuto;
    this.angulo1 = angulo1;

  }

  public double getAngulo() {
    return angulo1;
  }

  public void setAngulo(double angulo1) {
    this.angulo1 = angulo1;
  }

  public int getHora() {
    return hora;
  }

  public void setHora(int hora) {
    this.hora = hora;
  }

  public int getMinuto() {
    return minuto;
  }

  public void setMinuto(int minuto) {
    this.minuto = minuto;
  }
  ArrayList<ProjectResource> listaHr = new ArrayList();

  /**
   * Retrieves representation of an instance of br.com.ws.ClockResource
   *
   * @return an instance of java.lang.String
   */
  @GET
  @Produces("application/json")
  @Path("generic/{hora}/{minuto}")
  public String getJson(@PathParam("hora") String hora, @PathParam("minuto") String minuto) {


    if (minuto.equals("") || minuto == null || minuto.isEmpty()) {
      minuto = "0";
    }

    int minuto1 = Integer.parseInt(minuto);
    int hora1 = Integer.parseInt(hora);
    boolean exist = false;
    double resultado = 0;
    double calcHora = 0;
    double calcMinuto = 0;
    
    for (int i = 0; i < listaHr.size(); i++) {

      if ((listaHr.get(i).getHora() == hora1) && (listaHr.get(i).getMinuto() == minuto1)) {
        exist = true;
        resultado = listaHr.get(i).getAngulo();
        break;
      }
    }

    if (!exist) {
      //faço o calculo
      calcHora = 0.5*(hora1*60+minuto1);
      calcMinuto = 6 * minuto1;
      angulo1 = (calcHora - calcMinuto);
      resultado = Math.min(angulo1, 360 - angulo1);
      
      ProjectResource rs = new ProjectResource();
      //guardo as informações na lista
      rs.setAngulo(resultado);
      rs.setHora(hora1);
      rs.setMinuto(minuto1);
      listaHr.add(rs);
    }

    return "angulo {" + (resultado) + "}";
  }

  /**
   * PUT method for updating or creating an instance of ClockResource
   *
   * @param content representation for the resource
   * @return an HTTP response with content of the updated or created resource.
   */
  @PUT
  @Consumes("application/json")
  public void putJson(String content) {
  }
}
