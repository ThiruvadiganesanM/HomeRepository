package ActionClasses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyAction {
public abstract String execute(HttpServletRequest request, HttpServletResponse response);
}
