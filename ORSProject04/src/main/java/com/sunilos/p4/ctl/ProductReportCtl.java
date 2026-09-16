package com.sunilos.p4.ctl;

import java.util.List;

import com.sunilos.p4.bean.ProductBean;
import com.sunilos.p4.model.ProductModel;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ctl/ProductReportCtl")
public class ProductReportCtl extends BaseReportCtl<ProductBean>{

	@Override
	public List<ProductBean> getList() {
		ProductModel model = new ProductModel();
		List<ProductBean> products = model.list();
		return products;
	}

	
	@Override
	public String getView() {
		// TODO Auto-generated method stub
		return ORSView.PRODUCT_REPORT_VIEW;
	}

	@Override
	public String getCompiledReportKey() {
		return "PRODUCT_LIST_COMPILE_REPORT";
	}

	
}
