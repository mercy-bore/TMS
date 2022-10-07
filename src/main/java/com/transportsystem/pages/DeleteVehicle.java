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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@WebServlet("/deletevehicle")

public class DeleteVehicle extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter wr = res.getWriter();
        HttpSession session = req.getSession();

        Vehicle vehicle= new Vehicle();
        List<Vehicle> vehicles = (List<Vehicle>) session.getAttribute("vehicles");
        Iterator<Vehicle> itr = vehicles.iterator();

        if (session.isNew()) {
            while (itr.hasNext()) {
                Vehicle v = itr.next();
                if (Objects.equals(v, req.getAttribute("vehicle"))) {
                    vehicles.remove(v);
                    session.removeAttribute("vehicle");
                }
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
        dispatcher.forward(req, res);

    }
}


