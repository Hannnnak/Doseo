<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
 <script>
 
    function checkz() {
        var getIntro = $("#intro").val().replace(/\s|/gi,'');
        var hobbyCheck = false;
        var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
        var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/);
        var getName= RegExp(/^[가-힣]+$/);
        var fmt = RegExp(/^\d{6}[1234]\d{6}$/); //형식 설정
        var buf = new Array(13); //주민등록번호 배열
 
      if($("#tbID").val() == ""){
          alert("아이디 입력바람");
          $("#tbID").focus();
          return false;
        }
      
      //이름의 유효성 검사
      if(!getCheck.test($("#tbID").val())){
        alert("형식에 맞게 입력해주세요");
        $("#tbID").val("");
        $("#tbID").focus();
        return false;
      }
 
      //비밀번호
      if(!getCheck.test($("#tbPwd").val())) {
      alert("형식에 맞춰서 PW를 입력해줘용");
      $("#tbPwd").val("");
      $("#tbPwd").focus();
      return false;
      }
 
      //아이디랑 비밀번호랑 같은지
      if ($("#tbID").val()==($("#tbPwd").val())) {
      alert("비밀번호가 ID와 똑같으면 안!대!");
      $("#tbPwd").val("");
      $("#tbPwd").focus();
    }
 
      //비밀번호 똑같은지
      if($("#tbPwd").val() != ($("#cpass").val())){ 
      alert("비밀번호가 틀렸네용.");
      $("#tbPwd").val("");
      $("#cpass").val("");
      $("#tbPwd").focus();
      return false;
     }
 
     //이메일 공백 확인
      if($("#mail").val() == ""){
        alert("이메일을 입력해주세요");
        $("#mail").focus();
        return false;
      }
           
      //이메일 유효성 검사
      if(!getMail.test($("#mail").val())){
        alert("이메일형식에 맞게 입력해주세요")
        $("#mail").val("");
        $("#mail").focus();
        return false;
      }
 
      //이름 유효성
      if (!getName.test($("#name").val())) {
        alert("이름 똑띠 쓰세용");
        $("#name").val("");
        $("#name").focus();
        return false;
      }
 
      //주민번호
      if(($("#id_num").val() == "") || ($("#id_num_back").val() == "")){
        alert("주민등록번호를 입력해주세요");
        $("#id_num").focus();
        return false;
      }
 
      if(check_jumin() ==false){
        return false;
      }
 
    return true;
  }
 
    
 // html 이 다 로딩된 후 실행
    $(document).ready(function() {
        // 체크박스들이 변경됬을때
        $(":checkbox").change(function() {
            var limit = "5";
             
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
	<h3>회원가입폼 joinForm.jsp(p600)</h3>
	<p>http://localhost/board/join.do</p>
	<form onsubmit="return checkz()" name="joinFrm" id="joinFrm" action="join.do" method="post">
		<p>
			아이디 : <input type="text" name="id" id="tbID" value="${param.id}" placeholder="최대 10자리" maxlength="10"  />
			<c:if test="${errors.id}">아이디를 입력하세요.</c:if>
			<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
		</p>
		<p>
			비밀번호 : <input type="password" name="password" placeholder="비밀번호" />
			<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
			
		</p>
		<p>
			비번확인 : <input type="password" name="confirmPassword" placeholder="비밀번호 확인" />
			<c:if test="${errors.confirmPassword}">비밀번호 확인을 입력하세요.</c:if>
			<c:if test="${errors.notMatch}">입력된 두 비밀번호가 일치하지 않습니다.</c:if>
		</p>
		<p>
			이 름 : <input type="text" name="name" placeholder="이름" />
			<c:if test="${errors.name}">이름을 입력하세요.</c:if>
		</p>
		<p>
      <input type="radio" name="gender" value="남자" checked />남자
     	<input type="radio" name="gender" value="여자" checked />여자
		</p>
		<p>
			생 일 : 
			 <input type="text" name="birthyy" maxlength="4" placeholder="년(4자)" size="6" >년
       <select name="birthmm">
		     <option value="">선택</option>
		     <option value="01" >1</option>
		     <option value="02" >2</option>
		     <option value="03" >3</option>
		     <option value="04" >4</option>
		     <option value="05" >5</option>
		     <option value="06" >6</option>
		     <option value="07" >7</option>
		     <option value="08" >8</option>
		     <option value="09" >9</option>
		     <option value="10" >10</option>
		     <option value="11" >11</option>
		     <option value="12" >12</option>
       </select>월
       <select name="birthdd">
		     <option value="">선택</option>
		     <option value="01" >1</option>
		     <option value="02" >2</option>
		     <option value="03" >3</option>
		     <option value="04" >4</option>
		     <option value="05" >5</option>
		     <option value="06" >6</option>
		     <option value="07" >7</option>
		     <option value="08" >8</option>
		     <option value="09" >9</option>
		     <option value="10" >10</option>
		     <option value="11" >11</option>
		     <option value="12" >12</option>
		     <option value="13" >13</option>
		     <option value="14" >14</option>
		     <option value="15" >15</option>
		     <option value="16" >16</option>
		     <option value="17" >17</option>
		     <option value="18" >18</option>
		     <option value="19" >19</option>
		     <option value="20" >20</option>
		     <option value="21" >21</option>
		     <option value="22" >22</option>
		     <option value="23" >23</option>
		     <option value="24" >24</option>
		     <option value="25" >25</option>
		     <option value="26" >26</option>
		     <option value="27" >27</option>
		     <option value="28" >28</option>
		     <option value="29" >29</option>
		     <option value="30" >30</option>
		     <option value="31" >31</option>		     
       </select>일
		</p>
		<p>전화번호 : <select name="phone1">
       <option value="010">010</option>
       <option value="011">011</option>
       <option value="016">016</option>
       <option value="017">017</option>
       <option value="019">019</option>
     </select> -
     <input type="text" name="phone2" size="5" maxlength="4"> - 
     <input type="text" name="phone3" size="5" maxlength="4">
		 
		</p>
		<p>이메일 : <br/>
		<input type="text" name="email1" maxlength="50">@
    <select name="email2">
    		<option></option>
        <option value="naver.com">naver.com</option>
        <option value="daum.net">daum.net</option>
        <option value="gmail.com">gmail.com</option>
        <option value="nate.com">nate.com</option>                        
    </select>
		</p>

<table border="1">
		<p>선호장르(최대 5개) :
		 <label><input type="checkbox" name="favorite" value="소설" />소설</label>
		 <label><input type="checkbox" name="favorite" value="시" />시</label>
		 <label><input type="checkbox" name="favorite" value="에세이" />에세이</label>
		 <label><input type="checkbox" name="favorite" value="종교" />종교</label>
		 <label><input type="checkbox" name="favorite" value="과학" />과학</label>
		 <label><input type="checkbox" name="favorite" value="사회" />사회</label>
		 <label><input type="checkbox" name="favorite" value="예술" />예술</label>
		 <label><input type="checkbox" name="favorite" value="경제" />경제</label>
		 <label><input type="checkbox" name="favorite" value="자기개발" />자기개발</label>
		 <label><input type="checkbox" name="favorite" value="취미" />취미</label>
		 <label><input type="checkbox" name="favorite" value="만화" />만화</label>
		 <label><input type="checkbox" name="favorite" value="잡지" />잡지</label>
		 <label><input type="checkbox" name="favorite" value="교육" />교육</label>
		 <label><input type="checkbox" name="favorite" value="요리" />요리</label>	 
		</p>
</table>
		
		
		
		<p>주 소 : <br/>
			<input type="text" id="sample4_postcode" name="add4" placeholder="우편번호">
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample4_roadAddress" name="add1" placeholder="도로명주소">
			<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="sample4_detailAddress" name="add2" placeholder="상세주소">
			<input type="text" id="sample4_extraAddress" name="add3" placeholder="참고항목">
		</p>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>

		
		<input type="submit" value="가입"/>		
		<input type="reset"  value="취소"/>
	</form>
</body>
</html>













