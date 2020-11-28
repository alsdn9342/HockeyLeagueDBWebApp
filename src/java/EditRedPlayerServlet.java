/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Minwoo Park
 */
@WebServlet(urlPatterns = {"/EditRedPlayerServlet"})
public class EditRedPlayerServlet extends HttpServlet {

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

        int idofTarget = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String team = request.getParameter("team");
        String role = request.getParameter("role");
        String active = request.getParameter("active");
        String action = request.getParameter("action");

        if (action.equals("Save")) {

            HttpSession session = request.getSession();
            ArrayList<Player> redPlayers = (ArrayList<Player>) session.getAttribute("redPlayers");
            if (redPlayers == null) {
                redPlayers = new ArrayList<Player>();
            }

            Player editPlayer = new Player();
            editPlayer.setName(name);
            editPlayer.setAddress(address);
            editPlayer.setTeam(team);
            editPlayer.setRole(role);

            boolean activeOrNot;
            if (active != null) {
                activeOrNot = true;
                editPlayer.setActive(activeOrNot);
            } else {
                activeOrNot = false;
                editPlayer.setActive(activeOrNot);
            }

            int index = -1;
            for (int i = 0; i < redPlayers.size(); i++) {
                Player redPlayer = redPlayers.get(i);

                if (redPlayer.getID() == idofTarget) {

                    index = i;

                }
            }

            if (redPlayers == null) {
                System.out.println("Red Players is NULL");
            }

            if (index != -1 && redPlayers != null) {
                redPlayers.set(index, editPlayer);
            }

            session.setAttribute("redPlayers", redPlayers);
            response.sendRedirect("viewRedTeam.jsp");

        } else {
            response.sendRedirect("viewRedTeam.jsp");
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
