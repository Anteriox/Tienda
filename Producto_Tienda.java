public class Producto_Tienda
{
    // Enumeraciones

    public enum Tipo
    { 
        PAPELERIA, SUPERMERCADO,DROGUERIA;
    }

    // Constantes

    
    private final static double IVA_PAPELERIA = 0.16;

    
    private final static double IVA_SUPERMERCADO = 0.04;

    
    private final static double IVA_DROGUERIA = 0.12;

    // Atributos

    private String nombre;
    private Tipo tipo;
    private double valorUnitario;
    private int cantidadBodega;
    private int cantidadMinima;
    private int cantidadUnidadesVendidas;
    private String rutaImagen;

    // Constructores
    

    public Producto_Tienda( Tipo pTipo, String pNombre, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen )
    {
        tipo = pTipo;
        nombre = pNombre;
        valorUnitario = pValorUnitario;
        cantidadBodega = pCantidadBodega;
        cantidadMinima = pCantidadMinima;
        rutaImagen = pRutaImagen;
        cantidadUnidadesVendidas = 0;
    }


    // Métodos
 
    public String darNombre( )
    {
        return nombre;
    }
  
    public Tipo darTipo( )
    {
        return tipo;
    }

    public double darValorUnitario( )
    {
        return valorUnitario;
    }

    public int darCantidadBodega( )
    {
        return cantidadBodega;
    }

    public int darCantidadMinima( )
    {
        return cantidadMinima;
    }

    public int darCantidadUnidadesVendidas( )
    {
        return cantidadUnidadesVendidas;
    }

    public String darRutaImagen( )
    {
        return rutaImagen;
    }

    public double calcularPrecioFinal( )
    {

        return valorUnitario + valorUnitario * darIVA( );
    }

    public double darIVA( )
    {
        double iva = 0;
        switch( tipo )
        {
            case PAPELERIA:
            {
                iva += IVA_PAPELERIA;
                break;
            }
            case SUPERMERCADO:
            {
                iva += IVA_SUPERMERCADO;
                break;
            }
            case DROGUERIA:
            {
                iva += IVA_DROGUERIA;
                break;
            }

        }

        return iva;
    }

    public int vender( int pCantidad )
    {
        int cantidadVendida = 0;

        if( pCantidad > cantidadBodega )
        {
            cantidadVendida = cantidadBodega;
            cantidadBodega = 0;
        }
        else
        {
            cantidadBodega -= pCantidad;
            cantidadVendida = pCantidad;
        }

        cantidadUnidadesVendidas += cantidadVendida;

        return cantidadVendida;
    }

    public void abastecer( int pCantidad )
    {
        cantidadBodega += pCantidad;
    }

    public boolean puedeAbastecer( )
    {
        boolean respuesta = false;
        if( cantidadBodega < cantidadMinima )
        {
            respuesta = true;
        }
        return respuesta;
    }
      
    
}
