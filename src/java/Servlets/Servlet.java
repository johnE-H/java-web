package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Pais;
import modelo.Pais;
import modelo.calculos;
import modelo.calculos;

/**
 *
 * @author Usuario
 */
@WebServlet(urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet implements calculos{
//instaciamos 2
    Pais p1 = new Pais("angola", "angolano", "kwanza", "luanda", 0);
    Pais p2 = new Pais("madagascar", "malgache", "ariary malgache", "antananarivo", 0);
    Pais p3=new Pais("marruecos", "marroqui", "dirham", "rabat", 0);
    Pais p4 = new Pais("kenya", "keniano", "chelin", "nairobi", 0);
    Pais p5 = new Pais("egipto", "egipcio", "libra egipcia", "el cairo", 0);
    
    ArrayList <Pais> lista = new ArrayList();
    
    public void agregarLista(){
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
    }
  
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
            
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            agregarLista();
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
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

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pais;
        int cantidad;
        response.setContentType("text/html");         
    PrintWriter out = response.getWriter();        
    out.println("<html>");          
    out.println("<body bgcolor=yellow>");         
    out.println("<h1>INFORMACION DEL PAÍS</h1>");  
    
    pais= String.valueOf(request.getParameter("tipopais"));
    cantidad = Integer.parseInt((request.getParameter("canmonedas")));
    agregarLista();
    
    boolean find = false;
    int posicion=0;
    
        do {            
      if(lista.get(posicion).getNombrep().equals(pais)){
          lista.get(posicion).setCantidadmonedas(cantidad);
      out.println("La busqueda es: ");
     out.println("<h3>Nombre: </h3>"+lista.get(posicion).getNombrep()+"<h3> Gentilicio: </h3>"+lista.get(posicion).getGentilicio()+"<h3>Tipo Moneda: </h3>"+lista.get(posicion).getTipomoneda()+"<h3> Cantidad: </h3>"+lista.get(posicion).getCantidadmonedas()+"<h3> Capital: </h3>"+lista.get(posicion).getCapital());
                    
      find = true;
      }else{
      posicion++;
      }
                 
        } while (find!=true);
      
    out.println("<h1>"+calcularMoneda(pais,cantidad)+"</h1>");  
    
    switch(pais){
                case "angola":
                out.println("<h2>traduccion de español a frances</h2><br>");
                out.println("hola : Salut<br>"+'\n'+"adios : adieu<br>"+'\n'+"casa : maison<br>"+'\n'+"carro : chariot<br>"+'\n'+"universidad : l'universitè");
                break;
                case "egipto":
                out.println("<h2>traduccion de español a arabe</h2><br>");
                out.println("hola : مرحبا<br>"+'\n'+"adios : وداعا<br>"+'\n'+"casa : منزل<br>"+'\n'+"carro : نقل<br>"+'\n'+"universidad : جامعة");
                break;
                case "madagascar":
                out.println("<h2>traduccion de español a portugues</h2><br>");
                out.println("hola : ola<br>"+'\n'+"adios : adeus<br>"+'\n'+"casa : casa<br>"+'\n'+"carro : carro<br>"+'\n'+"universidad : universidade");
                break;
                case "marruecos":
                out.println("<h2>traduccion de español a arabe</h2><br>");
                out.println("hola :marhabaan<br>"+'\n'+"adios : wadaeaan<br>"+'\n'+"casa : manzil<br>"+'\n'+"carro: naql<br>"+'\n'+"universidad : jamiea");    
                break;
                case "kenya":
                out.println("<h2>traduccion de español a kenyense</h2><br>");
                out.println("hola : Salut<br>"+'\n'+"adios : adieu<br>"+'\n'+"casa : maison<br>"+'\n'+"carro : chariot<br>"+'\n'+"universidad : l'universitè");      
                break;
            } 
    out.println("</body>");  
    out.println("</html>");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

    @Override
    public String calcularMoneda(String pais, int cantidad) {
        double equivalencia = 0;
        switch(pais){
        
            case "angola":
                equivalencia =  (cantidad*0.15);
                
                break;
            case"madagascar":
                equivalencia =  (cantidad*1.08);
                break;
            case"marruecos":
                equivalencia =  (cantidad*0.0029);
                break;
            case"kenya": 
                 equivalencia =  cantidad*0.031;
                break;
            case"egipto":
                equivalencia= cantidad*0.0048;
                break;
                
            default:
                equivalencia=0;
        }
        
        return "la equivalencia de pesos a la moneda del pais "+pais+" son = "+equivalencia;
    }

    @Override
    public void definePalabra(String palabra) {
    
        
        
    }

}
