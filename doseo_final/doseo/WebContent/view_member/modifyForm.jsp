<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../header.jsp"/>
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
</head>
<body>
	<form name="modifyFrm" id="modifyFrm" action="modify.dom" method="post">
		<label for="inputID" class="col-lg-2 control-label">아이디</label>
		${member.id}
		<input type="hidden" name="id" value="${member.id}"/>
		<br>
		<label for="inputName" class="col-lg-2 control-label">이름</label>
		${member.name}
		<input type="hidden" name="name" value="${member.name}"/>
		<br>
		<label for="inputGender" class="col-lg-2 control-label">성별</label>
		${member.gender}
		<input type="hidden" name="gender" value="${member.gender}"/>
		<br>
		<label for="inputBirth" class="col-lg-2 control-label">생년월일</label>
		${member.birth}
		<input type="hidden" name="birth" value="${member.birth}"/>
		<br>
		<label for="inputPhone" class="col-lg-2 control-label">전화번호</label>
	      <select name="phone1" >
	      	<c:if test="${member.phone1 == '010 '}">
	      		<option value="010" selected="selected">010</option>
	      	</c:if>
	      	<c:if test="${member.phone1 != '010 '}">
	      		<option value="010">010</option>
	      	</c:if>
	      	
	      	<c:if test="${member.phone1 == '011 '}">
	      		<option value="011" selected="selected">011</option>
	      	</c:if>
	      	<c:if test="${member.phone1 != '011 '}">
	      		<option value="011">011</option>
	      	</c:if>
	      	
	      	<c:if test="${member.phone1 == '016 '}">
	      		<option value="016" selected="selected">016</option>
	      	</c:if>
	      	<c:if test="${member.phone1 != '016 '}">
	      		<option value="016">016</option>
	      	</c:if>
	      	
	      	<c:if test="${member.phone1 == '017 '}">
	      		<option value="017" selected="selected">017</option>
	      	</c:if>
	      	<c:if test="${member.phone1 != '017 '}">
	      		<option value="017">017</option>
	      	</c:if>
	      	
	      	<c:if test="${member.phone1 == '019 '}">
	      		<option value="019" selected="selected">019</option>
	      	</c:if>
	      	<c:if test="${member.phone1 != '019 '}">
	      		<option value="019">019</option>
	      	</c:if>
	      </select> - 
	      <input type="text" name="phone2"  value="${member.phone2}" size="5" maxlength="4"> - 
     		<input type="text" name="phone3"  value="${member.phone3}" size="5" maxlength="4">
	      <c:if test="${errors.phone}">번호를 입력하세요.</c:if> 
	        <br>
	       <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
	       <input type="text" name="email" value="${member.email}"/>
	       <c:if test="${errors.email}">메일을 입력하세요.</c:if>
	       <br>
	    <label for="inputFavorite" class="col-lg-2 control-label">선호장르(최대 3개)</label>
	    <select name="favorite1" >
	    	<c:if test="${member.favorite1 == ' '}">
	    		<option value=" " selected="selected">선택안함</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != ' '}">
	    		<option value=" " >선택안함</option>
	    	</c:if>
	    	
	    	<c:if test="${member.favorite1 == '소설'}">
	    		<option value="소설" selected="selected">소설</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '소설'}">
	    		<option value="소설" >소설</option>
	    	</c:if>
	    	
	    	<c:if test="${member.favorite1 == '시'}">
	    		<option value="시" selected="selected">시</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '시'}">
	    		<option value="시" >시</option>
	    	</c:if>
	    	
	    	
	    	<c:if test="${member.favorite1 == '에세이'}">
	    		<option value="에세이" selected="selected">에세이</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '에세이'}">
	    		<option value="에세이" >에세이</option>
	    	</c:if>
	    	
	    	<c:if test="${member.favorite1 == '종교'}">
	    		<option value="종교" selected="selected">종교</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '종교'}">
	    		<option value="종교" >종교</option>
	    	</c:if>
	    	
	    	<c:if test="${member.favorite1 == '과학'}">
	    		<option value="과학" selected="selected">과학</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '과학'}">
	    		<option value="과학" >과학</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '사회'}">
	    		<option value="사회" selected="selected">사회</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '사회'}">
	    		<option value="사회" >사회</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '예술'}">
	    		<option value="예술" selected="selected">예술</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '예술'}">
	    		<option value="예술" >예술</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '경제'}">
	    		<option value="경제" selected="selected">경제</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '경제'}">
	    		<option value="경제" >경제</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '자기개발'}">
	    		<option value="자기개발" selected="selected">자기개발</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '자기개발'}">
	    		<option value="자기개발" >자기개발</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '취미'}">
	    		<option value="취미" selected="selected">취미</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '취미'}">
	    		<option value="취미" >취미</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '만화'}">
	    		<option value="만화" selected="selected">만화</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '만화'}">
	    		<option value="만화" >만화</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '잡지'}">
	    		<option value="잡지" selected="selected">잡지</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '잡지'}">
	    		<option value="잡지" >잡지</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '교육'}">
	    		<option value="교육" selected="selected">교육</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '교육'}">
	    		<option value="교육" >교육</option>
	    	</c:if>	
	    	
	    	<c:if test="${member.favorite1 == '요리'}">
	    		<option value="요리" selected="selected">요리</option>
	    	</c:if>
	    	<c:if test="${member.favorite1 != '요리'}">
	    		<option value="요리" >요리</option>
	    	</c:if>	
	    </select>
	    <select name="favorite2" >
				<c:if test="${member.favorite2 == ' '}">
				<option value=" " selected="selected">선택안함</option>
				</c:if>
				<c:if test="${member.favorite2 != ' '}">
				<option value=" " >선택안함</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '소설'}">
				<option value="소설" selected="selected">소설</option>
				</c:if>
				<c:if test="${member.favorite2 != '소설'}">
				<option value="소설" >소설</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '시'}">
				<option value="시" selected="selected">시</option>
				</c:if>
				<c:if test="${member.favorite2 != '시'}">
				<option value="시" >시</option>
				</c:if>
				
				
				<c:if test="${member.favorite2 == '에세이'}">
				<option value="에세이" selected="selected">에세이</option>
				</c:if>
				<c:if test="${member.favorite2 != '에세이'}">
				<option value="에세이" >에세이</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '종교'}">
				<option value="종교" selected="selected">종교</option>
				</c:if>
				<c:if test="${member.favorite2 != '종교'}">
				<option value="종교" >종교</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '과학'}">
				<option value="과학" selected="selected">과학</option>
				</c:if>
				<c:if test="${member.favorite2 != '과학'}">
				<option value="과학" >과학</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '사회'}">
				<option value="사회" selected="selected">사회</option>
				</c:if>
				<c:if test="${member.favorite2 != '사회'}">
				<option value="사회" >사회</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '예술'}">
				<option value="예술" selected="selected">예술</option>
				</c:if>
				<c:if test="${member.favorite2 != '예술'}">
				<option value="예술" >예술</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '경제'}">
				<option value="경제" selected="selected">경제</option>
				</c:if>
				<c:if test="${member.favorite2 != '경제'}">
				<option value="경제" >경제</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '자기개발'}">
				<option value="자기개발" selected="selected">자기개발</option>
				</c:if>
				<c:if test="${member.favorite2 != '자기개발'}">
				<option value="자기개발" >자기개발</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '취미'}">
				<option value="취미" selected="selected">취미</option>
				</c:if>
				<c:if test="${member.favorite2 != '취미'}">
				<option value="취미" >취미</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '만화'}">
				<option value="만화" selected="selected">만화</option>
				</c:if>
				<c:if test="${member.favorite2 != '만화'}">
				<option value="만화" >만화</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '잡지'}">
				<option value="잡지" selected="selected">잡지</option>
				</c:if>
				<c:if test="${member.favorite2 != '잡지'}">
				<option value="잡지" >잡지</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '교육'}">
				<option value="교육" selected="selected">교육</option>
				</c:if>
				<c:if test="${member.favorite2 != '교육'}">
				<option value="교육" >교육</option>
				</c:if>
				
				<c:if test="${member.favorite2 == '요리'}">
				<option value="요리" selected="selected">요리</option>
				</c:if>
				<c:if test="${member.favorite2 != '요리'}">
				<option value="요리" >요리</option>
				</c:if>
				</select>
				
				<select name="favorite3" >
