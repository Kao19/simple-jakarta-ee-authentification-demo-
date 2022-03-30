/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pack;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import pack.employe;

/**
 *
 * @author HP
 */
@WebServlet(name = "Serv", urlPatterns = {"/Serv"})
public class Serv extends HttpServlet {

        public Connection con;
        public ResultSet rs;
        public ResultSet rs2;
    
    
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
        
        //on verifie le login et le mot de passe au meme temps en parcourant la table ligne par ligne
            
            String l=request.getParameter("Login");
            String p=request.getParameter("Password");
        
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpasswdbd", "root","");
            Statement stmt = (Statement) con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM emp"); //cet objet sera utilisé pour stocker les données de la table dans une list
            Statement stmt2 = (Statement) con.createStatement();
            rs2 = stmt2.executeQuery("SELECT * FROM emp"); //cet objet sera utilisé pour verifier le login et le mdp. 
                                                            //si les deux se trouve dans un tuple de la table, 
                                                            //l'authntification sera faite (redirection vers page affichage comme dite dans l'énnoncé
        }catch(Exception e){
            System.out.println(e);
        }
        
        LinkedList<employe> L = new LinkedList();
        HttpSession session = request.getSession();
        employe W = new employe("X","Y","default_pofile");
        L.add(W);
        try{
                while(rs.next()){
                    L.add(new employe(rs.getString("Login"),rs.getString("Password"),rs.getString("Profile"))); 
                    session.setAttribute("liste",L);
                    
                }
                    
                while(rs2.next()){
                        if(l.equals(rs2.getString("Login")) && p.equals(rs2.getString("Password"))){  
                        RequestDispatcher rd =request.getRequestDispatcher("/affiche.jsp");
                        rd.forward(request, response);
                    }
                    }
                
            }catch(Exception e){
                System.out.println(e);
        }
        // à ce niveau, le login et le mdp entrés ne figure pas dans la base de données. d'où on reste dans la meme page
        RequestDispatcher rd =request.getRequestDispatcher("/index.html"); 
        rd.forward(request, response);
        

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
