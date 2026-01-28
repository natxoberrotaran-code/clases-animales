/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author dam1
 */
public class Utilidades {
    private Utilidades() {
    }

    /**
     * Comprueba si una matrícula es válida
     * Formato: 4 números + 3 letras (sin vocales)
     * Ejemplo válido: 1234BCD
     */
    public static boolean comprobarMatricula(String matricula) 
    {
       matricula = matricula.toUpperCase();
       String regex = "^[0-9]{4}[A-Z]{3}$";
       Pattern patron = Pattern.compile(regex);
       Matcher encaja = patron.matcher(matricula);
       
       return encaja.matches();
        
    }

   
    public static boolean comprobarDni(String dni) 
    {
        boolean valido = false;
        String letraDni;
        int restoDni;
        final String [] letrasDni = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        int numerosDni;
        Pattern pat = Pattern.compile(dni);
        Matcher mat = pat.matcher(dni);
        
        if (mat.find() == true) 
        {
        numerosDni = Integer.parseInt(dni.replaceAll("\\D+", ""));
        restoDni = numerosDni%23;
        letraDni = dni.substring(dni.length()-1);
        
            if (letraDni.equals(letrasDni[restoDni])) 
            {
                valido = true;
            }
        }
        
        return valido;
       
    }

    /**
     * Comprueba si un código postal es válido
     * Formato: exactamente 5 números
     */
    public static boolean comprobarCodigoPostal(String cp) {

        if (cp == null) {
            return false;
        }

        if (cp.length() != 5) {
            return false;
        }

        for (int i = 0; i < 5; i++) {
            if (!Character.isDigit(cp.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
