/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bote;

/**
 *
 * @author Usuario
 */
public interface NewInterface {

    /*
    Método que permite pintar una superficie, es necesario que haya
    suficiente pintura en el bote y que la superficie que se va a pintar sea
    positiva
     */
    void pintar(int metros) throws Exception;

    /*
    Método que permite aumentar el contenido del bote de pintura, es
    necesario que la cantidad que se quiere añadir y el dinero con que se va
    a pagar sean positvos, además el dinero debe ser suficiente para pagar la
    cantidad que se va a añadir
     */
    void rellenar(int centilitros, int centimos, String color) throws Exception;
    
}
