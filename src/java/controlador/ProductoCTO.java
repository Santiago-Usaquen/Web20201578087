
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.ProductoDTO;


public class ProductoCTO extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Facade fcd = new Facade();
//                List<ProductoDTO> lista = fcd.listarProductos();
//                request.setAttribute("lista_productos", lista);
//                request.getRequestDispatcher("ProductoVTA.jsp").forward(request, response);
                 String accion = request.getParameter("accion");
        switch (accion) {
            case "listar_datos":
                List<ProductoDTO> lista = fcd.listarProductos();
                request.setAttribute("lista_productos", lista);
                request.getRequestDispatcher("ProductoVTA.jsp").forward(request, response);
                //request.getRequestDispatcher("ProductoCTO?accion=listar_datos").forward(request, response);
                break;
            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                ProductoDTO elim = new ProductoDTO();
                elim.setId_prod(id);
                boolean s = fcd.borrar(elim);
                if(s){
                    System.out.println("OK borrado");
                }else{
                    System.out.println("NO BORROOOO");
                }
                request.getRequestDispatcher("ProductoCTO?accion=listar_datos").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
                }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
