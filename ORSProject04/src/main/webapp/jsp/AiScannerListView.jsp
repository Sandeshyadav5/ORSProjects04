<%@page import="com.sunilos.p4.ctl.AiScannerListCtl"%>
<%@page import="com.sunilos.p4.ctl.BaseCtl"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.bean.AiScannerBean"%>
<%@page import="com.sunilos.p4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%
int pageNo = ServletUtility.getPageNo(request);
int pageSize = ServletUtility.getPageSize(request);
int index = ((pageNo - 1) * pageSize) + 1;

List list = ServletUtility.getList(request);
Iterator<AiScannerBean> it = list.iterator();

String _err = ServletUtility.getErrorMessage(request);
%>

<div class="container-fluid mt-3">

	<div class="card">

		<div class="card-header text-white"
			style="background: linear-gradient(90deg, #007bff, #00c6ff);">

			<div class="row">

				<div class="col-md-6">
					<h4>AiScanner List</h4>
				</div>

				<div class="col-md-6 text-end">

				

				</div>

			</div>

		</div>

		<div class="card-body">

			<form action="<%=ORSView.AISCANNER_LIST_CTL%>" method="post">

				<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
					type="hidden" name="pageSize" value="<%=pageSize%>">

				<div class="row mb-3">

					<div class="col-md-3">
						<input type="text" name="aiscannerName" class="form-control"
							placeholder="AiScanner Name"
							value="<%=ServletUtility.getParameter("aiscannerName", request)%>">
					</div>

					<div class="col-md-3">
						<input type="text" name="type" class="form-control"
							placeholder="Type"
							value="<%=ServletUtility.getParameter("type", request)%>">
					</div>

					<div class="col-md-2">
						<input type="submit" name="operation"
							value="<%=BaseCtl.OP_SEARCH%>" class="btn btn-primary">
					</div>

					<div class="col-md-2">
						<input type="submit" name="operation"
							value="<%=BaseCtl.OP_DELETE%>" class="btn btn-danger">
					</div>

				</div>

				<%
				if (_err != null && !_err.equals("")) {
				%>

				<div class="alert alert-danger">
					<%=ServletUtility.getErrorMessage(request)%>
				</div>

				<%
				}
				%>

				<table class="table table-bordered table-striped">

					<thead class="table-dark">

						<tr>

							<th><input type="checkbox" onclick="checkAll(this)">
							</th>

							<th>#</th>
							<th>ID</th>
							<th>AiScanner Name</th>
							<th>Description</th>
							<th>Type</th>
							<th>Status</th>
							<th>Action</th>

						</tr>

					</thead>

					<tbody>

						<%
						while (it.hasNext()) {

							AiScannerBean bean = it.next();
						%>

						<tr>

							<td><input type="checkbox" name="ids"
								value="<%=bean.getId()%>"></td>

							<td><%=index++%></td>

							<td><%=bean.getId()%></td>

							<td><%=bean.getAiscannerName()%></td>

							<td><%=bean.getDescription()%></td>

							<td><%=bean.getType()%></td>

							<td><%=bean.getStatus()%></td>

							<td><a href="AiScannerCtl?id=<%=bean.getId()%>"
								class="btn btn-sm btn-primary"> Edit </a></td>

						</tr>

						<%
						}
						%>

					</tbody>

				</table>

			</form>

			<%@include file="ListFooter.jsp"%>

		</div>

	</div>

</div>