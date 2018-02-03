function Validate(){
	var fristName = document.getElementById("1").value;
	if(fristName==""){
		window.alert("Enter first name");
	}
	
	var LastName = document.getElementById("2").value;	
	if(LastName==""){
		window.alert("Enter last name");
	}
	var email = document.getElementById("3").value;	
	if(email==""){
		window.alert("Enter email");
	}
	var pass = document.getElementById("4").value;	
	if(pass==""){
		window.alert("Enter password");
	}
};