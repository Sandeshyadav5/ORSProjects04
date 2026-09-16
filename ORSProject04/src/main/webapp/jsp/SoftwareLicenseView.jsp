<%@page import="com.sunilos.p4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.util.DataUtility"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<jsp:useBean id="bean" class="com.sunilos.p4.bean.SoftwareLicenseBean"
	scope="request"></jsp:useBean>

<%
String _suc = ServletUtility.getSuccessMessage(request);
String _err = ServletUtility.getErrorMessage(request);
%>

<div class="container py-4" style="max-width: 580px;">
	<div class="card border-0 shadow-sm rounded-4 overflow-hidden">

		<div class="card-header text-white border-0 py-3 px-4"
			style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">
			<h5 class="mb-0 fw-bold">
				<i class="bi bi-bookmark-star-fill me-2"></i>
				<%=bean.getId() > 0 ? "Edit SoftwareLicense" : "Add SoftwareLicense"%>
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

			<form action="<%=ORSView.SOFTWARELICENSE_CTL%>" method="POST">
				<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
					type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
				<input type="hidden" name="modifiedBy"
					value="<%=bean.getModifiedBy()%>"> <input type="hidden"
					name="createdDatetime"
					value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
				<input type="hidden" name="modifiedDatetime"
					value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

				<div class="mb-3">
					<label class="form-label fw-semibold">SoftwareName <span
						class="text-danger">*</span></label> <input type="text"
						name="softwareName" placeholder="Enter SoftwareName"
						class="form-control" maxlength="100"
						value="<%=DataUtility.getStringData(bean.getSoftwareName())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("softwareName", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">LicenseKey <span
						class="text-danger">*</span></label> <input type="text" name="licenseKey"
						placeholder="Enter LicenseKey" class="form-control"
						maxlength="200"
						value="<%=DataUtility.getStringData(bean.getLicenseKey())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("licenseKey", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">ExpiryDate<span
						class="text-danger">*</span></label> <input type="text" id="udate"
						readonly="readonly" name="expiryDate" placeholder="Click Calendar"
						class="form-control" maxlength="200"
						value="<%=DataUtility.getDateString(bean.getExpiryDate())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("expiryDate", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">Vendore <span
						class="text-danger">*</span></label> <input type="text" name="vendore"
						placeholder="Enter Vandore" class="form-control" maxlength="200"
						value="<%=DataUtility.getStringData(bean.getVendore())%>">

					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("vendore", request)%></div>
				</div>

				<div class="d-flex gap-2 pt-2 border-top">
					<button type="submit" name="operation" value="<%=BaseCtl.OP_SAVE%>"
						class="btn btn-primary">
						<i class="bi bi-save me-1"></i> Save
					</button>

					<a href="<%=ORSView.SOFTWARELICENSE_CTL%>" class="btn btn-danger">
						<i class="bi bi-arrow-clockwise me-1"></i> Reset
					</a> <a href="<%=ORSView.SOFTWARELICENSE_LIST_CTL%>"
						class="btn btn-secondary ms-auto"> <i
						class="bi bi-x-circle me-1"></i>Cancel
					</a>

				</div>
			</form>
		</div>
	</div>
</div>