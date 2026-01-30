/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro_ud03_alquiler_coches;



import utiles.ES;
import utiles.Utilidades;
/**
 *
 * @author dam1
 */
public class AlquilerVehiculos 
{
     public static void main (String[] args)
    {
        AlquilerVehiculos sistema = new AlquilerVehiculos();
        int opcion;
        
        do 
        {            
            System.out.println("\n--- MENU ALQUILER DE VEHICULOS ---");
            System.out.println("\n 1. Añadir cliente");
            System.out.println("\n 2. Borrar cliente");
            System.out.println("\n 3. Listar cliente");
            System.out.println("\n 4. Añadir vehiculo");
            System.out.println("\n 5. Borrar vehiculo");
            System.out.println("\n 6. Listar vehiculo");
            System.out.println("\n 7. Nuevo alquiler");
            System.out.println("\n 8. Cerrar alquiler");
            System.out.println("\n 9. Listar alquiler");
            System.out.println("\n 0. Salir");
            
            opcion = ES.leerEntero("Elige una opcion: ");
                    
            switch(opcion)
            {
                case 1:
                    insertarCliente();
                                break;
                case 2:
                    borrarCliente(ES.leerCadena("DNI del cliente a eliminar"));
                                break;
                case 3:
                    mostrarClientes(clientes, numClientes);
                                break;
                case 4:
                    insertarVehiculo();
                                break;
                case 5:
                    borrarVehiculo(ES.leerCadena("Matricula del vehiculo a eliminar"));
                                break;
                case 6:
                    mostrarVehiculos(vehiculos, numVehiculos);
                                break;
                case 7:
                    insertarAlquiler();
                                break;
                case 8:
                    cerrarAlquiler(getCliente(ES.leerCadena("Introduzca su dni")), getVehiculo(ES.leerCadena("Introduzca su matricula")));
                                break;
                case 9: mostrarAlquiler(alquileres, numAlquileres);
                                break;
                    
            }
                            
        } while (opcion !=0);
        
        
    }

    //ATRIBUTOS
    
    static private final int MAX_VEHICULOS = 50;
    static private final int MAX_CLIENTES = 50;
    static private final int MAX_ALQUILERES = 50;
    static private Vehiculo vehiculo;
    
    //ARRAYS
    static private Cliente [] clientes;
    static private Vehiculo [] vehiculos;
    static private Alquiler [] alquileres;
    
    //CONTADORES
   static private int numVehiculos;
    static private int numClientes;
    static private int numAlquileres;
    
    //CONSTRUCTOR
    public AlquilerVehiculos ()
    {
        vehiculos = new Vehiculo [MAX_VEHICULOS];
        clientes = new Cliente [MAX_CLIENTES];
        alquileres = new Alquiler [MAX_ALQUILERES];
        
        numVehiculos = 0;
        numClientes = 0;
        numAlquileres = 0;
        
    }
    
    //CLIENTES
    public static Cliente getCliente(String dni)
    {
        boolean enc = false;
        Cliente cliente = null;
        for (int i = 0; i < numClientes && !enc; i++) 
        {
            if(clientes[i].getDni().equalsIgnoreCase(dni)){
                enc = true;
                cliente =clientes[i];
            }
        }
        return cliente;
        
    }
    
    //Añade un cliente si hay espacio y no existe otro con el mismo DNI
    public static void anadirCliente (Cliente cliente)
    {
        //Esto verifica si hay espacio en el array para añadir al cliente
        if (numClientes >= MAX_CLIENTES)
        {
            System.out.println("ERRor: No se pueden añadir mas clientes porque no hay coches.");
        //Si el numero de clientes es mas pequeño que el tamaño del array 
        } 
        
        if(getCliente(cliente.getDni())!= null)
        {
            ES.escribirLn("ERROR: Ya existe un cliente con ese DNI.");
            
        }
        else 
            if((numClientes <= MAX_CLIENTES))      
        {
            clientes[numClientes] = cliente;
            numClientes ++;
            System.out.println("El cliente se ha añadido correctamente");
        }
        
    }
    
