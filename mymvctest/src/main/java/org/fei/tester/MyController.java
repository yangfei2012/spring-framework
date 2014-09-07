package org.fei.tester;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController extends AbstractController{

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    private A a;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        a.haha();

        System.out.println("aaaaaaaaaaaa");

        ModelAndView mav = new ModelAndView("ha");
        return mav;
    }
}
