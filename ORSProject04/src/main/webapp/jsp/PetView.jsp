<%@page import="com.sunilos.p4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.util.DataUtility"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<jsp:useBean id="bean" class="com.sunilos.p4.bean.PetBean"
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
				<%=bean.getId() > 0 ? "Edit Pet" : "Add Pet"%>
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

			<form action="<%=ORSView.PET_CTL%>" method="POST">
				<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
					type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
				<input type="hidden" name="modifiedBy"
					value="<%=bean.getModifiedBy()%>"> <input type="hidden"
					name="createdDatetime"
					value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
				<input type="hidden" name="modifiedDatetime"
					value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

				<div class="mb-3">
					<label class="form-label fw-semibold">PetName <span
						class="text-danger">*</span></label> <input type="text"
						name="petName" placeholder="Enter PetName"
						class="form-control" maxlength="100"
						value="<%=DataUtility.getStringData(bean.getPetName())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("petName", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">ownerName <span
						class="text-danger">*</span></label> <input type="text" name="ownerName"
						placeholder="Enter OwnerName" class="form-control"
						maxlength="200"
						value="<%=DataUtility.getStringData(bean.getOwnerName())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("ownerName", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">Breed <span
						class="text-danger">*</span></label> <input type="text" name="breed"
						placeholder="Enter breed" class="form-control"
						maxlength="200"
						value="<%=DataUtility.getStringData(bean.getBreed())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("breed", request)%></div>
				</div>
				
				<div class="mb-3">
					<label class="form-label fw-semibold">Age <span
						class="text-danger">*</span></label> <input type="text" name="age"
						placeholder="Enter age" class="form-control"
						maxlength="200"
						value="<%=DataUtility.getStringData(bean.getAge())%>">
					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("age", request)%></div>
				</div>

				<div class="mb-3">
					<label class="form-label fw-semibold">VaccinationStatus <span
						class="text-danger">*</span></label> 
						
						<%
						
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("Available", "Available");
						map.put("Not Available", "Not Available");
						
						String htmlList = HTMLUtility.getList("vaccinationstatus", bean.getVaccinationStatus(), map);
						%><%=htmlList %>

					<div class="text-danger small mt-1"><%=ServletUtility.getErrorMessage("vaccinationstatus", request)%></div>
				</div>

				<div class="d-flex gap-2 pt-2 border-top">
					<button type="submit" name="operation" value="<%=BaseCtl.OP_SAVE%>"
						class="btn btn-primary">
						<i class="bi bi-save me-1"></i> Save
					</button>

					<a href="<%=ORSView.PET_CTL%>" class="btn btn-danger">
						<i class="bi bi-arrow-clockwise me-1"></i> Reset
					</a> <a href="<%=ORSView.PET_LIST_CTL%>"
						class="btn btn-secondary ms-auto"> <i
						class="bi bi-x-circle me-1"></i>Cancel
					</a>

				</div>
			</form>
		</div>
	</div>
</div>