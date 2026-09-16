<%@page import="com.sunilos.p4.util.MessageSource"%>
<%@page import="com.sunilos.p4.ctl.ORSView"%>
<%@page import="com.sunilos.p4.bean.PgHostelBean"%>
<%@page import="java.util.Iterator"%>
<%
MessageSource ms = MessageSource.getInstance();
int pageNo = ServletUtility.getPageNo(request);
int pageSize = ServletUtility.getPageSize(request);
int index = ((pageNo - 1) * pageSize) + 1;
List list = ServletUtility.getList(request);
Iterator<PgHostelBean> it = list.iterator();
String _err = ServletUtility.getErrorMessage(request);
%>

<div class="container-fluid px-4 py-4" style="max-width: 900px;">
	<div class="card border-0 shadow-sm rounded-4 overflow-hidden">

		<div
			class="card-header text-white border-0 py-3 px-4 d-flex justify-content-between align-items-center"
			style="background: linear-gradient(135deg, #0d2137 0%, #1565c0 100%);">
			<h5 class="mb-0 fw-bold">
				<i class="bi bi-cart me-2"></i><%=ms.get("PgHostel.list") %>
				<!-- Internationalization in hi - eng  use  -->
			</h5>
			<div class="d-flex gap-2">
				<a href="<%=ORSView.PGHOSTEL_REPORT_CTL %>" target="_blank"
					class="btn btn-sm btn-warning fw-semibold"> <i
					class="bi bi-file-earmark-pdf me-1"></i> <%=ms.get("PgHostel.pdf") %>
				</a> <a href="<%=ORSView.PGHOSTEL_REPORT_CTL %>?type=doc"
					target="_blank" class="btn btn-sm btn-info fw-semibold"> <i
					class="bi bi-file-earmark-word me-1"></i> <%=ms.get("PgHostel.doc") %>
					<!-- Internationalization in hi - eng  use  -->
				</a> <a href="PgHostelCtl" target="_blank"
					class="btn btn-sm btn-light text-primary fw-semibold"> <i
					class="bi bi-cart me-1"></i><%=ms.get("PgHostel.add") %> <!-- Internationalization in hi - eng  use  -->
				</a>
			</div>
		</div>

		<form action="<%=ORSView.PGHOSTEL_LIST_CTL%>" method="POST">
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">

			<div
				class="p-3 bg-light border-bottom d-flex flex-wrap gap-2 align-items-center">

				<input type="text" name="ownerName"
					class="form-control form-control-sm" style="max-width: 220px;"
					placeholder="<%=ms.get("PgHostel.search.OwnerName") %>"
					value="<%=ServletUtility.getParameter("ownerName", request)%>">

				<button type="submit" name="operation"
					value="<%=BaseCtl.OP_SEARCH%>" class="btn btn-primary btn-sm">
					<i class="bi bi-search me-1"></i>
					<%=ms.get("PgHostel.search") %>
					<!-- Internationalization in hi - eng  use  -->
				</button>
				<a href="<%=ORSView.PGHOSTEL_LIST_CTL %>"
					class="btn btn-danger btn-sm"> <i class="bi bi-arrow-clockwise"></i>Reset
				</a>
				<button type="submit" name="operation"
					value="<%=BaseCtl.OP_DELETE%>"
					class="btn btn-danger btn-sm ms-auto">
					<i class="bi bi-trash me-1"></i>
					<%=ms.get("PgHostel.delete") %>
					<!-- Internationalization in hi - eng  use  -->
				</button>
			</div>

			<%
			if (_err != null && !_err.isEmpty()) {
			%>
			<div class="alert alert-danger py-2 mx-3 mt-3">
				<i class="bi bi-exclamation-triangle-fill me-2"></i><%=_err%></div>
			<%
			}
			%>

			<div class="table-responsive">
				<table class="table table-hover align-middle mb-0">
					<thead class="table-dark">
						<tr>
							<th width="40"><input type="checkbox"
								onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
							<th><%=ms.get("PgHostel.serialno") %></th>
							<th><%=ms.get("PgHostel.ownerName") %></th>
							<th><%=ms.get("PgHostel.location") %></th>
							<th><%=ms.get("PgHostel.rent") %></th>
							<th><%=ms.get("PgHostel.roomType") %></th>
							<th><%=ms.get("PgHostel.edit") %></th>
						</tr>
					</thead>
					<tbody>
						<%
						while (it.hasNext()) {
							PgHostelBean bean = it.next();
						%>
						<tr>
							<td><input type="checkbox" name="ids"
								value="<%=bean.getId()%>"></td>
							<td class="text-muted small"><%=index++%></td>
							<td class="fw-semibold"><%=bean.getOwnerName()%></td>
							<td><%=bean.getLocation()%></td>
							<td><%=bean.getRent()%></td>
							<td><%=bean.getRoomType()%></td>
							<td><a href="PgHostelCtl?id=<%=bean.getId()%>"
								class="btn btn-sm btn-outline-primary"> <i
									class="bi bi-pencil"></i> <%=ms.get("PgHostel.edit") %>
							</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>

			<div class="p-3 border-top">
				<%@ include file="ListFooter.jsp"%>
			</div>
		</form>
	</div>
</div>
