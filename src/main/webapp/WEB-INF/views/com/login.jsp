<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/_header.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnLogin").click(function(){
			
			if($.trim($("#userId").val())==""){
				alert("아이디를 입력하세요");
			}
			if($.trim($("#userPwd").val())==""){
				alert("비밀번호를 입력하세요");
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
 <main id="user">
     <section class="login">
         <div class="loginForm">
             <table>
                 <tbody>
	                 <tr>
	                     <td rowspan="2">
	                     	<img src="/static/images/login_img.png" alt="비밀번호">
	                     </td>
	                     <td><input type="text" id="userId" placeholder="아이디 입력"></td>
	                 </tr>
	                 <tr>
	                     <td><input type="password" id="userPwd" placeholder="비밀번호 입력"></td>
	                 </tr>
	             </tbody>
             </table>
             <input id="btnLogin" type="submit" value="로그인" class="btnLogin">
         </div>
         <div>
         <label>회원 로그인 안내</label>
         <p>아직 회원이 아니시면 회원으로 가입하세요.</p>
         <a href="/Jboard1/user/terms.jsp">회원가입</a>
     </div>
     </section>
     
 </main>
<%@ include file="/WEB-INF/include/_footer.jsp" %> 