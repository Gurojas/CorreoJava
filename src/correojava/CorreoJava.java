/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correojava;

/**
 *
 * @author Usuario
 */
public class CorreoJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Correo correo = new Correo();
        //correo.setPassword("csguurdfwcnmkofz");
        //correo.setUsuarioCorreo("terminalbusescurico@gmail.com");
        correo.setAsunto("correo de prueba");
        correo.setMensaje("Esos malditos terricolas me robaron las esferas del dragon !!! \n"
                + "lo pagaran caro malditos insectos !!!!!!!");
        correo.setDestino("gurojas13@alumnos.utalca.cl");
        
        ControladorCorreo controladorCorreo = new ControladorCorreo();
        boolean enviado = controladorCorreo.envioCorreo(correo);
        System.out.println("Correo fue enviado?: "+enviado);
        
    }
    
}
