<%@page import="com.sunilos.p4.util.MessageSource"%>
<%@page import="com.sunilos.p4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.util.DataUtility"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<jsp:useBean id="bean" class="com.sunilos.p4.bean.PgHostelBean"
	scope="request"></jsp:useBean>

<%
MessageSource ms = MessageSource.getInstance();
String _suc = ServletUtility.getSuccessMessage(request);
String _err = ServletUtility.getErrorMessage(request);
%>

<div class="container py-4" style="max-width: 580px;">
	<div class="card border-0 shadow-sm rounded-4 overflow-hidden">

		<div class="card-header text-white border-0 py-3 px-4"
			style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">
			<h5 class="mb-0 fw-bold">
				<i class="bi bi-bookmark-star-fill me-2"></i>
				<%=bean.getId() > 0 ? ms.get("PgHostel.edit") : ms.get("PgHostel.add")%>
			</h5>
		</div>

		<div class="card-body px-4 py-4">

			<%
			if (_suc != null && !_suc.isEmpty()) {
			%>
			<div class="alert alert-success py-2">
				<i class="bi bi-check-circle-fill me-2"></i><%=_suc%></div>
			<%
			}
			%>
			<%
			if (_err != null && !_err.isEmpty()) {
			%>
			<div class="alert alert-danger py-2">
				<i class="bi bi-exclamation-triangle-fill me-2"></i><%=_err%></div>
			<%
			}
			%>

			<form action="<%=ORSView.PGHOSTEL_CTL%>" method="POST">
				<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
					type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
				<input type="hidden" name="modifiedBy"
					value="<%=bean.getModifiedBy()%>"> <input type="hidden"
					name="createdDatetime"
					value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
				<input type="hidden" name="modifiedDatetime"
					value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

				<div class="mb-3">
					<label class="form-label fw-semibold"><%=ms.get("PgHostel.ownerName") %>
						<span class="text-danger">*</span></label> <input type="text"
						name="ownerName"
						placeholder="<%=ms.get("PgHostel.placeholder.OwnerName") %>"
						class="form-control" maxlength="100"
						value="<%=DataUtility.getStringData(bean.getOwnerName())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("ownerName", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold"><%=ms.get("PgHostel.location") %>
						<span class="text-danger">*</span></label> <input type="text"
						name="location"
						placeholder="<%=ms.get("PgHostel.placeholder.Location") %>"
						class="form-control" maxlength="200"
						value="<%=DataUtility.getStringData(bean.getLocation())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("location", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold"><%=ms.get("PgHostel.rent") %>
						<span class="text-danger">*</span></label> <input type="text" name="rent"
						placeholder="<%=ms.get("PgHostel.placeholder.rent") %>"
						class="form-control" maxlength="200"
						value="<%=DataUtility.getStringData(bean.getRent())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("rent", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold"><%=ms.get("PgHostel.roomType") %>
						<span class="text-danger">*</span></label>
					<%
					HashMap<String, String> map = new HashMap<String, String>();

					map.put("Available", "Available");
					map.put("NotAvailable", "NotAvailable");
					map.put("Other", "Other");

					String htmlList = HTMLUtility.getList("roomType", bean.getRoomType(), map);
					%><%=htmlList%>
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("roomType", request)%></div>
				</div>

				<div class="d-flex gap-2 pt-2 border-top">
					<button type="submit" name="operation" value="<%=BaseCtl.OP_SAVE%>"
						class="btn btn-primary">
						<i class="bi bi-save me-1"></i><%=ms.get("PgHostel.save") %>
					</button>

					<a href="<%=ORSView.PGHOSTEL_CTL%>" class="btn btn-danger "> <i
						class="bi bi-arrow-clockwise me-1"></i> <%=ms.get("PgHostel.reset") %>
					</a> <a href="<%=ORSView.PGHOSTEL_LIST_CTL%>"
						class="btn btn-secondary ms-auto"> <i
						class="bi bi-x-circle me-1"></i><%=ms.get("PgHostel.cancel") %>
					</a>

				</div>
			</form>
		</div>
	</div>
</div>