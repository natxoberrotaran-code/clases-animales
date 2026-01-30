/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro_ud03_alquiler_coches;

/**
 *
 * @author dam1
 */
public class Vehiculo 
{
    //ATRIBUTO
    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private boolean disponible;
    private boolean baja;
    
    //CONSTRUCTORES

    public Vehiculo(boolean baja) {
        this.baja = baja;
    }

    
    
    
    public Vehiculo(String matricula, String marca, String modelo, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.disponible = true;
        this.baja = false;
    }
    
    //CONSTRUCTOR COPIA
    
    public Vehiculo (Vehiculo otroVehiculo)
    {
        this.matricula = otroVehiculo.matricula;
        this.marca = otroVehiculo.marca;
        this.modelo = otroVehiculo.modelo;
        this.cilindrada = otroVehiculo.cilindrada;
        this.disponible =otroVehiculo.disponible;
        
    }

    public boolean getBaja() 
    {
        return baja;
    }

    public void setBaja(boolean baja) 
    {
        this.baja = baja;
    }
    
    public String getMatricula() 
    {
        return matricula;
    }

    public String getMarca() 
    {
        return marca;
    }

    public String getModelo() 
    {
        return modelo;
    }

    public int getCilindrada() 
    {
        return cilindrada;
    }

    public boolean isDisponible() 
    {
        return disponible;
    }

    public void setDisponible(boolean disponible) 
    {
        this.disponible = disponible;
    }
    
    
    
    @Override
    public String toString() 
    {
        String cadena = "";
        if(baja == false)
        {
           
           cadena = 
                   "\n matricula :" + matricula +
                "\n marca :" + marca +
                "\n modelo :" + modelo +
                "\n cilindrada :" + cilindrada +
                "\n disponible :" + disponible ;
        }
        return cadena;
    }
}
