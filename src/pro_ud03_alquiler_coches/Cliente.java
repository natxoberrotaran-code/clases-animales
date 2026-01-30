/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro_ud03_alquiler_coches;

/**
 *
 * @author dam1
 */
public class Cliente 
{
    //ATRIBUTOS
    private String dni;
    private String nombre;
    private String direccion;
    private String localidad;
    private String codigoPostal;
    private boolean baja;

    
    
    //CONSTRUCTORES

    public Cliente(boolean baja) {
        this.baja = baja;
    }
    
    public Cliente(String dni, String nombre, String direccion, String localidad, String codigoPostal) 
    {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }
    
    //CONSTRUCTOR COPIA
    public Cliente (Cliente otroCliente)
    {
         this.dni = otroCliente.dni;
        this.nombre = otroCliente.nombre;
        this.direccion = otroCliente.direccion;
        this.localidad = otroCliente.localidad;
        this.codigoPostal = otroCliente.codigoPostal;
        this.baja = false;
        
    }

    public boolean getBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
    
    
    
    public String getDni() 
    {
        return dni;
        
    }

    public String getNombre() 
    {
        return nombre;
        
    }

    public String getDireccion() 
    {
        return direccion;
        
    }

    public String getLocalidad() 
    {
        return localidad;
        
    }

    public String getCodigoPostal() 
    {
        return codigoPostal;
        
    }

    @Override
    public String toString() 
    { 
        String cadena = "";
        if(baja == false)
        {
           
           cadena = 
                   "\n dni: " + dni +
                "\n nombre :" + nombre +
                "\n direccion :" + direccion +
                "\n localidad :" + localidad +
                "\n codigoPostal :" + codigoPostal ;
        }
        return cadena;
    }
    
    

}
