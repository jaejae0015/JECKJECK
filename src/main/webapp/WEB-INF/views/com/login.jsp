<%@ include file="/WEB-INF/include/_header.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnLogin").click(function(){
			if($.trim($("#userId").val())==""){
				alert("아이디를 입력하세요");
				return false;
			}
			if($.trim($("#userPwd").val())==""){
				alert("비밀번호를 입력하세요");
				return false;
			}
			
			var param =new Object();
			param.userid=$.trim($("#userId").val());
			param.userpwd=$.trim($("#userPwd").val());
			
			$.ajax({
				url: "/com/login.do",
				type: "POST",
				dataType: "json",
				data: param,
	            async: false,
				success:function(data){
					 if (data.success) {
                        window.location.href = "/com/main.do";
                    } else {
                        alert("로그인에 실패했습니다. 다시 시도해주세요.");
                    }
				},
				error:function(xhr,status,error){
					console.error("로그인 요청 중 오류 발생:", error);
                    alert("#######"+error+"\n오류가 발생했습니다. 관리자에게 문의해주세요.");
				},
				complete: function(xhr,status){
					
				}
			})
		});
	});
</script>
<body class="bg-gradient-primary">
    <div class="container">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image">	                     	
                            	<img src="/static/img/login_img.png" style="width:inherit;">
                           	</div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                    </div>
                                    <form class="user">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="userId" aria-describedby="emailHelp"
                                                placeholder="Enter Email Address...">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="userPwd" placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <a id="btnLogin" class="btn btn-primary btn-user btn-block">
                                            Login
                                        </a>
                                        <hr>
                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>
<!-- End of Content Wrapper -->
</body>