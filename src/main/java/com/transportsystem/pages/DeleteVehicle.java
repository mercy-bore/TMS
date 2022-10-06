package com.transportsystem.pages;

import com.transportsystem.model.Vehicle;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet("/deletevehicle")

public class DeleteVehicle extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.getWriter().print(this.deletevehicle(null));
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter wr = res.getWriter();
        Vehicle vehicle = new Vehicle();

        try {
            BeanUtils.getArrayProperty(vehicle, req.getParameter("vehicle"));

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        HttpSession session = req.getSession();
        List<Vehicle> vehicles = (List<Vehicle>) session.getAttribute("vehicles");
        for (Vehicle e : vehicles) {
            if (Objects.equals(e.getType(), req.getParameter("vehicle"))) {
                session.removeAttribute("vehicle");
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
            dispatcher.forward(req, res);
        }
    }
    public String deletevehicle(String actionError){
        return
                "<input type=\"hidden\" name=\"action\" value=\"deletevehicle\">";
    }
}
