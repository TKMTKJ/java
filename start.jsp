<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>게임Main</title>
		<style>
			#wrap{
				width :600px;
				margin : 0 auto;
			}
		</style>
	</head>
	<body>
		<div id="wrap">
			<canvas id="can">
			
			</canvas>
			<script>
			var canvas=document.getElementById("can");
			var ctx=canvas.getContext("2d");
			canvas.width=600;
			canvas.height=600;
			
			
			//var img	[] = new Image(){};
			
			var img= new Image();
			var img2= new Image();
			var img3= new Image();
			var img4 = new Image();
			var img5= new Image();
			var img6= new Image();
			var img7 = new Image();
			var img8= new Image();
			var img9= new Image();
			var img10 = new Image();
			var img11= new Image();
			var img12 = new Image();
			var img13 = new Image();
			var img14 = new Image();
			var img15 = new Image();
			var img16 = new Image();
			var img17 = new Image();
			var img18 = new Image();
			var img19 = new Image();
			var img20 = new Image();
			var img21 = new Image();
			var img22 = new Image();
			var img23 = new Image();
			var img24 = new Image();
			var img25 = new Image();
			var img26 = new Image();
			var img27 = new Image();
			
			img.src='img/angle2.png';				//낚시꾼
			img2.src='img/background.png';			//배경
			img3.src='img/chawfish-1.png';			//가재
			img4.src='img/shark-1.png';				//상어
			img5.src='img/sola.png';				//소라
			img6.src='img/rockfish-1.png';			//우럭
			img7.src='img/saury-1.png';				//꽁치
			img8.src='img/halibut-1.png';			//광어
			img9.src='img/domi-1.png';				//도미
			img10.src="img/background2.png";		//낚시꾼 배경
			//도미
			img11.src='img/domi.png';
			img12.src='img/domi-2.png';
			//가재
			img14.src='img/chawfish.png';
			img15.src='img/chawfish-2.png';
			//광어
			img16.src='img/halibut.png';
			img17.src='img/halibut-2.png';
			//우럭
			img19.src='img/rockfish.png';
			img20.src='img/rockfish-2.png';
			//꽁치
			img21.src='img/saury.png';
			img22.src='img/saury-2.png';
			//상어
			img23.src='img/shark.png';
			img24.src='img/shark-2.png';
			//소라
			img25.src='img/sola1.png';
			img26.src='img/sola-1.png';
			//사진 지우기
			img27.src='img/no.png';
			//마우스 클릭 이벤트
			/*canvas.onmousedown = function(event){
				ctx.
				ctx.closePath();
				ctx.fill();
			}*/
		
			
			//낚시꾼 좌표변경을 위한 변수들
			var barx=20;
			var barVx=30;	//낚시꾼 이동속도,1회 갱신시 이동하는 좌표값
			var bary=0;
			
			//키보드로 좌표를 움직여주는 부분
			window.addEventListener("keydown",movBar);
			canvas.addEventListener("mousedown",mousedown);
			//ctx.getImage
		//a.addEventListener("mousedown",mousedown);
		//img11.addEventListener("mousedown",mousedown);
		//img12.addEventListener("mousedown",mousedown);
						
			
			//마우스가 클릭 되엇을때 사라지는 부분
			function mousedown(e){
				var mouseD=e.onmousedown;
				if(mouseD==onmousedown){
					domiVx=img27;
					alert('도미가 클릭 되었습니다.');
				}
				
			}
			
			//키보드가 눌렸을 때 실행될 함수
			function movBar(e){
				var code=e.keyCode;
				if(code==39){ //오른쪽 화살표가 눌린 경우
					barx+=barVx; //오른쪽으로 한당위 이동,x좌표값 증가
				}else if(code==37){// 왼쪽 화살표가 눌린경우
					barx-=barVx;	//왼쪽으로 한단위 이동, x좌표값 감소
				}
				drawBar();
			}
			
			//막대기를 그려주는 함수
			function drawBar(){
				//ctx.beginPath();	//그림그리기 시작점
				//ctx.clearRect(0, 0, canvas.width ,canvas.height ); //기존의 그림을
				ctx.drawImage(img,barx,bary,70,50) //(시작x좌표, 시작y좌표, 너비, 높이)
				//ctx.fillStyle="green";
				//ctx.fill();
				//ctx.closePath();	//그림그리기 종료지점
			}
			drawBar();
			
			//공의 좌표
			//var ballx=20;
			
			//물고기 X 값
			var chawX=450;
			var sharkX=400;
			var rockfishX=250;
			var sauryX=500;
			var halibutX=150;
			var domiX=20;
			var solaX=20;
			
			//물고기 Vx값 == 속도
			var chawVx=5;		
			var halibutVx=8;
			var rockfishVx=10;
			var sauryVx=7;
			var sharkVx=6;
			var domiVx=12;
			var solaVx=2;
			
			//var bally=20;
			//var ballVy=2;
			//var subx=200;
			//물고기들 Y값
			var chawY=500;		//가재
			var	sharkY=300;		//상어
			var rockfishY=435;	//우럭
			var sauryY=375;		//꽁치
			var halibutY=500;	//광어
			var domiY=400;		//도미
			var solaY=500;		//소라
			
			//공 움직이는 구현 함수
			setInterval(mov,20);
			function mov(){
					
				ctx.beginPath();
			//	ctx.moveTo(50,25);
			//	ctx.lineTo(250,25);
			//	ctx.stroke();
				ctx.clearRect(0,0, canvas.width, canvas.height);
				//ctx.drawImage(img,0,0,50,50);			//낚시꾼
				ctx.drawImage(img2,20,50,600,600);		//배경
				//ctx.drawImage(img3,50,500,100,100);	//가재
				//ctx.drawImage(img4,300,300,100,100);	//상어
				//ctx.drawImage(img5,200,500,100,100);	//소라
				//ctx.drawImage(img6,50,425,100,100);	//우럭
				//ctx.drawImage(img7,50,375,100,100);	//꽁치
				//ctx.drawImage(img 200,500,100,100);	//광어
				//ctx.drawImage(img9,200,400,100,100);	//도미
				ctx.drawImage(img10,20,0,600,50);		//낙시꾼 배경
				
				
				
				
				//ctx.arc(ballx, bally, 20, 0, Math.PI*2, true);

				//물고기 움직이는 함수
				ctx.drawImage(img3,	chawX ,chawY,100,100);
				ctx.drawImage(img4, sharkX ,sharkY,100,100);
				ctx.drawImage(img6,	rockfishX, rockfishY,100,100);
				ctx.drawImage(img7,	sauryX,sauryY,100,100);
				ctx.drawImage(img8, halibutX, halibutY,100,100);
				ctx.drawImage(img9, domiX ,domiY,100,100);
				ctx.drawImage(img5, solaX, solaY,100,100);
				
				

				//ctx.arc(ballx, bally, img4)
				//arc(중심x좌표, 중심y좌표, 반지름, 시작각도, 종료각도, 반시계방향 여부)
				/*ctx.fillStyle="red";
				ctx.fill();
				ctx.closePath();
				*/
				//공이 이동하면서 한번씩 막대기도 그려주도록 변경
				//ctx.beginPath();
				drawBar();
				//ctx.fillStyle="blue";
				//ctx.fill();
				
				
				ctx.closePath();
				
				//공 좌표값 변동
				chawX+=chawVx;					//가재
				sharkX+=sharkVx;				//상어
				rockfishX+=rockfishVx;			//우럭
				sauryX+=sauryVx;				//꽁치
				halibutX+=halibutVx;			//광어
				domiX+=domiVx;					//도미
				solaX+=solaVx;					//소라
				//bally+=ballVy;	

				//충돌체크	낚시꾼
				if(barx>canvas.width-60){ 	//낚시꾼 오른쪽 충돌판정
					barx-=barVx;
				}
				if(barx<0+20){				//낚시꾼 왼쪽 충돌판정
					barx+=barVx;
				}
				//물고기 충돌 좌우 체인지
				//도미
				if(domiX>canvas.width-100 ){
					domiVx*=-1;
					img9=img11;
				}
				if( domiX<0+20 ) {
					domiVx*=-1;
					img9=img12;
				}
				//가재
				if(chawX>canvas.width-100 ){
					chawVx*=-1;
					img3=img14;
				}
				if( chawX<0+20 ) {
					chawVx*=-1;
					img3=img15;
				}
				//광어
				if(halibutX>canvas.width-100 ){
					halibutVx*=-1;
					img8=img16;
				}
				if( halibutX<0+20 ) {
					halibutVx*=-1;
					img8=img17;
				}
				//우럭
				if(rockfishX>canvas.width-100 ){
					rockfishVx*=-1;
					img6=img19;
				}
				if( rockfishX<0+20 ) {
					rockfishVx*=-1;
					img6=img20;
				}
				//꽁치
				if(sauryX>canvas.width-100 ){
					sauryVx*=-1;
					img7=img21;
				}
				if( sauryX<0+20 ) {
					sauryVx*=-1;
					img7=img22;
				}
				//상어
				if(sharkX>canvas.width-100 ){
					sharkVx*=-1;
					img4=img23;
				}
				if( sharkX<0+20 ) {
					sharkVx*=-1;
					img4=img24;
				}
				//소라
				if(solaX>canvas.width-100 ){
					solaVx*=-1;
					img5=img26;
				}
				if( solaX<0+20 ) {
					solaVx*=-1;
					img5=img25;
				}
				//var input = document.createElement(img5);
				//input.type = "button";
				//input.ImageElement("click", function(){
				//	alert("확인");
				//});
				
			//	img5.onclick="fishing";
			//	img26.onclick="fishing";
			//	img25.onclick="fishing";
			
			
				
				
				/*if(barx>canvas.width-130 || barx<0+20){
						barVx*=+1;
						barx-=barVx;
				}
				/*if(halibutx>canvas.width-100 || ballx<0+100){
						ballVx*=-1;
				}*/
				//막대기 충돌판정
				/*if(ballx>=barx && ballx<=barx+100 && bally>bary-20){
				ballVy*=-1;
				}*/
				
			}
			mov();

	
			
			</script>
		</div>
	</body>
</html>