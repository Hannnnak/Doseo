<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script type="text/javascript">
	function validate(){
		var obj = document.productFrm;
		
		if(obj['category'].value=='none'){
			alert('장르를 선택해주세요.')
			obj['category'].focus();
			return false;
		}
		
		if(obj['pName'].value==''){
			alert('책 제목을 입력해주세요.')
			obj['pName'].focus();
			return false;
		}
		
		if(obj['pDate'].value==''){
			alert('출판일을 입력해주세요.')
			obj['pDate'].focus();
			return false;
		}
		
		if(obj['writer'].value==''){
			alert('작가를 입력해주세요.')
			obj['writer'].focus();
			return false;
		}

		if(obj['publishing'].value==''){
			alert('출판사를 입력해주세요.')
			obj['publishing'].focus();
			return false;
		}

		if(obj['pPrice'].value==''){
			alert('정가를 입력해주세요.')
			obj['pPrice'].focus();
			return false;
		}
		
		if(obj['discount'].value==''){
			alert('할인율을 입력해주세요.')
			obj['discount'].focus();
			return false;
		}
		
		if(obj['detailContent'].value==''){
			alert('상세 설명을 입력해주세요.')
			obj['detailContent'].focus();
			return false;
		}

		if(obj['imageFileURL'].value==''){
			alert('이미지를 입력해주세요.')
			obj['imageFileURL'].focus();
			return false;
		}
		
	}
</script>
<style>
	  body {
		margin: 20px 20px 0 20px; 
   }
</style>
</head>
<body>
<a href="../main.dom">Home</a>
<hr>
<h4>상품등록</h4>
<form name="productFrm" method="post" action="write.dom" enctype="multipart/form-data" onsubmit="return validate();">
<table id="list">
<tr>
  <th>장르(분야)</th>
   <td><select name="category" id="category">
        <option value="none" selected="">선택하세요</option>
        <option value="가정/유아">가정/유아</option>
        <option value="건강">건강</option>
        <option value="경제/경영">경제/경영</option>
        <option value="과학">과학</option>
        <option value="만화">만화</option>
        <option value="소설">소설</option>
        <option value="시/에세이">시/에세이</option>
        <option value="어린이(초등)">어린이(초등)</option>
        <option value="역사/문화">역사/문화</option>
        <option value="예술/대중문화">예술/대중문화</option>
        <option value="외국어">외국어</option>
        <option value="요리">요리</option>
        <option value="유아(0~7세)">유아(0~7세)</option>
        <option value="인문">인문</option>
        <option value="자기계발">자기계발</option>
        <option value="정치/사회">정치/시회</option>
        <option value="종교">종교</option>
        <option value="컴퓨터/IT">컴퓨터/IT</option>
        </select>
    </td>   
    <th>출판일</th>
    <td>
    <input type="text" name="pDate" placeholder="2020-05-22"/>
    </td>
 </tr>

<tr>
  <th>도서명</th>
  <td width="343" colspan="5">
       <input type="text" name="pName" size="47" maxlength="100">
  </td>
</tr>
<tr>
	<th>작가</th>
	<td><input type="text" name="writer"/> </td> 
	<th>출판사</th>
	<td><input type="text" name="publishing"/>  </td>
</tr>
<tr>
  <th>정가</th>
  <td width="70">
    <input type="text" name="pPrice" size="11">
  </td>
  <th>할인율</th>
  <td width="70">
  	<select name="discount" id="discount">
        <option selected="">선택하세요</option>
        <option value="5">5%</option>
        <option value="10">10%</option>
        <option value="15">15%</option>
        <option value="20">20%</option>
        </select>  
  </td>
  </tr>
    
  <tr>
    <th>상세설명</th>
    <td colspan="5">
      <textarea name="detailContent" rows="8" cols="70" ></textarea>
    </td>
  </tr>
  <tr>
    <th>상품이미지</th>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      <input type="file" name="imageFileURL">
    </td>
  </tr>    
</table>
<input type="submit" value="등록"  >           
<input type="reset" value="취소">
</form> 
</body>
</html>