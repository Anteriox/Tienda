public class Tienda
{
 
   // Atributos
  
    private Producto_Tienda producto1;
    private Producto_Tienda producto2;
    private Producto_Tienda producto3;
    private Producto_Tienda producto4;  
    private double dineroEnCaja;
  
    // Constructores
  

    /**
     * Producto 1 PAPELERIA, Nombre: borrador, precio: 300, Cantidad en bodega: 10, Cantidad mínima: 5
     * Producto 2 DROGUERIA, Nombre: paracetamol, precio: 200, Cantidad en bodega: 20, Cantidad mínima: 16 
     * Producto 3 PAPELERIA, Nombre: corrector, precio: 1500, Cantidad en bodega: 30, Cantidad mínima: 15
     * Producto 4 SUPERMERCADO, Nombre: manzana, precio: 500, Cantidad en bodega: 40, Cantidad mínima: 10 
     */
    public Tienda( )
    {
        producto1 = new Producto_Tienda( Tipo.PAPELERIA, "borrador", 300, 10, 5);
        producto2 = new Producto_Tienda( Tipo.DROGUERIA, "paracetamol", 200, 20, 16);
        producto3 = new Producto_Tienda( Tipo.PAPELERIA, "corrector", 1500, 30, 15);
        producto4 = new Producto_Tienda( Tipo.SUPERMERCADO, "manzana", 500, 40, 10);
        dineroEnCaja = 0;
    }

    // Métodos

    public Producto_Tienda darProducto1( )
    {
        return producto1;
    }

  
    public Producto_Tienda darProducto2( )
    {
        return producto2;
    }

    public Producto_Tienda darProducto3( )
    {
        return producto3;
    }

 
    public Producto_Tienda darProducto4( )
    {
        return producto4;
    }

    public double darDineroEnCaja( )
    {
        return dineroEnCaja;
    }

    public Producto_Tienda getProducto( String pNombre )
    {
        Producto_Tienda buscado = null;

        if( producto1.darNombre( ).equals( pNombre ) )
        {
            buscado = producto1;
        }
        else if( producto2.darNombre( ).equals( pNombre ) )
        {
            buscado = producto2;
        }
        else if( producto3.darNombre( ).equals( pNombre ) )
        {
            buscado = producto3;
        }
        else if( producto4.darNombre( ).equals( pNombre ) )
        {
            buscado = producto4;
        }

        return buscado;

    }

    public double darPromedioVentas( )
    {
        double respuesta = 0.0;
        double totalUnidadesVendidas = producto1.darCantidadUnidadesVendidas( ) + producto2.darCantidadUnidadesVendidas( ) + producto3.darCantidadUnidadesVendidas( ) + producto4.darCantidadUnidadesVendidas( );
        if( totalUnidadesVendidas > 0 )
        {
            respuesta = dineroEnCaja / totalUnidadesVendidas;
        }
        return respuesta;
    }

    /**
     * Retorna el producto con más unidades vendidas.
     * @return Producto con más unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto_Tienda darProductoMasVendido( )
    {
        int venta1 = producto1.darCantidadUnidadesVendidas( );
        int venta2 = producto2.darCantidadUnidadesVendidas( );
        int venta3 = producto3.darCantidadUnidadesVendidas( );
        int venta4 = producto4.darCantidadUnidadesVendidas( );

        Producto_Tienda masVendido = null;
        int mayorCantidad = 0;

        if( venta1 > mayorCantidad )
        {
            masVendido = producto1;
            mayorCantidad = venta1;
        }
        if( venta2 > mayorCantidad )
        {
            masVendido = producto2;
            mayorCantidad = venta2;
        }
        if( venta3 > mayorCantidad )
        {
            masVendido = producto3;
            mayorCantidad = venta2;
        }
        if( venta4 > mayorCantidad )
        {
            masVendido = producto4;
        }

        return masVendido;
    }

    /**
     * Retorna el producto con menos unidades vendidas.
     * @return Producto con menos unidades vendidas. Null si ningún producto tiene unidades vendidas.
     */
    public Producto_Tienda darProductoMenosVendido( )
    {
        int venta1 = producto1.darCantidadUnidadesVendidas( );
        int venta2 = producto2.darCantidadUnidadesVendidas( );
        int venta3 = producto3.darCantidadUnidadesVendidas( );
        int venta4 = producto4.darCantidadUnidadesVendidas( );

        Producto_Tienda menosVendido = null;

        if( venta1 > 0 || venta2 > 0 || venta3 > 0 || venta4 > 0 )
        {
            if( venta1 <= venta2 && venta1 <= venta3 && venta1 <= venta4 )
            {
                menosVendido = producto1;
            }
            else if( venta2 <= venta1 && venta2 <= venta3 && venta2 <= venta4 )
            {
                menosVendido = producto2;
            }
            else if( venta3 <= venta2 && venta3 <= venta1 && venta3 <= venta4 )
            {
                menosVendido = producto3;
            }
            else
            {
                menosVendido = producto4;
            }
        }

        return menosVendido;
    }

    public int venderProducto( String pNombreProducto, int pCantidad )
    {
        int cantidadVendida = 0;
        Producto_Tienda producto = darProducto( pNombreProducto );
        cantidadVendida = producto.vender( pCantidad );
        dineroEnCaja += cantidadVendida * producto.calcularPrecioFinal( );

        return cantidadVendida;
    }

    public boolean abastecerProducto( String pNombreProducto, int pCantidad )
    {
        boolean abastece = false;
        Producto_Tienda producto = darProducto( pNombreProducto );

        if( producto.puedeAbastecer( ) )
        {
            producto.abastecer( pCantidad );
            abastece = true;
        }

        return abastece;
    }

    public boolean cambiarProducto( String pNombreActual, String pNombreNuevo, Tipo pTipo, double pValorUnitario, int pCantidadBodega, int pCantidadMinima, String pRutaImagen )
    {
        boolean cambio = false;
        if( pNombreActual.equals( pNombreNuevo ) || darProducto( pNombreNuevo ) == null )
        {

            if( producto1.darNombre( ).equals( pNombreActual ) )
            {
                producto1 = new Producto_Tienda( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
            }
            else if( producto2.darNombre( ).equals( pNombreActual ) )
            {
                producto2 = new Producto_Tienda( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
            }
            else if( producto3.darNombre( ).equals( pNombreActual ) )
            {
                producto3 = new Producto_Tienda( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
            }
            else if( producto4.darNombre( ).equals( pNombreActual ) )
            {
                producto4 = new Producto_Tienda( pTipo, pNombreNuevo, pValorUnitario, pCantidadBodega, pCantidadMinima, pRutaImagen );
            }
            cambio = true;
        }
        return cambio;
    }

    // Puntos de Extensión
  
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    public String metodo2( )
    {
        return "Respuesta 2";
    }
  
  
}
