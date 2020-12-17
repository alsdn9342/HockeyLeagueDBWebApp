/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.Player;
import data.PlayerDAO;
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
@WebServlet(urlPatterns = {"/RedPlayerControllerServlet"})
public class RedPlayerControllerServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        PlayerDAO playerDAO = new PlayerDAO();

        if (action.equals("Add")) {

            Player redPlayer = new Player();

            redPlayer.setName(request.getParameter("name"));
            redPlayer.setAddress(request.getParameter("address"));
            redPlayer.setTeam(request.getParameter("team"));
            redPlayer.setRole(request.getParameter("role"));
            String active = request.getParameter("active");
            boolean activeOrNot;

            if (active != null) {
                activeOrNot = true;
                redPlayer.setActive(activeOrNot);

            } else {
                activeOrNot = false;
                redPlayer.setActive(activeOrNot);

            }

            playerDAO.createRedPlayer(redPlayer);

            ArrayList<Player> redPlayers = playerDAO.retrieveAllRedPlayers();
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
