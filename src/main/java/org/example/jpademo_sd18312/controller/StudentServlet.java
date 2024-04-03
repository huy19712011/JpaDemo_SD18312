package org.example.jpademo_sd18312.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.jpademo_sd18312.entity.Student;
import org.example.jpademo_sd18312.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {
        "/Students",
        "/Students/insert",
        "/Students/delete",
        "/Students/edit",
        "/Students/update",
        "/Students/new"
})
public class StudentServlet extends HttpServlet {
    private StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            String action = request.getServletPath();
            System.out.println(action);
            switch (action) {
                case "/Students/new":
                    newForm(request, response);
                    break;
                case "/Students/insert":
                    addStudent(request, response);
                    break;
                case "/Students/delete":
                    deleteStudent(request, response);
                    break;
                case "/Students/edit":
                    loadStudent(request, response);
                    break;
                case "/Students/update":
                    updateStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void newForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/addStudentForm.jsp")
                .forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // read student info from form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        if (firstName != null && lastName != null && email != null) {
            Student student = new Student(firstName, lastName, email);
            service.addStudent(student);
        }

        response.sendRedirect("/Students");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getParameter("studentId") != null) {

            String studentId = request.getParameter("studentId");

            service.deleteStudent(studentId);
        }

        response.sendRedirect("/Students");
    }



    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        Student student = service.getStudentById(Integer.parseInt(studentId));
        request.setAttribute("THE_STUDENT", student);
        getServletContext().getRequestDispatcher("/views/updateStudentForm.jsp").forward(request, response);

    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // read data from form
        if (request.getParameter("studentId") != null) {
            int id = Integer.parseInt(request.getParameter("studentId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            Student student = new Student(id, firstName, lastName, email);

            service.updateStudent(student);
        }

        response.sendRedirect("/Students");
    }



    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = service.getAllStudents();

        // send data to .jsp
        request.setAttribute("students", students);
        getServletContext().getRequestDispatcher("/views/studentList.jsp").forward(request, response);
    }
}