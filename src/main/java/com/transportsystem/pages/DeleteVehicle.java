package com.transportsystem.pages;

import com.transportsystem.jdbc.DBConnection;
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
import java.util.List;
import java.util.Objects;


@WebServlet("/deletevehicle")

public class DeleteVehicle extends HttpServlet{
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String plateNo = req.getParameter("plateNo");
//
//        HttpSession session = req.getSession();
//
//        vehicles = (List<Vehicle>) session.getAttribute("vehicles");
//
//        for (Vehicle vehicle: vehicles){
//            if (Objects.equals(vehicle.getPlateNo(), plateNo)) {
//                vehicles.remove(vehicle);
//                System.out.println("remove " + vehicle);
//                break;
//            }
//        }
        String sid=req.getParameter("id");
        int id1=Integer.parseInt(sid);
        DBConnection.delete(id1);
        RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
        dispatcher.forward(req, res);
    }
}


