package patterns.compound.dj;

import java.io.IOException;

public class DJViewServlet extends HttpSevlet {

    /**
     * 当Servlet第一次创建时，init()方法会被调用
     *
     * @throws ServletException
     */
    public void init() throws ServletException {
        BeatModel beatModel = new BeatModel();
        beatModel.initialize();
        // 传入一个beatModel的引用给ServletContext，好让ServletContext可以访问beatModel
        getServletContext().setAttribute("beatModel", beatModel);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        BeatModel beatModel = (BeatModel) getServletContext().getAttribute("beatModel");
        String bpm = request.getParameter("bpm");
        if (bpm == null) bpm = beatModel.getBPM() + "";

        String set = request.getParameter("set");
        if (set != null) {
            int bpmNumber = 90;
            bpmNumber = Integer.parseInt(bpm);
            beatModel.setBPM(bpmNumber);
        }

        String decrease = request.getParameter("decrease");
        if (decrease != null) beatModel.setBPM(beatModel.getBPM() - 1);
        String increase = request.getParameter("increase");
        if (increase != null) beatModel.setBPM(beatModel.getBPM() + 1);

        String on = request.getParameter("on");
        if (on != null) beatModel.start();
        String off = request.getParameter("off");
        if (off != null) beatModel.stop();

        request.setAttribute("beatModel", beatModel);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/DJView.jsp");
        dispatcher.forward(request, response);
    }
}
