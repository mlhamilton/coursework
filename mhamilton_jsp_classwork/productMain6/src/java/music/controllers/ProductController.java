package music.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import music.business.*;
import music.data.*;
import music.util.*;

public class ProductController extends HttpServlet {

    private static final String defaultURL = "/admin/cart.jsp";
    private static final String editItemURL = "/admin/editPage.jsp";

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String url = "/error_404.jsp";

        if (requestURI.endsWith("/showCart")) {
            url = showCart(request, response);
        } else if (requestURI.endsWith("/addItem")) {
            url = addItem(request, response);
        } else if (requestURI.endsWith("/updateItem")) {
            url = updateItem(request, response);
        } else if (requestURI.endsWith("/removeItem")) {
            url = removeItem(request, response);
        } else if (requestURI.endsWith("/edit")) {
            url = edit(request, response);
        } else if (requestURI.endsWith("/editItem")) {
            url = editItem(request, response);
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String url = defaultURL;

        if (requestURI.endsWith("/showCart")) {
            showCart(request, response);
        } else if (requestURI.endsWith("/addPage")) {
            url = "/admin/addPage.jsp";
        } else if (requestURI.endsWith("/addItem")) {
            addItem(request, response);
        } else if (requestURI.endsWith("/edit")) {
            url = "/admin/editPage.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String showCart(HttpServletRequest request,
            HttpServletResponse response) {

        List<Product> products = new ArrayList<>();
        products = ProductDB.selectProducts();

        //Should I be storing this in the session like this?
        request.getSession().setAttribute("products", products);

        return defaultURL;
    }

    private String addItem(HttpServletRequest request,
            HttpServletResponse response) {

        String code = "";
        String description = "";
        Double price = 0.00;
        Product product = new Product();
        // Create product object from request
        code = request.getParameter("code");
        description = request.getParameter("description");
        String newPrice = request.getParameter("price");
        price = Double.parseDouble(newPrice);

        product.setCode(code);
        product.setDescription(description);
        product.setPrice(price);

        //Send product to ProductDB to add to DB
        ProductDB.insert(product);

        return "/product/showCart";
    }

    private String updateItem(HttpServletRequest request,
            HttpServletResponse response) {

        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Product product = ProductDB.selectProduct(productCode);
        ProductDB.update(product);

        return defaultURL;
    }

    private String removeItem(HttpServletRequest request,
            HttpServletResponse response) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String productCode = request.getParameter("productCode");
        Product product = ProductDB.selectProduct(productCode);
        ProductDB.delete(product);
        return "/product/showCart";
    }

    private String edit(HttpServletRequest request,
            HttpServletResponse response) {

        // Determine product code
        HttpSession session = request.getSession();
        String pcode = request.getParameter("productCode");

        // Get product from db and unpack values
        Product product = ProductDB.selectProduct(pcode);
        Long id = product.getId();
        String code = product.getCode();
        String description = product.getDescription();
        Double price = product.getPrice();

        // Set to product
        product.setId(id);
        product.setDescription(description);
        product.setPrice(price);
        product.setCode(code);

        // Send product
        session.setAttribute("product", product);

        return editItemURL;
    }

    private String editItem(HttpServletRequest request,
            HttpServletResponse response) {

        HttpSession session = request.getSession();

        // Get values from jsp
        String pid = request.getParameter("id");
        Long id = Long.parseLong(pid);
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String newPrice = request.getParameter("price");
        Double price = Double.parseDouble(newPrice);

        // Check if fields are empty
        if (code == null || description == null || newPrice == null
                || code.isEmpty() || description.isEmpty() || newPrice.isEmpty()) {
            String message = "Please fill out the required fields.";
            String star = "*";
            session.setAttribute("message", message);
            session.setAttribute("star", star);
        } else {

            //Updates object info in JSP
            Product product = new Product();
            product.setId(id);
            product.setDescription(description);
            product.setPrice(price);
            product.setCode(code);

            //Call update SQL method
            ProductDB.update(product);

            // Set the attributes products so that jsp has info about it
            session.setAttribute("product", product);

            //Update message
            String updated_message = "Record Updated!";
            session.setAttribute("updated_message", updated_message);
        }
        return editItemURL;
    }
}
