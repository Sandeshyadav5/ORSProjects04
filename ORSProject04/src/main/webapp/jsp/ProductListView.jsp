<%@page import="com.sunilos.p4.bean.ProductBean"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<jsp:useBean id="bean"
    class="com.sunilos.p4.bean.ProductBean"
    scope="request">
</jsp:useBean>

<%
int pageNo = ServletUtility.getPageNo(request);
int pageSize = ServletUtility.getPageSize(request);
int index = ((pageNo - 1) * pageSize) + 1;

List list = ServletUtility.getList(request);
Iterator<ProductBean> it = list.iterator();

String _err = ServletUtility.getErrorMessage(request);
%>

<div class="container-fluid px-4 py-4" style="max-width: 900px;">

    <div class="card border-0 shadow-sm rounded-4 overflow-hidden">

        <!-- Header -->
        <div
            class="card-header text-white border-0 py-3 px-4 d-flex justify-content-between align-items-center"
            style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">

            <h5 class="mb-0 fw-bold">
                <i class="bi bi-cart me-2"></i> Product List
            </h5>

            <div class="d-flex gap-2">

                <!-- PDF -->
                <a href="<%=ORSView.PRODUCT_REPORT_CTL%>"
                   target="_blank"
                   class="btn btn-sm btn-warning fw-semibold">

                    <i class="bi bi-file-earmark-pdf me-1"></i>
                    Print PDF
                </a>

                <!-- DOC -->
                <a href="<%=ORSView.PRODUCT_REPORT_CTL%>?type=doc"
                   target="_blank"
                   class="btn btn-sm btn-info fw-semibold">

                    <i class="bi bi-file-earmark-word me-1"></i>
                    Print DOC
                </a>

                <!-- Add Product -->
                <a href="ProductCtl"
                   class="btn btn-sm btn-light text-primary fw-semibold">

                    <i class="bi bi-cart me-1"></i>
                    Add Product
                </a>

            </div>
        </div>

        <!-- Form -->
        <form action="<%=ORSView.PRODUCT_LIST_CTL%>" method="POST">

            <input type="hidden"
                   name="pageNo"
                   value="<%=pageNo%>">

            <input type="hidden"
                   name="pageSize"
                   value="<%=pageSize%>">

            <!-- Search Area -->
            <div
                class="p-3 bg-light border-bottom d-flex flex-wrap gap-2 align-items-center">

                <input type="text"
                       name="productName"
                       class="form-control form-control-sm"
                       style="max-width: 220px;"
                       placeholder="Search by ProductName"
                       value="<%=ServletUtility.getParameter("productName", request)%>">

                <!-- Search Button -->
                <button type="submit"
                        name="operation"
                        value="<%=BaseCtl.OP_SEARCH%>"
                        class="btn btn-primary btn-sm">

                    <i class="bi bi-search me-1"></i>
                    Search
                </button>

                <!-- Delete Button -->
                <button type="submit"
                        name="operation"
                        value="<%=BaseCtl.OP_DELETE%>"
                        class="btn btn-danger btn-sm ms-auto">

                    <i class="bi bi-trash me-1"></i>
                    Delete Selected
                </button>

            </div>

            <!-- Error Message -->
            <%
            if (_err != null && !_err.isEmpty()) {
            %>

            <div class="alert alert-danger py-2 mx-3 mt-3">

                <i class="bi bi-exclamation-triangle-fill me-2"></i>
                <%=_err%>

            </div>

            <%
            }
            %>

            <!-- Product Table -->
            <div class="table-responsive">

                <table class="table table-hover align-middle mb-0">

                    <thead class="table-dark">

                        <tr>

                            <th width="40">
                                <input type="checkbox"
                                       onclick="document.querySelectorAll('input[name=ids]').forEach(c => c.checked = this.checked)">
                            </th>

                            <th>#</th>

                            <th>ProductName</th>

                            <th>Product Category</th>

                            <th>Order Date</th>

                            <th>Price</th>

                            <th>Edit</th>

                        </tr>

                    </thead>

                    <tbody>

                        <%
                        while (it.hasNext()) {

                            ProductBean productBean = it.next();
                        %>

                        <tr>

                            <!-- Checkbox -->
                            <td>
                                <input type="checkbox"
                                       name="ids"
                                       value="<%=productBean.getId()%>">
                            </td>

                            <!-- Serial Number -->
                            <td class="text-muted small">
                                <%=index++%>
                            </td>

                            <!-- Product Name -->
                            <td class="fw-semibold">
                                <%=productBean.getProductName()%>
                            </td>

                            <!-- Product Category -->
                            <td>
                                <%=productBean.getProductCategory()%>
                            </td>

                            <!-- Order Date -->
                            <td>
                                <%=productBean.getOrderDate()%>
                            </td>

                            <!-- Price -->
                            <td>
                                <%=productBean.getPrice()%>
                            </td>

                            <!-- Edit -->
                            <td>

                                <a href="ProductCtl?id=<%=productBean.getId()%>"
                                   class="btn btn-sm btn-outline-primary">

                                    <i class="bi bi-pencil"></i>
                                    Edit

                                </a>

                            </td>

                        </tr>

                        <%
                        }
                        %>

                    </tbody>

                </table>

            </div>

            <!-- Pagination -->
            <div class="p-3 border-top">

                <%@ include file="ListFooter.jsp"%>

            </div>

        </form>

    </div>

</div>