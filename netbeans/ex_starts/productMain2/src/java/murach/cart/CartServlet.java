package murach.cart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import murach.data.*;
import murach.business.*;

public class CartServlet extends HttpServlet {

 
    // Receive request
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        

        ServletContext sc = getServletContext();
        
        // Get session
        HttpSession session = request.getSession();
        
        // Make ProductIO available
        String path = sc.getRealPath("/WEB-INF/products.txt");
        ProductIO.init(path);

        // Get what the servlet is being asked to do
        String action = request.getParameter("action");
        
        // If the action is to displayProducts
        if (action.equals("displayProducts")) {
            
            // Create a product to return           
            Product product = new Product();
            LineItem lineItem = new LineItem();
            
            // Store products in an array "products"
            ArrayList<Product> products = ProductIO.getProducts(path);

            // Store product as a line item
            lineItem.setProduct(product);
            products.add(product);
                        
            // Set the attributes products so that jsp has info about it
            session.setAttribute("products", products);
            
            // Redirect to cart.jsp
            String url = "/cart.jsp";
            sc.getRequestDispatcher(url)
                .forward(request, response);
            
        }
        
        else if (action.equals("editProduct")) {
            
            // Determine product code
            String urlCode = request.getParameter("code");
            
            // Get description/price of known urlCode from ProductIO/Product.java
            Product product = ProductIO.selectProduct(urlCode);
            String code = product.getCode();
            String description = product.getDescription();
            Double price = product.getPrice();
                       
            // Set the attributes products so that jsp has info about it
            session.setAttribute("product", product);
            session.setAttribute("code", code);
            session.setAttribute("description", description);
            session.setAttribute("price", price);
            
            // Redirect
            String url = "/addEdit.jsp";
            sc.getRequestDispatcher(url)
                .forward(request, response);
        }   
        
        else if (action.equals("updateProduct")) {
            
            // Determine product attributes
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String  newPrice = request.getParameter("price");

            // Convert price into into useable value             
            Double price = Double.parseDouble(newPrice);
            
            //Create new product to store updated values
            Product product = new Product();

            product.setDescription(description);
            product.setPrice(price);
            product.setCode(code);

            // Call update if Edit was selected
            // Call insert if Add was selected
            if (ProductIO.exists(code)) {
                ProductIO.updateProduct(product);
            } else {
                ProductIO.insertProduct(product);
            }
            
            
            session.setAttribute("product", product);

            // Redirect
            String url = "/addEdit.jsp";
            sc.getRequestDispatcher(url)
            .forward(request, response);
        }
        
        else if (action.equals("viewProducts")) {
            String url = "/cart.jsp";
            sc.getRequestDispatcher(url)
            .forward(request, response);
        }
        
        else if (action.equals("deleteProduct")) {
            
            // Determine product code
            String code = request.getParameter("code");
            
            // Get description/price of known urlCode from ProductIO/Product.java
            Product product = ProductIO.selectProduct(code);
            String description = product.getDescription();
            Double price = product.getPrice();
                       
            // Set the attributes products so that jsp has info about it
            session.setAttribute("product", product);
            session.setAttribute("code", code);
            session.setAttribute("description", description);
            session.setAttribute("price", price);
            
            String url = "/delete.jsp";
            
            sc.getRequestDispatcher(url)
                .forward(request, response);
        }
        
        else if (action.equals("yesDelete")) {
            
            // Determine product code
            String code = request.getParameter("code");
            
            // Get description/price of known urlCode from ProductIO/Product.java
            String description = request.getParameter("description");
            String  newPrice = request.getParameter("price");

            // Delete product
            Product product = ProductIO.selectProduct(code);
            ProductIO.deleteProduct(product);
            ArrayList<Product> products = ProductIO.selectProducts();
            session.setAttribute("products", products);

            // Redirect
            String url = "/cart.jsp";
            sc.getRequestDispatcher(url)
            .forward(request, response);
        }
        
        else if (action.equals("addProduct")) {
            String url = "/addProduct.jsp";
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