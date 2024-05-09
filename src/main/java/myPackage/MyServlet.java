package myPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet called: doGet");

        try {
            // Parse request parameters
            double operand1 = Double.parseDouble(request.getParameter("operand1"));
            double operand2 = Double.parseDouble(request.getParameter("operand2"));
            String operation = request.getParameter("operation");

            System.out.println("Received input: " + operand1 + ", " + operand2 + ", " + operation);

            // Perform calculation using Calculator class
            Calculator calculator = new Calculator();
            double result = calculator.performOperation(operand1, operand2, operation);

            // Set result attribute for forwarding to index.jsp
            request.setAttribute("result", result);
        } catch (NumberFormatException e) {
            // Handle NumberFormatException (e.g., if operand1 or operand2 is not a valid number)
            System.err.println("Error: Invalid number format in request parameters");
            request.setAttribute("error", "Invalid number format");
        } catch (IllegalArgumentException e) {
            // Handle IllegalArgumentException (e.g., if operation type is invalid)
            System.err.println("Error: " + e.getMessage());
            request.setAttribute("error", e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions
            System.err.println("Error: An unexpected error occurred");
            e.printStackTrace(); // Print stack trace for debugging
            request.setAttribute("error", "An unexpected error occurred");
        }

        // Forward the request to index.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
