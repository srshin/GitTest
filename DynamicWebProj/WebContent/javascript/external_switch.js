/**
 * 
 */

window.onload = function () {
	
	btn1.onclick = function() {
		
		var score = prompt ("점수를 입력하세요 ", 100);
		var result = "가";
		score = Math.floor(score /10);
		switch (score) {
		case 10 : 
		case 9 : 	result = "수" ;break;
		case 8 : result = "우" ;break;
		case 7 : result = "미" ;break;
		case 6 : result = "양" ;break;
		}
		here.innerHTML=score + "  " + result;
	};
};