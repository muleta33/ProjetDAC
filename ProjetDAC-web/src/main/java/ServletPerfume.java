/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ensimag.projetDAC.entity.Bottle;
import com.ensimag.projetDAC.entity.BottleType;
import com.ensimag.projetDAC.entity.Capacity;
import com.ensimag.projetDAC.entity.DeliveryMethod;
import com.ensimag.projetDAC.entity.DeliveryStatus;
import com.ensimag.projetDAC.entity.Fragrance;
import com.ensimag.projetDAC.entity.FragranceCategory;
import com.ensimag.projetDAC.entity.Inscription;
import com.ensimag.projetDAC.entity.Perfume;
import com.ensimag.projetDAC.entity.Purchase;
import com.ensimag.projetDAC.entity.Role;
import com.ensimag.projetDAC.entity.Role.ROLE;
import com.ensimag.projetDAC.entity.SprayerType;
import com.ensimag.projetDAC.entity.User;
import com.ensimag.projetDAC.stateless.BottleFacadeLocal;
import com.ensimag.projetDAC.stateless.BottleTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.CapacityFacadeLocal;
import com.ensimag.projetDAC.stateless.DeliveryMethodFacadeLocal;
import com.ensimag.projetDAC.stateless.DeliveryStatusFacadeLocal;
import com.ensimag.projetDAC.stateless.FragranceCategoryFacadeLocal;
import com.ensimag.projetDAC.stateless.FragranceFacadeLocal;
import com.ensimag.projetDAC.stateless.InscriptionFacadeLocal;
import com.ensimag.projetDAC.stateless.PerfumeFacadeLocal;
import com.ensimag.projetDAC.stateless.PurchaseFacadeLocal;
import com.ensimag.projetDAC.stateless.RoleFacadeLocal;
import com.ensimag.projetDAC.stateless.SprayerTypeFacadeLocal;
import com.ensimag.projetDAC.stateless.UserFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private FragranceCategoryFacadeLocal fraganceCategoryFacade;
    @EJB
    private BottleTypeFacadeLocal bottleTypeFacade;
    @EJB
    private BottleFacadeLocal bottleFacade;
    @EJB
    private UserFacadeLocal userFacade;
    @EJB
    private RoleFacadeLocal roleFacade;
    @EJB
    private DeliveryMethodFacadeLocal deliveryMethodFacade;
    @EJB
    private DeliveryStatusFacadeLocal deliveryStatusFacade;
    @EJB
    private PurchaseFacadeLocal purchaseFacadeLocal;
      

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
        FragranceCategory cat1 = new FragranceCategory("Fruitées");
        fraganceCategoryFacade.create(cat1);
        FragranceCategory cat2 = new FragranceCategory("Orientales");
        fraganceCategoryFacade.create(cat2);
        FragranceCategory cat3 = new FragranceCategory("Fleuries");
        fraganceCategoryFacade.create(cat3);
        FragranceCategory cat4 = new FragranceCategory("Sucrées");
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
        fragances.add(f14);
        fragances.add(f8);
        Inscription inscription = new Inscription("La vie est chouette");
        inscriptionFacade.create(inscription);
        Bottle bottle = new Bottle(bt1, c3, st1, inscription);
        bottleFacade.create(bottle);
        Perfume p1;
        p1 = new Perfume("La vie est chouette", fragances, 2, bottle, true, true);
        perfumeFacade.create(p1);
        
        // Création d'un second parfum
        fragances = new ArrayList<>();
        fragances.add(f7);
        fragances.add(f4);
        fragances.add(f15);
        inscription = new Inscription("J'adoooore");
        inscriptionFacade.create(inscription);
        bottle = new Bottle(bt5, c2, st2, inscription);
        bottleFacade.create(bottle);
        Perfume p2;
        p2 = new Perfume("J'adoooore", fragances, 3, bottle, true, true);
        perfumeFacade.create(p2);
        
        // Création d'un troisième parfum
        fragances = new ArrayList<>();
        fragances.add(f2);
        fragances.add(f11);
        inscription = new Inscription("La nuit du mâle");
        inscriptionFacade.create(inscription);
        bottle = new Bottle(bt2, c1, st3, inscription);
        bottleFacade.create(bottle);
        Perfume p3;
        p3 = new Perfume("La nuit du mâle", fragances, 3, bottle, true, true);
        perfumeFacade.create(p3);
        
        // Création d'un quatrième parfum
        fragances = new ArrayList<>();
        fragances.add(f7);
        fragances.add(f15);
        inscription = new Inscription("Bleu de Perfume", "Arial");
        inscriptionFacade.create(inscription);
        bottle = new Bottle(bt5, c3, st1, inscription);
        bottleFacade.create(bottle);
        Perfume p4;
        p4 = new Perfume("Bleu de Perfume", fragances, 2, bottle, true, true);
        perfumeFacade.create(p4);
        
        //Création des rôles
        Role userRole = new Role(ROLE.USER);
        roleFacade.create(userRole);
        Role managerRole = new Role(ROLE.MANAGER);
        roleFacade.create(managerRole);
        
        // Création d'utilisateurs
        String password = "ensimag";
        char[] pass = password.toCharArray();
        User user = new User("user@gmail.com", "LastName", "FirstName", pass, userRole);
        userFacade.create(user);
        User secondUser = new User("second-user@gmail.com", "LastName", "FirstName", pass, userRole);
        userFacade.create(secondUser);
        User manager = new User("manager@gmail.com", "LastName", "FirstName", pass, managerRole);
        userFacade.create(manager);
        
        // Ajout de méthodes de livraison
        DeliveryMethod dm1 = new DeliveryMethod("Normal", 0);
        deliveryMethodFacade.create(dm1);
        DeliveryMethod dm2 = new DeliveryMethod("Express", 20);
        deliveryMethodFacade.create(dm2);
        
        // Ajout de statuts de livraison
        DeliveryStatus ds1 = new DeliveryStatus("en attente");
        deliveryStatusFacade.create(ds1);
        DeliveryStatus ds2 = new DeliveryStatus("en cours de préparation");
        deliveryStatusFacade.create(ds2);
        DeliveryStatus ds3 = new DeliveryStatus("expédiée");
        deliveryStatusFacade.create(ds3);
        DeliveryStatus ds4 = new DeliveryStatus("reçue");
        deliveryStatusFacade.create(ds4);
        
        
        //Purchase(User client, Date purchaseDate, Map<Perfume, Integer> perfumes, DeliveryMethod deliveryMethod, String deliveryAddress, DeliveryStatus deliveryStatus, double price)
        Map<Perfume, Integer> perfumes = new HashMap<>();
        perfumes.put(p1, 1);
        Purchase purchase = new Purchase(user, new Date(),perfumes , dm1, "Grenoble", ds1, 100.0);
        purchaseFacadeLocal.create(purchase);
        
        Purchase purchase2 = new Purchase(user, new Date(),perfumes , dm1, "Paris", ds2, 100.0);
        purchaseFacadeLocal.create(purchase2);


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
