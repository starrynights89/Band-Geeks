/*
 * This file is going to make sure that someone is logged in
 * on whatever page i happen to go to.
 */
let navbar = `
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand">
        <span class="badge-primary">Richard's Bookstore</span>
    </a>
	<ul class="navbar-nav mr-auto" id="authent">
	</ul>
</nav>
`;
let unauthenticated = `
	<li class="nav-item">
		Username: <input type="text" id="username">
	</li>
	<li class="nav-item">
		Password: <input type="password" id="password">
	</li>
	<li class="nav-item">
		<button class="btn btn-primary" id="login">Login</button>
	</li>
    `;
let authenticated = `
	<li class="nav-item">
		Welcome <span id="authUserName"></span> 
	</li>
	<li class="nav-item">
		<button class="btn btn-danger" id="logout">Logout</button>
	</li>`;
employee = null;
customer = null;
baseURL = '/BookStore/';

function addNavBar() {
	console.log('adding nav bar');
	let body = document.getElementsByTagName('body')[0];
	let div = document.createElement('div');
	div.innerHTML = navbar;
	body.insertBefore(div, body.childNodes[0]);
	
	let authent = document.getElementById('authent');
	authent.innerHTML = unauthenticated;
	
	// add event listeners
	document.getElementById('login').addEventListener('click', authenticate);
	document.getElementById('password').onkeydown = checkPasswordEnter;
	authenticate();
}

function checkPasswordEnter() {
	if (event.which === 13) {
		authenticate();
	}
}

function authenticate() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = loginSuccess;
	xhttp.open('POST', baseURL+'login');
	xhttp.setRequestHeader('Content-type',
			'application/x-www-form-urlencoded');
	let user = document.getElementById('username').value;
	let pass = document.getElementById('password').value;
	xhttp.send('user='+user+'&pass='+pass);
	
	function loginSuccess() {
		if (xhttp.readyState === 4 && xhttp.status === 200) {
			let data = JSON.parse(xhttp.responseText);
			console.log(data);
			employee = data.employee;
			customer = data.customer;
			document.getElementById('authent').innerHTML=authenticated;
			document.getElementById('logout').onclick=logout;
			if (customer) {
				document.getElementById('authUserName').innerHTML = 
					customer.first + ' ' + customer.last;
			}
			if (employee) {
				document.getElementById('authUserName').innerHTML = 
					employee.title+': '+employee.first + ' ' + employee.last;
				let btns = document.getElementsByClassName('emp-btn');
				for (let i = 0 ; i< btns.length; i++){
					btns[i].disabled = false;
				}
			}
		}
	}
}

function logout() {
	console.log("logging out");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = finish;
    xhttp.open("DELETE", baseURL + "login");
    xhttp.send();
    
    function finish() {
    	if (xhttp.readyState === 4 && xhttp.status === 204) {
            document.getElementById("authent").innerHTML = unauthenticated;
            let btns = document.getElementsByClassName("emp-btn");
            for (let i = 0; i < btns.length; i++) {
                btns[i].disabled = true;
            }
            document.getElementById("login").addEventListener("click", authenticate);
            document.getElementById("password").onkeydown = checkPasswordEnter;
        }
    }
	
}