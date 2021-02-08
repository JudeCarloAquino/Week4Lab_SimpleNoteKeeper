/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author DiegoWR
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        String contents = br.readLine();
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        request.setAttribute("contents", note);
        
        String edit = request.getParameter ("edit");
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
            .forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        String titleField = request.getParameter("titleField");
        String contentsArea = request.getParameter("contentsArea");
        
       
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        pw.println(titleField);
        pw.println(contentsArea);
        
        pw.close();
        
        Note note = new Note(titleField, contentsArea);
        request.setAttribute("note", note);
        request.setAttribute("contents", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
        .forward(request, response);
    }
}