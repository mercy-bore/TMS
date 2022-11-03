package com.transportsystem.customtags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;


public class headertag extends TagSupport {
    private String applicationLabel;
    private Date date = new Date();


    public int doStartTag() {
        try{
        JspWriter out = pageContext.getOut();
        out.println("<!DOCTYPE html>"+
        "<html>"+
    "<head>"+
   "<meta charset=\"utf-8\">"+
       "<title>Transport MS</title>"+
       "<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">"+
      

       "<link href=\"img/favicon.ico\" rel=\"icon\">"+

       "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">"+
       "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>"+
       "<link href=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">"+

       "<link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">"+
       "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">"+

       "<link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">"+
       "<link href=\"lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />"+

       "<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">"+

       "<link href=\"css/style.css\" rel=\"stylesheet\">"+
       "</head>"+
        "    <body><h1 class=\"text-primary\"style=\"text-align:center;\">" + applicationLabel + "<br/>"  + DateFormat.getDateInstance().format(date) + "<br/> " + "</h1>");
}
 catch(IOException ioe) {
            System.out.println("Error in HeadingTag: " + ioe);
        }

        return(EVAL_BODY_INCLUDE); // Include tag body
    }

    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();
            out.print("</SPAN></TABLE>");
        } catch(IOException ioe) {
            System.out.println("Error in HeadingTag: " + ioe);
        }
        return(EVAL_PAGE); // Continue with rest of JSP page
    }

    public String getApplicationLabel() {
        return applicationLabel;
    }

    public void setApplicationLabel(String applicationLabel) {
        this.applicationLabel = applicationLabel;
    }
     public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}