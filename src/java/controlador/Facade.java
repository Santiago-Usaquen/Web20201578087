//Santiago Usaquen Vargas 20201578087

package controlador;

import java.util.List;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTO;


public class Facade {
    public List<ProductoDTO> listarProductos(){
    List<ProductoDTO> lista = null;
    ProductoDAO dao = new ProductoDAO();
    lista = dao.readAll();
    return lista;
    }
    
     public boolean borrar(ProductoDTO elim) {
        ProductoDAO dao = new ProductoDAO();
        return dao.delete(elim);
        
    }
}