<c:if test="${member.favorite3 == ' '}">
<option value=" " selected="selected">선택안함</option>
</c:if>
<c:if test="${member.favorite3 != ' '}">
<option value=" " >선택안함</option>
</c:if>

<c:if test="${member.favorite3 == '소설'}">
<option value="소설" selected="selected">소설</option>
</c:if>
<c:if test="${member.favorite3 != '소설'}">
<option value="소설" >소설</option>
</c:if>

<c:if test="${member.favorite3 == '시'}">
<option value="시" selected="selected">시</option>
</c:if>
<c:if test="${member.favorite3 != '시'}">
<option value="시" >시</option>
</c:if>


<c:if test="${member.favorite3 == '에세이'}">
<option value="에세이" selected="selected">에세이</option>
</c:if>
<c:if test="${member.favorite3 != '에세이'}">
<option value="에세이" >에세이</option>
</c:if>

<c:if test="${member.favorite3 == '종교'}">
<option value="종교" selected="selected">종교</option>
</c:if>
<c:if test="${member.favorite3 != '종교'}">
<option value="종교" >종교</option>
</c:if>

<c:if test="${member.favorite3 == '과학'}">
<option value="과학" selected="selected">과학</option>
</c:if>
<c:if test="${member.favorite3 != '과학'}">
<option value="과학" >과학</option>
</c:if>

