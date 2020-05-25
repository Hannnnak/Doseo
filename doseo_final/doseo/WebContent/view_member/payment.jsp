<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 현재 페이지를 확대나 축소하지 않고 뷰의 화면의 너비와 동일한 크기로 출력 -->
<meta name ="viewport" content="width=device-width,initial-scale=1.0">
<!-- 스타일 적용 -->
<link rel="stylesheet"href="bootstrap/css/bootstrap.css">
<!-- 스크립트 적용 -->
<script src= "bootstrap/js/jquery.min.js"></script>
<script src= "bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
	body {
		margin: 200px 500px 0 500px;
		text-align: center;
		line-height: 100px;
	}
</style>
</head>
<body>
	<div>
		<a id="check_creditCard" class="btn btn-outline-primary btn-block">신용카드</a>	
		<a id="check_real-timeBankTransfer" type="button" class="btn btn-outline-primary btn-block">실시간 계좌이체</a>
		<a id="check_vbank" type="button" class="btn btn-outline-primary btn-block">가상계좌</a>
		<a id="check_phone" type="button" class="btn btn-outline-primary btn-block">휴대폰 소액결제</a>		
		<a id="check_kakaopay" type="button" style="margin-top: 10px;"><img src="view_member/payment_text_small.png"></a>
	</div>
	
<!-- 여기서부터는 결제방식에 따른 각각의 코드 -->	
<!-- 아임포트 신용카드 간편결제 구동 코드 -->
<script>
	$("#check_creditCard").click(function () {
		var IMP = window.IMP;
        IMP.init('imp95538470'); 
        IMP.request_pay({
            pg: 'html5_inicis',
            /* 
                'kakao':카카오페이, 
               	'html5_inicis':이니시스(웹표준결제)
                'nice':나이스페이
                'jtnet':제이티넷
                'uplus':LG유플러스
                'danal':다날
                'payco':페이코
                'syrup':시럽페이
                'paypal':페이팔
            */
            pay_method: 'card',
            /* 
                'samsung':삼성페이, 
                'card':신용카드, 
                'trans':실시간계좌이체,
                'vbank':가상계좌,
                'phone':휴대폰소액결제 
            */
            merchant_uid: 'merchant_' + new Date().getTime(),
            /* 
				merchant_uid에 경우 
				https://docs.iamport.kr/implementation/payment
				위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
				참고하세요. 
				나중에 포스팅 해볼게요.
             */
            //결제창에서 보여질 이름
            name: '${param.orderBook}',
            //가격 
            amount: '${param.sum}', 
            buyer_email: 'iamport@siot.do',
            buyer_name: '구매자이름',
            buyer_tel: '010-1234-5678',
            buyer_addr: '서울특별시 강남구 삼성동',
            buyer_postcode: '123-456',
            m_redirect_url: 'https://www.yourdomain.com/payments/complete'
            /*  
		                모바일 결제시,
		                결제가 끝나고 랜딩되는 URL을 지정 
               (카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐) 
            */
        }, function (rsp) {
            console.log(rsp);
            if (rsp.success) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                msg += '\n결제 금액 : ' + rsp.paid_amount;
                msg += '\n카드 승인번호 : ' + rsp.apply_num;
                location.href="<%= request.getContextPath()%>/paymentSuccess.dom?type=card&address=${address}&requests=${requests}";
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '\n에러내용 : ' + rsp.error_msg;
                location.href="../cart.dom";
            }
            alert(msg);
        });
    });
</script>

