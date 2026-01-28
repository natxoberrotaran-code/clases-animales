package utiles;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class ES 
{
     private static final Scanner sc = new Scanner(System.in);

    // ------------------ LECTURAS ------------------

    public static byte leerByte(String _msg)
    {
        System.out.println(_msg);
        byte num = 0;
        boolean valido = true;
        do
        {
           
            try
            {
            num = sc.nextByte();
           
            }
            catch (Exception e)
            {
                System.out.println("ERROR, Introduzca un valor numerico entero");
                valido = false;
            }
        }while (valido = false);
        return num;
    }

     public static byte leerByte (String _mensaje, byte _min, byte _max)
    {
       
        byte opcion = 0;
        boolean opcValida = false;
        do
        {
            try
            {
                System.out.println(_mensaje);
                opcion = sc.nextByte();

                if (opcion <= _max && opcion >= _min)
                    opcValida = true;
                else
                    System.out.println("El valor introducido no se encuentra entre los valores"+_min+" y "+_max);
            }
            catch (Exception e)
            {
                System.out.println("El valor introducido no se encuentra entre las opciones"+_min+ " y "+ _max);
                System.out.println("Introduzca un valor entre esos  valores");
            }
        }while (opcValida = false);
        return opcion;
    }

    public static int leerEntero(String _msg)
    {
        System.out.println(_msg);
        int numero = 0;
        boolean entero = true;
        do
        {
            try
            {
            numero = sc.nextInt();
           
            }
            catch (Exception e)
            {
                System.out.println("ERROR, Introduzca un valor numerico entero");  
                entero = false;
            }
        }while (entero == false);
        return numero;
    }

    
    public static String leerReal (float mensaje )
    {
        System.out.println(mensaje);
        return sc.next();
    }
      public static String leerCadena (String _mensaje)
    {
       
        String cadena ;
        System.out.println(_mensaje);
        cadena = sc.next();
        return cadena;
    }

     public static boolean leerBoolean( String cadena )
    {
        String respuesta;
        boolean opcionValida = false;
        boolean decision = false;
       
        do
        {
            try
            {
                System.out.println(cadena);
                respuesta = sc.next();
               
               
                if (respuesta.toUpperCase().equals("SI") || respuesta.toUpperCase().equals("S"))
                {
                    opcionValida = true;
                    decision = true;
                   
                }
                else if (respuesta.toUpperCase().equals("NO") || respuesta.toUpperCase().equals("N"))
                {
                    opcionValida = true;
                decision = false;
                   
                }
                else
                {
                    System.out.println("El valor introducido no es ni SI/si/Si/sI o NO/no/No/nO");
                    System.out.println("Introduzca un valor de esos  valores");
                }
            }
            catch (Exception e)
            {
                System.out.println("El valor introducido no es ni SI/si/Si/sI o NO/no/No/nO");
                System.out.println("Introduzca un valor de esos  valores");
            }
        }while (opcionValida == false);
       
       
        return decision;
    }
    
    
    
    
    // ------------------ ESCRITURAS ------------------

    public static void escribirLn(String mensaje)
    {
        System.out.println(mensaje);
    }
    
    public static void escribir(String mensaje)
    {
        System.out.print(mensaje);
    }
    
}

