package com.ztiany.customer.web.controller;

import com.ztiany.customer.constants.Constants;
import com.ztiany.customer.domain.Customer;
import com.ztiany.customer.service.BusinessService;
import com.ztiany.customer.service.impl.BusinessServiceImpl;
import com.ztiany.customer.utils.CommonUtil;
import com.ztiany.customer.web.bean.CustomerFormBean;
import com.ztiany.customer.web.bean.Page;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ztiany
 * Email ztiany3@gmail.com
 * Date 18.4.26 23:00
 */
public class ControllerServlet extends HttpServlet {

    private BusinessService mBusinessService = new BusinessServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommonUtil.setUTF8Encode(request, response);
        String operation = request.getParameter(Constants.OP_KEY);
        switch (operation) {
            case Constants.ACTION_SHOW: {
                doShowList(request, response);
                break;
            }
            case Constants.ACTION_ADD: {
                doAddCustomer(request, response);
                break;
            }
            case Constants.ACTION_DELETE: {
                deleteCustomer(request, response);
                break;
            }
            case Constants.ACTION_DELETE_MULTI: {
                deleteMultiCustomer(request, response);
                break;
            }
            case Constants.ACTION_EDIT: {
                showEditUI(request, response);
                break;
            }
            case Constants.ACTION_UPDATE: {
                doUpdateCustomer(request, response);
                break;
            }
        }
    }

    private void showEditUI(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String customerId = request.getParameter("customerId");
        Customer customer = mBusinessService.findCustomer(customerId);

        if (customer != null) {
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        } else {
            response.getWriter().write("???????????????");
        }
    }

    private void doUpdateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomerFormBean customerFormBean = buildCustomerFormBean(request, response);
        if (customerFormBean == null) {
            return;
        }

        try {
            Customer customer = buildCustomer(customerFormBean);
            mBusinessService.updateCustomer(customer);
            response.sendRedirect(request.getContextPath());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            response.getWriter().write("????????????");
        }
    }

    private void deleteMultiCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] ids = request.getParameterValues("ids");
        if (ids != null && ids.length > 0) {
            for (String customerId : ids) {
                mBusinessService.deleteCustomer(customerId);
            }
        }
        response.sendRedirect(request.getContextPath());
    }

    //??????????????????
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String customerId = request.getParameter("customerId");
        mBusinessService.deleteCustomer(customerId);
        response.sendRedirect(request.getContextPath());
    }

    private void doAddCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomerFormBean customerFormBean = buildCustomerFormBean(request, response);
        if (customerFormBean == null) {
            return;
        }

        try {
            Customer customer = buildCustomer(customerFormBean);
            mBusinessService.addCustomer(customer);
            response.sendRedirect(request.getContextPath());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            response.getWriter().write("????????????");
        }
    }

    private Customer buildCustomer(CustomerFormBean customerFormBean) throws InvocationTargetException, IllegalAccessException {
        Customer customer = new Customer();
        CommonUtil.copyProperties(customer, customerFormBean);
        //??????????????????
        String hobby[] = customerFormBean.getHobby();
        if (hobby != null && hobby.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hobby.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(hobby[i]);
            }
            customer.setHobbies(sb.toString());
        }
        return customer;
    }

    private CustomerFormBean buildCustomerFormBean(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomerFormBean customerFormBean = CommonUtil.fillBeanFromRequest(request, CustomerFormBean.class);
        if (customerFormBean == null || !customerFormBean.validate()) {
            //????????????(?????????add.jsp??????)??????????????????
            request.setAttribute("form", customerFormBean);
            //??????
            response.getWriter().write("??????????????????");
            return null;
        }
        return customerFormBean;
    }


    private void doShowList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNum");

        Page<Customer> customerPage = mBusinessService.queryPage(pageNo);

        customerPage.setUrl("/servlet/ControllerServlet?" + Constants.OP_KEY + "=" + Constants.ACTION_SHOW);

        request.setAttribute("page", customerPage);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listAll.jsp");
        requestDispatcher.forward(request, response);
    }
}
