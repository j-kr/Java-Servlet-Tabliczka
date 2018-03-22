/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jakub
 */
@WebServlet(urlPatterns = {"/tabliczka"})
public class tabliczka extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tabliczka mnozenia</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet tabliczka at " + request.getContextPath() + "</h1>");
            out.println("<h2>Tabliczka Mnożenia</h2>\n" +
"        <form name=\"MyForm\" action=\"\" method=\"POST\" >\n" +
"            <table border=\"0\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        \n" +
"                        <td>Ilość wierszy: </td>\n" +
"                        <td><input type=\"text\" name=\"Wiersze\" value=\"\" size=\"15\" required /></td>\n" +
"                    </tr>\n" +
"                    \n" +
"                    \n" +
"                    <tr>\n" +
"                        <td>Ilość kolumn: </td>\n" +
"                        <td><input type=\"text\" name=\"Kolumny\" value=\"\" size=\"15\" required /></td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"            <input type=\"submit\" value=\"Generuj\" name=\"generuj\" />\n" +
"            <p></p>");
            out.println("");
            if (request.getParameter("generuj") != null) {
                    String x = request.getParameter("Wiersze");
                    Integer wiersze = Integer.parseInt(x);
                    String y = request.getParameter("Kolumny");
                    Integer kolumny = Integer.parseInt(y);
                    
                    Random r = new Random(2);
                    int kkk = 10;
                    if (wiersze <= 0 || kolumny <= 0) {
                        
                        out.print("wprowadzono nie właściwe liczby");
                    } else {
            out.println("<table>");
                out.println("<tr>");
                    out.println("<th></th>");
                        for (int i = 1; i <= kolumny; i++) {
                    out.println("<th> "+i+"</th>");
                          }  
                out.println("</tr>");
                for (int j = 1; j <= wiersze; j++) {
                        kkk--;
                
                out.println("<tr>");
                    out.println("<th>"+j+"</th>");
                        for (int i = 1; i <= kolumny; i++) {
//                            Random a = new Random();
//                            int wylosowany = a.nextInt(2); 
//                    if (wylosowany==0){      
                    out.println("<td>"+ i * j+"</td>");
                  //  }
//                          else{
//                          out.println("<td></td>");
//                          }
                     //}
                        }
                out.println("</tr>");
                }
            out.println("</table>");
               }    }
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
