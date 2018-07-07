<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="container">

		<c:if test="${not empty message}"> 
			</br>
					<div class="row">
						<div class="col-lg-3"></div>
						<div class="col-lg-9">
							<div id="alertCard" class="alert card bg-success text-white">${message}</div>
						</div>
					</div>
		</c:if>
		
		

      <div class="row">

		<div class="col-lg-3">
		
        	<%@ include file = "sidebar.jsp" %>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="${contextRoot }/resources/images/image1.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="${contextRoot }/resources/images/image2.jpg" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="${contextRoot }/resources/images/image3.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <div class="row">


			<c:forEach items="${productList }" var="product">
			
					 <div class="col-lg-4 col-md-6 mb-4">
			              <div class="card h-100">
								<a href="/Grab-It/show/${product.id }/product"><img class="card-img-top"
									src="${contextRoot }/resources/images/${product.code}.png"
									alt="" style="max-width: 100%; height: 250px;"></a>
								<div class="card-body">
			                  <h4 class="card-title">
			                    <a href="#">${product.name }</a>
			                  </h4>
			                  <h5>&#8377; ${product.unitPrice}</h5>
			                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
			                </div>
			                <div class="card-footer">
			                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
			                </div>
			              </div>
		            </div>
		            
			</c:forEach>
			
			
       

          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>

</body>
</html>