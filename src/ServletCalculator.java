import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ADD")

public class ServletCalculator extends HttpServlet {

    private final String ACCEPTABLE_PATTERN ="^[0-9]{1,10}$";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        getSum(req, resp);
        System.out.println("doPost");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        getSum(req, resp);
        System.out.println("doGet");
    }
    private void getSum(HttpServletRequest req, HttpServletResponse resp) {
        String firstNum =req.getParameter("firstNum");
        String secondNum = req.getParameter("secondNum");
        int sum;
        try {
            if(firstNum.matches(ACCEPTABLE_PATTERN) && secondNum.matches(ACCEPTABLE_PATTERN)) {
                sum=Integer.parseInt(firstNum) + Integer.parseInt(secondNum);
                resp.getOutputStream().println("<body style=\"background: radial-gradient(greenyellow,orangered); background-size: 1920px 1080px\"><h1 style=\"color: white\">The sum is: " + sum +"</h1>");
            }
            else resp.getOutputStream().println("<body style=\"background: radial-gradient(greenyellow,orangered); background-size: 1920px 1080px\"><h1 style=\"color: white\">Invalid input was provided</h1></body>");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
