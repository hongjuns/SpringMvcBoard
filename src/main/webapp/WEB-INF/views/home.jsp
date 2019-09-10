<%@page import="com.github.scribejava.core.model.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true"%>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<%@include file="include/header.jsp"%>


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
					<div class="content">
						<div class="left" style="width:50%;float: left;"> 
							<h2 style="text-align: center;"> 이달의 글쓴이</h2>
							<table class="table">
							  <thead>
							    <tr>
							      <th scope="col">Bno</th>
							      <th scope="col">Title</th>
							      <th scope="col">content</th>
							      <th scope="col">regdate</th>
							    </tr>
							  </thead>
							  <tbody>
							     <c:forEach items="${list}" var="boardVO">
									<tr>
										<th scope="row">${boardVO.bno}</th>
										<td>${boardVO.title}</td>
										<td>${boardVO.content}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}" /></td>
									</tr>
								</c:forEach>
							  </tbody>
							</table>
						</div>
						<div class="right" style="width:50%;float:right;">
							<h2 style="text-align: center;"> Board Count</h2>
							<div style="background: #343a40; color: #fff; text-align: center;">
						      <p class="card-text"> <b> 총 개수 </b></p>
							  <p> Today : ${TodayCount} </p> 
							  <p class="card-text"> <b> 이번달 개수 </b></p>
							  <p> Today : ${MonthCount} </p>
							</div>
						</div>	
					 </div>
					</div>
					<div>
					<canvas id="myChart" width="100%" height="30%"></canvas>
					<script>
					
					var ctx = document.getElementById('myChart');
					var myChart = new Chart(ctx, {
					    type: 'bar',
					    data: {
					        labels: ['07월', '08월', '09월', '10월', '11월', '12월'],
					        datasets: [{
					            label: '하반기 데이터',
					            data: [12, 19, 3, 0, 0, 0],
					            backgroundColor: [
					                'rgba(255, 99, 132, 0.2)',
					                'rgba(255, 99, 132, 0.2)',
					                'rgba(255, 99, 132, 0.2)',
					                'rgba(255, 99, 132, 0.2)',
					                'rgba(255, 99, 132, 0.2)',
					                'rgba(255, 99, 132, 0.2)'
					            ],
					            borderColor: [
					                'rgba(255, 99, 132, 1)',
					                'rgba(255, 99, 132, 1)',
					                'rgba(255, 99, 132, 1)',
					                'rgba(255, 99, 132, 1)',
					                'rgba(255, 99, 132, 1)',
					                'rgba(255, 99, 132, 1)'
					            ],
					            borderWidth: 1
					        }]
					    },
					    options: {
					        scales: {
					            yAxes: [{
					                ticks: {
					                    beginAtZero: true
					                }
					            }]
					        }
					    }
					});
					</script>
					</div>		
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<%@include file="include/footer.jsp"%>
				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->