<!-- 아임포트 카카오페이 카드 결제 구현 -->
<script>
	$("#check_kakaopay").click(function () {
        var IMP = window.IMP; // 생략가능
        IMP.init('imp23418340'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name: '${param.orderBook}',
            amount: '${param.sum}', 
            buyer_email: 'iamport@siot.do',
            buyer_name: '구매자이름',
            buyer_tel: '010-1234-5678',
            buyer_addr: '서울특별시 강남구 삼성동',
            buyer_postcode: '123-456',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카드 승인번호 : ' + rsp.apply_num;
                        alert(msg);
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                //성공시 이동할 페이지
               <%--  location.href='<%=request.getContextPath()%>/order/paySuccess?msg='+msg; --%>
               location.href="<%= request.getContextPath()%>/paymentSuccess.dom?type=kakaopay&address=${address}&requests=${requests}";
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '\n에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                //location.href="<%=request.getContextPath()%>/order/payFail";
                alert(msg);
                location.href="../cart.dom";
            }
        });
        
    });
</script> 

<!-- 아임포트 다날 휴대폰 소액결제 구현 코드 -->
<script>
	$("#check_phone").click(function () {
		var IMP = window.IMP;
        IMP.init('imp95538470'); 
        IMP.request_pay({
            pg: 'danal',
            pay_method: 'phone',
            merchant_uid: 'merchant_' + new Date().getTime(),
            name: '${param.orderBook}',
            amount: '${param.sum}', 
            buyer_email: 'iamport@siot.do',
            buyer_name: '구매자이름',
            buyer_tel: '010-1234-5678',
            buyer_addr: '서울특별시 강남구 삼성동',
            buyer_postcode: '123-456',
            m_redirect_url: 'https://www.yourdomain.com/payments/complete'
        }, function (rsp) {
            console.log(rsp);
            if (rsp.success) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
                location.href="<%= request.getContextPath()%>/paymentSuccess.dom?type=phone";
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '\n에러내용 : ' + rsp.error_msg;
                location.href="../cart.dom";
            }
            alert(msg);
        });
    });
</script>

<!-- 아임포트 다날 실시간 계좌이체 구현 코드 -->
<script>
	$("#check_real-timeBankTransfer").click(function () {
		var IMP = window.IMP;
        IMP.init('imp95538470'); 
        IMP.request_pay({
            pg: 'danal',
            pay_method: 'trans',
            merchant_uid: 'merchant_' + new Date().getTime(),
            name: '${param.orderBook}',
            amount: '${param.sum}',  
            buyer_email: 'iamport@siot.do',
            buyer_name: '구매자이름',
            buyer_tel: '010-1234-5678',
            buyer_addr: '서울특별시 강남구 삼성동',
            buyer_postcode: '123-456',
            m_redirect_url: 'https://www.yourdomain.com/payments/complete'
        }, function (rsp) {
            console.log(rsp);
            if (rsp.success) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
                location.href="../paymentSuccess.dom?type=timeBankTransfer";
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '\n에러내용 : ' + rsp.error_msg;
                location.href="../cart.dom";
            }
            alert(msg);
        });
    });
</script>

<!-- 아임포트 다날 가상계좌 구현 코드 -->
<script>
	$("#check_vbank").click(function () {
		var IMP = window.IMP;
        IMP.init('imp95538470'); 
        IMP.request_pay({
            pg: 'danal',
            pay_method: 'vbank',
            merchant_uid: 'merchant_' + new Date().getTime(),
            name: '${param.orderBook}',
            amount: '${param.sum}',  
            buyer_email: 'iamport@siot.do',
            buyer_name: '구매자이름',
            buyer_tel: '010-1234-5678',
            buyer_addr: '서울특별시 강남구 삼성동',
            buyer_postcode: '123-456',
            m_redirect_url: 'https://www.yourdomain.com/payments/complete'
        }, function (rsp) {
            console.log(rsp);
            if (rsp.success) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
                location.href="../paymentSuccess.dom?type=vbank";
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '\n에러내용 : ' + rsp.error_msg;
                location.href="../cart.dom";
            }
            alert(msg);
        });
    });
</script>

<form>
<input type="hidden" name="PaymentType" id="type"/>
<input type="hidden" name="total" id="type"/>
</form>

</body>
</html>