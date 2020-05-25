<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function checks(){ 
	var form = document.userInfo;
	var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/);
	var getName= RegExp(/^[가-힣]+$/);
	var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);

	
	if($("#phone1").val() == ""){ 
		alert("전화번호 입력바람"); 
		$("#phone1").focus(); 
		return false; 
		}
	if($("#phone2").val() == ""){ 
		alert("전화번호 입력바람"); 
		$("#phone2").focus(); 
		return false; 
		}
	if($("#phone3").val() == ""){ 
		alert("전화번호 입력바람"); 
		$("#phone3").focus(); 
		return false; 
		}

	
	if(!getMail.test($("#email").val())){
		alert("메일 형식에 맞게 입력해주세요")
	  $("#email").val("");
		$("#email").focus();
		return false;
	}
	
	if($("#sample4_roadAddress").val() == ""){ 
		alert("주소 입력바람"); 
		$("#sample4_roadAddress").focus(); 
		return false; 
		}
	if($("#sample4_detailAddress").val() == ""){ 
		alert("주소 입력바람"); 
		$("#sample4_detailAddress").focus(); 
		return false; 
		}
	
	return true;
}
</script>

<script>
// html 이 다 로딩된 후 실행
$(document).ready(function() {
    // 체크박스들이 변경됬을때
    $(":checkbox").change(function() {
        var limit = "3";
         
        // limit의 값과 체크박스중 체크된 갯수가 같을때, 다른 체크박스들을 disable 처리
        if( limit==$(":checkbox:checked").length ) {
            $(":checkbox:not(:checked)").attr("disabled", "disabled");
        }
        // 체크된 갯수가 다르면 활성화 시킴
        else {
            $(":checkbox").removeAttr("disabled");
        }
    });
});
</script>

</head>
<body>
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h1>modifyForm.jsp</h1>
	<p>http://localhost/doseo/mypage.dom</p>
	
	<form name="modifyFrm" id="modifyFrm" action="modify.dom" method="post">
		아이디 : ${member.id}<input type="hidden" name="id" value="${member.id}"/>
		이름 : ${member.name}<input type="hidden" name="name" value="${member.name}"/>
		성별 : ${member.gender}<input type="hidden" name="gender" value="${member.gender}"/>
		생년월일 : ${member.birth}<input type="hidden" name="birth" value="${member.birth}"/>
	        전화번호 : <input type="text" name="phone1" value="${member.phone1}"/>-<input type="text" name="phone2" value="${member.phone2}"/>-<input type="text" name="phone3" value="${member.phone3}"/>
	        이메일 : <input type="text" name="email" value="${member.email}"/>
	        선호장르(최대 3개) :
	    <select name="favorite1" >
	    	<option value="">선호장르1</option>
	    	<c:if test="${member.favorite1 == '소설'}">
	    		<option value="소설" selected="selected">소설</option>
	    	</c:if>
	    	
	    	<%-- 
	    	<option value="소설"
	    		<c:if test="${member.favorite1 == '소설'}">selected</c:if>>소설</option>
	    	<option value="시"
	    		<c:if test="${member.favorite1 == '시'}">selected</c:if>>시</option>
	    	<option value="에세이"
	    		<c:if test="${member.favorite1 == '에세이'}">selected</c:if>>에세이</option>
	    	<option value="종교"
	    		<c:if test="${member.favorite1 == '종교'}">selected</c:if>>종교</option>
	    	<option value="과학"
	    		<c:if test="${member.favorite1 == '과학'}">selected</c:if>>과학</option>
	    --%>
	    </select>
	    
       	 주소 : <input type="text" name="address" value="${member.address}"/>
    	<input type="submit" value="수정완료"/>		
		<input type="reset"  value="취소"/>
    </form>
</body>
</html>