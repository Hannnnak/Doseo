<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품수정</title>
</head>
<body>
<form name="modifyFrm" method="post" action="modify.dom">
<input type="hidden" name="pNo" value="${modReq.pNo}"/>
<table id="list">
<tr>
	<th>제품번호</th>
	<td>${modReq.pNo}</td>
	
</tr>

<tr>
  <th>장르(분야)</th>
   <td><select name="category" id="category">
        <option selected="">${modReq.category}</option>
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
    <td><input type="text" name="pDate" value="${modReq.pDate}"/></td>
 </tr>

<tr>
  <th>도서명</th>
  <td width="343" colspan="5">
       <input type="text" name="pName" size="47" maxlength="100" value="${modReq.pName}">
  </td>
</tr>
<tr>
	<th>작가</th>
	<td><input type="text" name="writer" value="${modReq.writer}"></td> 
	<th>출판사</th>
	<td><input type="text" name="publishing" value="${modReq.publishing}">  </td>
</tr>
<tr>
  <th>정가</th>
  <td width="70">
    <input type="text" name="pPrice" size="11" value="${modReq.pPrice}">
  </td>
  <th>할인율</th>
  <td width="70">
  	<select name="discount" id="discount">
        <option selected="">${modReq.discount}</option>
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
      <textarea name="detailContent" rows="8" cols="70" >${modReq.detailContent}</textarea>
    </td>
  </tr>
  <tr>
    <th>상품이미지</th>
    <td width="343" colspan="5">
    	
      <input type="file" name="imageFileURL" value="${modReq.imageFileURL}">
    </td>
  </tr>    
</table>
<input type="submit" value="수정" >           
<input type="reset" value="취소">
</form> 
</body>
</html>