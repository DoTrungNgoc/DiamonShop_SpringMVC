<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
<style type="text/css">
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

.disabled {
  pointer-events: none;
  cursor: default;
}
</style>
</head>
<body>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;">Danh sách sản phẩm</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>

		<div class="row-fluid">
			<ul class="thumbnails">
				<c:forEach var="product" items="${productsPaginate}"
					varStatus="loop">
					<li class="span4">
						<div class="thumbnail">
							<a href="product_details.html" class="overlay"></a> <a
								class="zoomTool" href="product_details.html" title="add to cart"><span
								class="icon-search"></span> QUICK VIEW</a> <a
								href="<c:url value="/chi-tiet-san-pham/${product.id_product}"/>"><img
								src="<c:url value="/assets/user/img/${product.img}"/>" alt=""></a>
							<div class="caption cntr">
								<p>${product.id_product}</p>
								<p>
									<fmt:formatNumber type="number" groupingUsed="true"
										value="${product.price}" />
									đ
								</p>
								<h4>
									<a class="shopBtn" href="#" title="add to cart"> Add to
										cart </a>
								</h4>
								<div class="actionList">
									<a class="pull-left" href="#">Add to Wish List </a> <a
										class="pull-left" href="#"> Add to Compare </a>
								</div>
								<br class="clr">
							</div>
						</div>
					</li>

					<c:if
						test="${ (loop.index +1) % 3 == 0 && (loop.index +1) !=  productsPaginate.size()}">
			</ul>
		</div>

		<c:if test="${(loop.index+1)<productsPaginate.size()}">
			<div class="row-fluid">
				<ul class="thumbnails">
		</c:if>
		</c:if>

		</c:forEach>
		
		</ul>
		</div>


	</div>



	<div class="pagination">
		<a ${ paginateInfo.currentPage == 1  ? 'class="disabled"' : ''} href="<c:url value="/san-pham/${categoryId}/${paginateInfo.currentPage-1}"/>">&laquo;</a> 
		<c:forEach var="page" begin="1" end="${paginateInfo.totalPage}"  varStatus="loop">
			
			<c:if test="${loop.index == paginateInfo.currentPage }">
				<a href="<c:url value="/san-pham/${categoryId}/${loop.index}" />" class="active">${loop.index}</a>
			</c:if>
			
			<c:if test="${loop.index != paginateInfo.currentPage }">
				<a href="<c:url value="/san-pham/${categoryId}/${loop.index}"/>">${loop.index}</a>
			</c:if>
		</c:forEach>
		<a ${ paginateInfo.currentPage == paginateInfo.totalPage  ? 'class="disabled"' : ''} href="<c:url value="/san-pham/${categoryId}/${paginateInfo.currentPage+1}"/>">&raquo;</a>
	</div>
</body>
</html>