    //Borrar un cliente dado su DNI
    public static void borrarCliente(String dni)
    {
        boolean enc = false;
        Cliente cliente = null;
        for (int i = 0; i < numAlquileres && !enc; i++) 
        {
            if(alquileres[i].getCliente().equals(dni))
            {
                cliente= alquileres[i].getCliente();
                enc = true;
            }
        }
    
            if (enc)
            {
                ES.escribirLn("INF : El cliente tiene un alquiler. No se puede borrar.");
            }
            else
            {
                //quitarHueco(dni);
                //ES.escribirLn("INF: Cliente borrado");
                cliente = getCliente(dni);
                if (cliente !=null) 
                {
                    cliente.setBaja(true);
                    ES.escribirLn("INF: Cliente dado de baja.");
                }
                else
                {
                    System.out.println("Error : Cliente no encontrado. ");
                }
                  //podemos borrarlo
                    /*Desplazamos el array para liberar el hueco para un nuevo cliente.
                 for (int j = 0; j < numClientes - 1; j++) 
                 {
                      clientes[j] = clientes[j + 1];   
                    }
                  clientes [-- numClientes] = null;
                   System.out.println("Cliente borrado correctamente. ");
                  return;*/    
            }
    }
    
    public static void borrarVehiculo (String matricula)
    {
      boolean enc = false;
      Vehiculo vehiculo = null;
        for (int i = 0; i < numAlquileres && !enc; i++) 
        {
            if(alquileres[i].getVehiculo().equals(matricula))
            {
                vehiculo= alquileres[i].getVehiculo();
                enc = true;
            }
        }  
        if (enc)
            {
                ES.escribirLn("INF : El vehiculo esta en alquiler. No se puede borrar.");
            }
            else
            {
                //quitarHueco(matricula);
                //ES.escribirLn("INF: Vehiculo borrado");
                vehiculo = getVehiculo(matricula);
                if ( vehiculo !=null) 
                {
                    vehiculo.setBaja(true);
                    ES.escribirLn("INF: Vehiculo dado de baja.");
                }  
                else
                    ES.escribirLn( "Error : vehiculo no encontrado. ");
            }
    }
    
