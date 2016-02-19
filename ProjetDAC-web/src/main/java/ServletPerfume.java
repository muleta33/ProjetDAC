/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ensimag.projetDAC.entity.Bottle;
import com.ensimag.projetDAC.entity.BottleType;
import com.ensimag.projetDAC.entity.Fragance;
import com.ensimag.projetDAC.entity.FraganceCategory;
import com.ensimag.projetDAC.entity.Inscription;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.SprayerType;
import com.ensimag.projetDAC.stateless.BottleFacadeLocal;
import com.ensimag.projetDAC.stateless.BottleTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.FraganceCategoryFacadeLocal;
import com.ensimag.projetDAC.stateless.FraganceFacadeLocal;
import com.ensimag.projetDAC.stateless.InscriptionFacadeLocal;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.SprayerTypeFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author muleta
 */
@WebServlet(urlPatterns = {"/init"})
public class ServletPerfume extends HttpServlet {
    
    @EJB
    private SprayerTypeFacadeLocal sprayerTypeFacade;
    @EJB
    private PerfumeFacadeLocal perfumeFacade;
    @EJB
    private InscriptionFacadeLocal inscriptionFacade;
    @EJB
    private FraganceFacadeLocal fraganceFacade;
    @EJB
    private FraganceCategoryFacadeLocal fraganceCategoryFacade;
    @EJB
    private BottleTypeFacadeLocal bottleTypeFacade;
    
    @EJB
    private BottleFacadeLocal bottleFacade;
      

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
            out.println("<title>Servlet ServletParfum</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletParfum at " + request.getContextPath() + "</h1>");
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
        FraganceCategory cat1 = new FraganceCategory("Fleuries");
        fraganceCategoryFacade.create(cat1);
        Fragance f1 = new Fragance("Orchidée", cat1);
        fraganceFacade.create(f1);
        FraganceCategory cat2 = new FraganceCategory("Sucrées");
        fraganceCategoryFacade.create(cat2);
        Fragance f2 = new Fragance("Glace vanille", cat2);
        fraganceFacade.create(f2);
        List<Fragance> fragances = new ArrayList<>();
        fragances.add(f1);
        fragances.add(f2);
        BottleType bottleType = new BottleType("Jazzy");
        bottleTypeFacade.create(bottleType);
        SprayerType sprayerType = new SprayerType("Diffuseur");
        sprayerTypeFacade.create(sprayerType);
        Inscription inscription = new Inscription("La vie est chouette", "Arial");
        inscriptionFacade.create(inscription);
        Bottle bottle = new Bottle(bottleType, 50, sprayerType, inscription);
        bottleFacade.create(bottle);
        Perfume p;
        p = new Perfume("La vie est chouette", fragances, 2, bottle, true);
        perfumeFacade.create(p);
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
