const title = document.querySelector("#title");

const BASE_COLOR = "rgb(251,197,49)";
const OTHER_COLOR = "#fbc531";

/*function handleResize(event){
	console.log(event);
	console.log("I have been resized");
}*/

function handleClick(){
	const curruntColor = title.style.color;
		if(curruntColor === BASE_COLOR){
			title.style.color = OTHER_COLOR;
		}else{
			title.style.color = BASE_COLOR;
		}
}

function init(){
	title.style.color = BASE_COLOR;
	title.addEventListener("click", handleClick);
}

init();

function handleOffline(){
	console.log("turn off the wifi");
}
function handleOnline(){
	console.log("turn on the wifi");
}

window.addEventListener("offline", handleOffline);
window.addEventListener("online", handleOnline);
