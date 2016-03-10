/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ensimag.projetDAC.entity.Bottle;
import com.ensimag.projetDAC.entity.BottleType;
import com.ensimag.projetDAC.entity.Capacity;
import com.ensimag.projetDAC.entity.Fragrance;
import com.ensimag.projetDAC.entity.FraganceCategory;
import com.ensimag.projetDAC.entity.Inscription;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.Role;
import com.ensimag.projetDAC.entity.SprayerType;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.BottleFacadeLocal;
import com.ensimag.projetDAC.stateless.BottleTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.CapacityFacadeLocal;
import com.ensimag.projetDAC.stateless.FraganceCategoryFacadeLocal;
import com.ensimag.projetDAC.stateless.FragranceFacadeLocal;
import com.ensimag.projetDAC.stateless.InscriptionFacadeLocal;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.RoleFacadeLocal;
import com.ensimag.projetDAC.stateless.SprayerTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
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
    private CapacityFacadeLocal capacityFacade;
    @EJB
    private SprayerTypeFacadeLocal sprayerTypeFacade;
    @EJB
    private PerfumeFacadeLocal perfumeFacade;
    @EJB
    private InscriptionFacadeLocal inscriptionFacade;
    @EJB
    private FragranceFacadeLocal fraganceFacade;
    @EJB
    private FraganceCategoryFacadeLocal fraganceCategoryFacade;
    @EJB
    private BottleTypeFacadeLocal bottleTypeFacade;
    @EJB
    private BottleFacadeLocal bottleFacade;
    @EJB
    private UserFacadeLocal userFacade;
    @EJB
    private RoleFacadeLocal roleFacade;
      

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
        // Création des catégories de senteurs
        FraganceCategory cat1 = new FraganceCategory("Fruitées");
        fraganceCategoryFacade.create(cat1);
        FraganceCategory cat2 = new FraganceCategory("Orientales");
        fraganceCategoryFacade.create(cat2);
        FraganceCategory cat3 = new FraganceCategory("Fleuries");
        fraganceCategoryFacade.create(cat3);
        FraganceCategory cat4 = new FraganceCategory("Sucrées");
        fraganceCategoryFacade.create(cat4);
        
        // Création des senteurs
        Fragrance f1 = new Fragrance("Ananas tropical", cat1);
        fraganceFacade.create(f1);
        Fragrance f2 = new Fragrance("Framboises des bois", cat1);
        fraganceFacade.create(f2);
        Fragrance f3 = new Fragrance("Noix de coco", cat1);
        fraganceFacade.create(f3);
        Fragrance f4 = new Fragrance("Mandarine", cat1);
        fraganceFacade.create(f4);
        
        Fragrance f5 = new Fragrance("Epices douces", cat2);
        fraganceFacade.create(f5);
        Fragrance f6 = new Fragrance("Ambre orientale", cat2);
        fraganceFacade.create(f6);
        Fragrance f7 = new Fragrance("Musc blanc", cat2);
        fraganceFacade.create(f7);
        Fragrance f8 = new Fragrance("Patchouli d'Inde", cat2);
        fraganceFacade.create(f8);
        
        Fragrance f9 = new Fragrance("Fleur d'oranger", cat3);
        fraganceFacade.create(f9);
        Fragrance f10 = new Fragrance("Feuilles de violette", cat3);
        fraganceFacade.create(f10);
        Fragrance f11 = new Fragrance("Jasmin blanc", cat3);
        fraganceFacade.create(f11);
        Fragrance f12 = new Fragrance("Orchidée", cat3);
        fraganceFacade.create(f12);
        
        Fragrance f13 = new Fragrance("Fraise tagada", cat4);
        fraganceFacade.create(f13);
        Fragrance f14 = new Fragrance("Amande douce", cat4);
        fraganceFacade.create(f14);
        Fragrance f15 = new Fragrance("Barbe à papa", cat4);
        fraganceFacade.create(f15);
        Fragrance f16 = new Fragrance("Glace vanille", cat4);
        fraganceFacade.create(f16);
        
        // Création des capacités
        Capacity c1 = new Capacity(30, 40);
        capacityFacade.create(c1);
        Capacity c2 = new Capacity(50, 60);
        capacityFacade.create(c2);
        Capacity c3 = new Capacity(100, 100);
        capacityFacade.create(c3);
        Capacity c4 = new Capacity(150, 130);
        capacityFacade.create(c4);
        
        // Création des modèles
        BottleType bt1 = new BottleType("Angie");
        bottleTypeFacade.create(bt1);
        BottleType bt2 = new BottleType("Eclat");
        bottleTypeFacade.create(bt2);
        BottleType bt3 = new BottleType("Charm");
        bottleTypeFacade.create(bt3);
        BottleType bt4 = new BottleType("Challenge");
        bottleTypeFacade.create(bt4);
        BottleType bt5 = new BottleType("Jazzy");
        bottleTypeFacade.create(bt5);
        
        // Création des types de pulvérisateur
        SprayerType st1 = new SprayerType("Diffuseur");
        sprayerTypeFacade.create(st1);
        SprayerType st2 = new SprayerType("Spray");
        sprayerTypeFacade.create(st2);
        SprayerType st3 = new SprayerType("Vaporisateur");
        sprayerTypeFacade.create(st3);
        
        // Création d'un premier parfum
        List<Fragrance> fragances = new ArrayList<>();
        fragances.add(f1);
        fragances.add(f2);
        Inscription inscription = new Inscription("La vie est chouette", "Arial");
        inscriptionFacade.create(inscription);
        Bottle bottle = new Bottle(bt5, c2, st1, inscription);
        bottleFacade.create(bottle);
        Perfume p;
        p = new Perfume("La vie est chouette", fragances, 2, bottle, true);
        perfumeFacade.create(p);
        
        // Création d'utilisateurs
        String password = "ensimag";
        char[] pass = password.toCharArray();
        User user = new User("user@gmail.com", "LastName", "FirstName", pass, Role.ROLE.USER);
        userFacade.create(user);
        User secondUser = new User("second-user@gmail.com", "LastName", "FirstName", pass, Role.ROLE.USER);
        userFacade.create(secondUser);

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
