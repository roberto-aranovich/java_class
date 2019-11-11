package com.origami.teach.servlet;

import org.junit.Test;
import javax.servlet.ServletException;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class servletStockSearchClass {
    @Test
    public void testServlet() throws IOException, ServletException {
      ServletStockSearch myServlet = new ServletStockSearch();
        assertNotNull( myServlet );
    }
}
