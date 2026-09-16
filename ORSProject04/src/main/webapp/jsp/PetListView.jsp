<%@page import="com.sunilos.p4.ctl.PetListCtl"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.bean.PetBean"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%
int pageNo = ServletUtility.getPageNo(request);
int pageSize = ServletUtility.getPageSize(request);
int index = ((pageNo - 1) * pageSize) + 1;

List list = ServletUtility.getList(request);
Iterator<PetBean> it = list.iterator();

String _err = ServletUtility.getErrorMessage(request);
%>

<div class="container-fluid px-4 py-4" style="max-width: 1100px;">

	<div class="card border-0 shadow-sm rounded-4 overflow-hidden">

		<!-- Header -->
		<div
			class="card-header text-white border-0 py-3 px-4 d-flex justify-content-between align-items-center"
			style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">

			<h5 class="mb-0 fw-bold">
				<i class="bi bi-heart-fill me-2"></i> Pet List
			</h5>

			<div class="d-flex gap-2">

				<!-- PDF -->
				<a href="<%=ORSView.PET_REPORT_CTL%>" target="_blank"
					class="btn btn-sm btn-warning fw-semibold"> <i
					class="bi bi-file-earmark-pdf me-1"></i> Print PDF
				</a>

				<!-- DOC -->
				<a href="<%=ORSView.PET_REPORT_CTL%>?type=doc" target="_blank"
					class="btn btn-sm btn-info fw-semibold"> <i
					class="bi bi-file-earmark-word me-1"></i> Print DOC
				</a>

				<!-- Add Pet -->
				<a href="<%=ORSView.PET_CTL%>"
					class="btn btn-sm btn-light text-primary fw-semibold"> <i
					class="bi bi-plus-circle me-1"></i> Add Pet
				</a>

			</div>
		</div>


		<!-- Form -->
		<form action="<%=ORSView.PET_LIST_CTL%>" method="POST">

			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">


			<!-- Search -->
			<div
				class="p-3 bg-light border-bottom d-flex flex-wrap gap-2 align-items-center">

				<input type="text" name="petName"
					class="form-control form-control-sm" style="max-width: 220px;"
					placeholder="Search by Pet Name"
					value="<%=ServletUtility.getParameter("petName", request)%>">


				<input type="text" name="ownerName"
					class="form-control form-control-sm" style="max-width: 220px;"
					placeholder="Search by Owner Name"
					value="<%=ServletUtility.getParameter("ownerName", request)%>">


				<button type="submit" name="operation"
					value="<%=BaseCtl.OP_SEARCH%>" class="btn btn-primary btn-sm">

					<i class="bi bi-search me-1"></i> Search
				</button>


				<button type="submit" name="operation"
					value="<%=BaseCtl.OP_DELETE%>"
					class="btn btn-danger btn-sm ms-auto"
					onclick="return confirm('Delete selected pets?')">

					<i class="bi bi-trash me-1"></i> Delete Selected
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


			<!-- Table -->
			<div class="table-responsive">

				<table class="table table-hover align-middle mb-0">

					<thead class="table-light">

						<tr>

							<th width="40"><input type="checkbox"
								onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)">
							</th>

							<th>#</th>

							<th>ID</th>

							<th>Pet Name</th>

							<th>Owner Name</th>

							<th>Breed</th>

							<th>Age</th>

							<th>Vaccination Status</th>

							<th>Action</th>

						</tr>

					</thead>


					<tbody>

						<%
						while (it.hasNext()) {

							PetBean bean = it.next();
						%>

						<tr>

							<!-- Checkbox -->
							<td><input type="checkbox" name="ids"
								value="<%=bean.getId()%>"></td>


							<!-- Serial Number -->
							<td class="text-muted small"><%=index++%></td>


							<!-- ID -->
							<td class="text-muted small"><%=bean.getId()%></td>


							<!-- Pet Name -->
							<td class="fw-semibold"><%=bean.getPetName()%></td>


							<!-- Owner Name -->
							<td><%=bean.getOwnerName()%></td>


							<!-- Breed -->
							<td><%=bean.getBreed()%></td>


							<!-- Age -->
							<td><%=bean.getAge()%></td>


							<!-- Vaccination Status -->
							<td>
								<%
								if ("Vaccinated".equalsIgnoreCase(bean.getVaccinationStatus())) {
								%> <span class="badge bg-success"> <%=bean.getVaccinationStatus()%>
							</span> <%
 } else {
 %> <span class="badge bg-danger"> <%=bean.getVaccinationStatus()%>
							</span> <%
 }
 %>

							</td>


							<!-- Edit -->
							<td><a href="PetCtl?id=<%=bean.getId()%>"
								class="btn btn-sm btn-outline-primary"> <i
									class="bi bi-pencil"></i> Edit

							</a></td>

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