     public static void cerrarAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        for (int i = 0; i <numAlquileres; i++) 
        {
            Alquiler a = alquileres[i];
            
            if (a.getCliente().equals(cliente) && a.getVehiculo().equals(vehiculo) ) 
            {
                a.cerrar();
                System.out.println("Alquiler cerrado correctamente");
                //return;
            }
            else
            {
                System.out.println("ERROR: No se encontro el alquiler");
            }
        }
        
    
    }
    
    public static void quitarHueco(String dni)
    {
        boolean enc = false;
        Cliente cliente = null;
        for (int i = 0; i < numClientes && !enc; i++) 
        {
            if(clientes[i].getDni().equals(dni)){
                clientes[i]= null;
                clientes[i] = clientes[numClientes-1];
                clientes[numClientes-1]=null;
                numClientes--;
                enc = true;
            }
        }
    }
    
    //VEHICULOS
    //Devuelve un vehiculo dada su matricula o null si no existe la matricula
    public static Vehiculo getVehiculo(String matricula)
    {
        boolean enc = false;
        Vehiculo vehiculo = null;
        for (int i = 0; i < numVehiculos && !enc; i++) 
        {
            if(vehiculos[i].getMatricula().equalsIgnoreCase(matricula)){
                enc = true;
                vehiculo =vehiculos[i];
            }
        }
        return vehiculo;
    }
    
    //Añade un vehiculo si hay espacio y no existe otro con la misma matricula
    public static void añadirVehiculo(Vehiculo vehiculo)
    {
        if (numVehiculos < MAX_VEHICULOS)
        {
            if (getVehiculo(vehiculo.getMatricula())== null )
             {
                    vehiculos[numVehiculos] = vehiculo;
                    numVehiculos ++;
             }
            else
            {
                ES.escribirLn("ERROR:Ya existe un vehiculo con esa matricula. ");
                
            }
        }    
         else
            {
            ES.escribirLn("Base de datos completada");
            }     
        
        /*if(getVehiculo(vehiculo.getMatricula()) !=null)
        {
            System.out.println("ERROR:Ya existe un vehiculo con esa matricula. ");
        }
   
        vehiculos[numVehiculos++] = vehiculo;
        System.out.println("Vehiculo añadido correctamente");*/ 
    }
    
     
    
    public static void nuevoAlquiler(Cliente cliente, Vehiculo vehiculo)
    {
        if(vehiculo.isDisponible())
        {
            alquileres[numAlquileres] = new Alquiler( cliente, vehiculo);
            numAlquileres++;
            ES.escribirLn("INF: alquiler creado.");
        }
        else
        {
            ES.escribirLn("ERROR : vehiculo no disponible");
        }
        
    }
    
   
    
    
    public static void insertarAlquiler()
    {
        String dni, matricula;
        Cliente cliente;
        Vehiculo vehiculo;
        
        ES.escribirLn("Insertando alquiler");
      
        do 
        {            
            dni = ES.leerCadena("Escribir el dni");
        } while (!Utilidades.comprobarDni(dni));
        
        do 
        {            
            matricula = ES.leerCadena("introduzca la matricula");
        } while (!Utilidades.comprobarMatricula(matricula));
        
        cliente =getCliente(dni);
        if(cliente !=null)
        {
            vehiculo = getVehiculo(matricula);
            if(vehiculo != null)
            {
                 nuevoAlquiler (cliente, vehiculo);
            }
            else
            {
                ES.escribirLn("ERROR : vehiculo no existe");
            }
        }
        else
        {
           ES.escribirLn("ERROR : cliente no existe"); 
        }
       
    }
    
    public static void insertarCliente()
    {
        String dni, nombre, localidad, direccion, codigoPostal;
        Cliente cliente;
        
        
        ES.escribirLn("Insertando cliente");
      
        do 
        {            
            dni = ES.leerCadena("Escribir el dni");
        } while (!Utilidades.comprobarDni(dni));
        cliente = getCliente(dni);
        if (cliente == null)
        {
        nombre = ES.leerCadena("Escribir el nombre");
        localidad = ES.leerCadena("Introduzca la localidad");
        direccion = ES.leerCadena("Escribe tu direccion");
            do 
            {            
               codigoPostal = ES.leerCadena("introduzca su codigo postal");
            } while (!Utilidades.comprobarCodigoPostal(codigoPostal));
            
            anadirCliente(new Cliente(dni, nombre, direccion, localidad, codigoPostal));
            
        }
        else
        {
            ES.escribirLn("ERROR: ya existe un cliente con ese DNI");
        }
    }
    
    public static void insertarVehiculo()
    {
        String matricula, marca, modelo;
        int cilindrada;
        Vehiculo vehiculo;
        
        
        ES.escribirLn("Insertando vehiculo");
      
        do 
        {            
            matricula = ES.leerCadena("Escribir la matricula");
        } while (!Utilidades.comprobarMatricula(matricula));
        vehiculo = getVehiculo(matricula);
        if (vehiculo == null)
        {
        marca = ES.leerCadena("Escribir la marca");
        modelo = ES.leerCadena("Introduzca el modelo");
        cilindrada = ES.leerEntero("Introduzca la cilindrada del vehiculo");
        
        añadirVehiculo(new Vehiculo(matricula, marca, modelo, cilindrada));
            
        }
        else
        {
            ES.escribirLn("ERROR: ya existe un vehiculo con esa matricula");
        }
    }
    
    public static void  mostrarAlquiler (Alquiler alquileres[], int numAlquileres)
    {
        
        for (int i = 0; i < numAlquileres; i++) 
        {
            System.out.println(alquileres[i]); 
            
        }
    
    }
    
    
    
    
    public static void  mostrarClientes (Cliente clientes[], int numClientes)
    {
        
        for (int i = 0; i < numClientes; i++) 
        {
            System.out.println(clientes[i]); 
            
        }
        
    }
    
    
    
    public static void  mostrarVehiculos (Vehiculo vehiculos[], int numVehiculos)
    {
        
        for (int i = 0; i < numVehiculos; i++) 
        {
            System.out.println(vehiculos[i]); 
            
        }
        
    }
    
   
}
