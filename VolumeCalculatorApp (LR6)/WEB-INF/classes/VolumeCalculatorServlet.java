import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VolumeCalculatorServlet extends HttpServlet {

    public VolumeCalculatorServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        this.preventCaching(request, response);
        PrintWriter out = response.getWriter();

        String shape = request.getParameter("shape");
        double volume = 0.0;

        try {
            if ("cube".equals(shape)) {
                double side = Double.parseDouble(request.getParameter("side"));
                volume = Math.pow(side, 3);
            } else if ("sphere".equals(shape)) {
                double radius = Double.parseDouble(request.getParameter("radius"));
                volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
            }
            // Добавьте другие формы по аналогии

            out.println("<html><body>");
            out.println("<h1>Volume of " + shape + " is: " + volume + "</h1>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1>Invalid parameters</h1>");
            out.println("</body></html>");
        }

        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void preventCaching(HttpServletRequest request, HttpServletResponse response) {
        String protocol = request.getProtocol();
        if ("HTTP/1.0".equalsIgnoreCase(protocol)) {
            response.setHeader("Pragma", "no-cache");
        } else if ("HTTP/1.1".equalsIgnoreCase(protocol)) {
            response.setHeader("Cache-Control", "no-cache");
        }
        response.setDateHeader("Expires", 0);
    }
}
