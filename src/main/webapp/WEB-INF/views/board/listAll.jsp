<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
				
				<table class="table table-bordered">
					<tr>
						<th style="width: 10px">BNO</th>
						<th>TITLE</th>
						<th>WRITER</th>
						<th>REGDATE</th>
					</tr>
					<c:forEach items="${list}" var="boardVO">
					<tr>
						<td>${boardVO.bno}</td>
						<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
						<td>${boardVO.writer}</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" />
						</td>
					</tr>
					</c:forEach>
				</table>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
    
    var result = '${msg}';
    
    if(result == 'success'){
    	alert("등록 처리가 완료되었습니다.");
    }else if (result == 'remove'){
    	alert("삭제  처리가 완료되었습니다.");
    }else if (result == 'modify' ){
    	alert("수정  처리가 완료되었습니다.");
    }else{
    	//alert("Error");
    }
    
    </script>

<%@include file="../include/footer.jsp"%>
