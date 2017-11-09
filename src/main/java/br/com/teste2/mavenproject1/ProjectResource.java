/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste2.mavenproject1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import br.com.teste2.mavenproject1.ControleAngulo;

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
  public static final ArrayList <ControleAngulo> controleAngulo = new ArrayList<ControleAngulo>();
  @Context
  private UriInfo context;

  /**
   * Creates a new instance of GenericResource
   */
  public ProjectResource() {
  }

  /**
   * Retrieves representation of an instance of br.com.ws.ClockResource
   *
   * @return an instance of java.lang.String
   */
  @GET
  @Produces("application/json")
  @Path("generic/{hora}/{minuto}")
  public String getJson(@PathParam("hora") String hora, @PathParam("minuto") String minuto) {

    int minuto1 = Integer.parseInt(minuto);
    int hora1 = Integer.parseInt(hora);
    boolean exist = false;
    double resultado = 0;
    double calcHora = 0;
    double calcMinuto = 0;
    
    
    //loop na lista de angulo armazenada
    for (int i = 0; i < controleAngulo.size(); i++) {

      if ((controleAngulo.get(i).getHora() == hora1) && (controleAngulo.get(i).getMinuto() == minuto1)) {
        exist = true;
        resultado = controleAngulo.get(i).getAngulo();
        break;
      }
     }
    //se ainda nao existe na lista
    if (!exist) {
      //faço o calculo
      calcHora = 0.5*(hora1*60+minuto1);
      calcMinuto = 6 * minuto1;
      angulo1 = (calcHora - calcMinuto);
      resultado = Math.min(angulo1, 360 - angulo1);
      
      ControleAngulo ca = new ControleAngulo();
      ca.setAngulo(resultado);
      ca.setHora(hora1);
      ca.setMinuto(minuto1);
      controleAngulo.add(ca);
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
