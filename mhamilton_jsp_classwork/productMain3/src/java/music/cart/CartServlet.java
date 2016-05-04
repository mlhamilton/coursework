package music.cart;

import music.business.Product;
import music.data.ProductDB;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {

    // Receive request
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();

        // Get session
        HttpSession session = request.getSession();

        // Get what the servlet is being asked to do
        String action = request.getParameter("action");

        // Set default URL
        String url = "/cart.jsp";
        String code = "";
        String description = "";
        Double price = null;
        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setPrice(price);
                
        // If the action is to displayProducts
        if (action.equals("displayProducts")) {
            // Redirect to cart.jsp
            url = "/cart.jsp";

            // Store products in an array "products"
            List<Product> products = ProductDB.selectProducts();

            // Set the attributes products so that jsp has info about it
            session.setAttribute("products", products);

            sc.getRequestDispatcher(url)
                    .forward(request, response);

        } else if (action.equals("editProduct")) {

            // Set to the right page
            url = "/editProduct.jsp";

            // Determine product code
            String urlCode = request.getParameter("code");

            // Get description/price of known urlCode from ProductDB
            product = ProductDB.selectProduct(urlCode);
            code = product.getCode();
            description = product.getDescription();
            price = product.getPrice();

            // Set the attributes products so that jsp has info about it
            session.setAttribute("product", product);
            session.setAttribute("code", code);
            session.setAttribute("description", description);
            session.setAttribute("price", price);

            sc.getRequestDispatcher(url)
                    .forward(request, response);
        } else if (action.equals("updateProduct")) {

            // Determine product attributes
            code = request.getParameter("code");
            description = request.getParameter("description");
            String newPrice = request.getParameter("price");

            // Convert price into a useable value             
            price = Double.parseDouble(newPrice);

            //Create new product to store updated values
            product = new Product();

            //Setup required / update messages on click Update
            if (code == null || description == null || newPrice == null
                    || code.isEmpty() || description.isEmpty() || newPrice.isEmpty()) {
                String message = "Please fill out the required fields.";
                String star = "*";
                url = "editProduct.jsp";

                session.setAttribute("message", message);
                session.setAttribute("star", star);
            } else {

                //Update message
                String updated_message = "Record Updated!";
                session.setAttribute("updated_message", updated_message);
                
                //Updates object info in JSP
                product.setDescription(description);
                product.setPrice(price);
                product.setCode(code);

                //Call update SQL method
                ProductDB.updateProduct(code, product);

                // Set the attributes products so that jsp has info about it
                session.setAttribute("product", product);
            }
            
            // Redirect
            url = "/editProduct.jsp";
            sc.getRequestDispatcher(url)
                    .forward(request, response);

        } else if (action.equals("viewProducts")) {
            url = "/cart.jsp";
            sc.getRequestDispatcher(url)
                    .forward(request, response);

        } else if (action.equals("deleteProduct")) {

            url = "/delete.jsp";

            // Determine product code
            String urlCode = request.getParameter("code");

            // Get description/price of known urlCode from ProductDB
            product = ProductDB.selectProduct(urlCode);
            code = product.getCode();
            description = product.getDescription();
            price = product.getPrice();

            // Set the attributes products so that jsp has info about it
            session.setAttribute("product", product);
            session.setAttribute("code", code);
            session.setAttribute("description", description);
            session.setAttribute("price", price);

            sc.getRequestDispatcher(url)
                    .forward(request, response);

        } else if (action.equals("yesDelete")) {
            
            //Get code from jsp and turn it into string code
            code = (String) session.getAttribute("code");
            
            // Get description/price of known urlCode from ProductIO/Product.java
            product = ProductDB.selectProduct(code);
            
            //Delete from DB
            ProductDB.deleteProduct(product);

            //Display updated products
            action = "displayProducts";
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/productMaint?action=displayProducts");

        } else if (action.equals("addProduct")) {
            
            
            url = "/addProduct.jsp";
            session.setAttribute("product", product);
            
            sc.getRequestDispatcher(url)
                    .forward(request, response);
            
        } else if (action.equals("sqlAddProduct")) {

            // Create product object from request
            code = request.getParameter("code");
            description = request.getParameter("description");
            String newPrice = request.getParameter("price");
            price = Double.parseDouble(newPrice);
            
            product.setDescription(description);
            product.setPrice(price);
            product.setCode(code);

            //Send product to ProductDB to add to DB
            ProductDB.addProduct(code, product);
            
            //Display updated products
            action = "displayProducts";
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/productMaint?action=displayProducts");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
