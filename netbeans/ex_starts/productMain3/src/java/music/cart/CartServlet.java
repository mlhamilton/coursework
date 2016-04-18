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

        //P3 Edit: This draws info from text file, not db
        // Make ProductIO available
        //String path = sc.getRealPath("/WEB-INF/products.txt");
        //ProductIO.init(path);
        // Get what the servlet is being asked to do
        String action = request.getParameter("action");

        // Set default URL
        String url = "/cart.jsp";

        // If the action is to displayProducts
        if (action.equals("displayProducts")) {
            // Redirect to cart.jsp
            url = "/cart.jsp";

            // Store products in an array "products"
            //ArrayList<Product> products = ProductDB.selectProducts();
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
            Product product = ProductDB.selectProduct(urlCode);
            String code = product.getCode();
            String description = product.getDescription();
            Double price = product.getPrice();

            // Set the attributes products so that jsp has info about it
            session.setAttribute("product", product);
            session.setAttribute("code", code);
            session.setAttribute("description", description);
            session.setAttribute("price", price);

            sc.getRequestDispatcher(url)
                    .forward(request, response);
        } else if (action.equals("updateProduct")) {

            // Determine product attributes
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String newPrice = request.getParameter("price");

            // Convert price into into useable value             
            Double price = Double.parseDouble(newPrice);

            //Create new product to store updated values
            Product product = new Product();

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
                //String updated_message = "Record Updated!";
                //session.setAttribute("updated_message", updated_message);

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

            // Determine product code
            String code = request.getParameter("code");

            // Get description/price of known urlCode from ProductIO/Product.java
            Product product = ProductDB.selectProduct(code);
            String description = product.getDescription();
            Double price = product.getPrice();

            // Set the attributes products so that jsp has info about it
            session.setAttribute("product", product);
            session.setAttribute("code", code);
            session.setAttribute("description", description);
            session.setAttribute("price", price);

            url = "/delete.jsp";

            sc.getRequestDispatcher(url)
                    .forward(request, response);
        } else if (action.equals("yesDelete")) {

            // Determine product code
            String code = request.getParameter("code");

            // Get description/price of known urlCode from ProductIO/Product.java
            String description = request.getParameter("description");
            String newPrice = request.getParameter("price");

            // Delete product
            Product product = ProductDB.selectProduct(code);

            //P3 EDIT - TODO: SQL Query to delete products
            //ProductDB.deleteProduct(product);
            List<Product> products = ProductDB.selectProducts();
            session.setAttribute("products", products);

            // Redirect
            url = "/cart.jsp";
            sc.getRequestDispatcher(url)
                    .forward(request, response);
        } else if (action.equals("addProduct")) {
            url = "/addProduct.jsp";
            sc.getRequestDispatcher(url)
                    .forward(request, response);
        } else if (action.equals("sqlAddProduct")){
            
            // Create product object from request/JSP
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String newPrice = request.getParameter("price");        
            Double price = Double.parseDouble(newPrice);
            Product product = new Product();
            
            //Send product to ProductDB
            ProductDB.addProduct(code, product);
            
            url = "/cart.jsp";
            sc.getRequestDispatcher(url)
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
