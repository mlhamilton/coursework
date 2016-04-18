package music.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

//Probably don't need this in this app
//import music.data.ProductIO;
import music.data.ProductDB;
import music.business.Product;

public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //sets cookie?
        HttpSession session = request.getSession();
        
        //generates list of products from murach db
        List<Product> products = ProductDB.selectProducts();
        session.setAttribute("products", products);
        

        String url = "/index.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
