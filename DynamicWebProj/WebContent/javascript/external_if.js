/**
 * 
 */

window.onload = function () {
	
	btn1.onclick = function() {
		
		var score = prompt ("점수를 입력하세요 ", 100);
		var result = "가";
		if (score >= 90 ) 	result = "수" ;
		else if (score >= 80 ) result = "우" ;
		else if (score >= 70 ) result = "미" ;
		else if (score >= 60 ) result = "양" ;
		here.innerHTML=result;
	};
};