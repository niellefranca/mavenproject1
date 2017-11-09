/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste2.mavenproject1;

import java.util.ArrayList;

/**
 *
 * @author niellefranca
 */
public class ControleAngulo {
  
  int hora = 0;
  int minuto = 0;
  double angulo = 0.0D;

  public ControleAngulo() {
  }
  
  public ControleAngulo(int hora,
          int minuto,
          double angulo) {

    this.hora = hora;
    this.minuto = minuto;
    this.angulo = angulo;

  }

  public double getAngulo() {
    return angulo;
  }

  public void setAngulo(double angulo) {
    this.angulo = angulo;
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
  
}
