
package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.DeliveryBean;
import com.sunilos.p4.model.DeliveryModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/DeliveryReportCtl")
public class DeliveryReportCtl extends BaseReportCtl<DeliveryBean> {

    @Override
    public List<DeliveryBean> getList() {

        DeliveryModel model = new DeliveryModel();

        @SuppressWarnings("unchecked")
        List<DeliveryBean> deliveryList = model.list();
System.out.println("deliveryList"+deliveryList);
        return deliveryList;
    }

    @Override
    public String getView() {
        return ORSView.DELIVERY_REPORT_VIEW;
    }

    @Override
    public String getCompiledReportKey() {
        return "DELIVERY_LIST_COMPILE_REPORT";
    }
}