<c:if test="${member.favorite3 == '사회'}">
<option value="사회" selected="selected">사회</option>
</c:if>
<c:if test="${member.favorite3 != '사회'}">
<option value="사회" >사회</option>
</c:if>

<c:if test="${member.favorite3 == '예술'}">
<option value="예술" selected="selected">예술</option>
</c:if>
<c:if test="${member.favorite3 != '예술'}">
<option value="예술" >예술</option>
</c:if>

<c:if test="${member.favorite3 == '경제'}">
<option value="경제" selected="selected">경제</option>
</c:if>
<c:if test="${member.favorite3 != '경제'}">
<option value="경제" >경제</option>
</c:if>

<c:if test="${member.favorite3 == '자기개발'}">
<option value="자기개발" selected="selected">자기개발</option>
</c:if>
<c:if test="${member.favorite3 != '자기개발'}">
<option value="자기개발" >자기개발</option>
</c:if>

<c:if test="${member.favorite3 == '취미'}">
<option value="취미" selected="selected">취미</option>
</c:if>
<c:if test="${member.favorite3 != '취미'}">
<option value="취미" >취미</option>
</c:if>

<c:if test="${member.favorite3 == '만화'}">
<option value="만화" selected="selected">만화</option>
</c:if>
<c:if test="${member.favorite3 != '만화'}">
<option value="만화" >만화</option>
</c:if>

<c:if test="${member.favorite3 == '잡지'}">
<option value="잡지" selected="selected">잡지</option>
</c:if>
<c:if test="${member.favorite3 != '잡지'}">
<option value="잡지" >잡지</option>
</c:if>

<c:if test="${member.favorite3 == '교육'}">
<option value="교육" selected="selected">교육</option>
</c:if>
<c:if test="${member.favorite3 != '교육'}">
<option value="교육" >교육</option>
</c:if>

<c:if test="${member.favorite3 == '요리'}">
<option value="요리" selected="selected">요리</option>
</c:if>
<c:if test="${member.favorite3 != '요리'}">
<option value="요리" >요리</option>
</c:if>
</select>
<br>
     	<label for="inputAddress" class="col-lg-2 control-label">주소</label>
       	<input type="text" name="address" value="${member.address}" style="width: 550px;"/>
       	<br>
	    <input type="submit" class="btn btn-primary" value="수정완료"/>		
		<input type="reset" class="btn btn-defualt" value="취소" onclick="history.back()" />
    </form>
</body>
<jsp:include page="../footer.jsp"/>
</html>