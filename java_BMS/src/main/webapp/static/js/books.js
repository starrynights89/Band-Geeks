window.onload = () => {
    getBooks();
    addNavBar();
}

function getBooks(){
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = parseBook;
    xhttp.open('GET', 'books');
    xhttp.send();

    function parseBook(){
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let books = xhttp.responseText;
            books = JSON.parse(books);
            console.log(books);
            books.sort((b1, b2) => b1.title.localeCompare(b2.title));
            console.log(books);
            books.forEach(book => {
                addBookToTable(book);
            });
        }
    }
}
function addBookToTable(book) {
    let table = document.getElementById('books');
    let tr = document.createElement('tr');
    let td;
    // id
    addTableDef(tr, book.id);
    // cover
    td = document.createElement('td');
    tr.appendChild(td);
    let img = document.createElement('img');
    td.appendChild(img);
    img.src = book.cover;
    img.alt = book.title;
    img.className = 'img-fluid';
    // isbn10
    addTableDef(tr, book.isbn10);
    // isbn13
    addTableDef(tr, book.isbn13);
    // title
    addTableDef(tr, book.title);
    // authors
    addListToTable(tr, book.authors, (author) => {
    	return `${author.first} ${author.last}`;
    });
    // genres
    addListToTable(tr, book.genres, (genre)=>{
    	return `${genre.genre}`;
    });
    // price
    addTableDef(tr, book.price);
    // stock
    addTableDef(tr, book.stock);
    // edit
    td = document.createElement('td');
    let editButton = document.createElement('button');
    tr.appendChild(td);
    td.appendChild(editButton);
    editButton.innerHTML = 'Edit';
    editButton.className='btn btn-secondary emp-btn';
    editButton.disabled=employee?false:true;
    editButton.onclick = editBook;
    editButton.id = 'e_b_'+book.id;
    // delete
    td = document.createElement('td');
    let delButton = document.createElement('button');
    tr.appendChild(td);
    td.appendChild(delButton);
    delButton.innerHTML = 'X';
    delButton.className='btn btn-danger emp-btn';
    delButton.disabled=employee?false:true;
    delButton.onclick = deleteBook;
    delButton.id = 'd_b_'+book.id;
    table.appendChild(tr);
}

function deleteBook() {
	let btn = event.target;
	let id = btn.id.substring('d_b_'.length);
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = removeBook;
	xhttp.open('DELETE', baseURL+'books/'+id);
	xhttp.send();
	
	function removeBook(){
		if(xhttp.readyState === 4 && xhttp.status === 204) {
			location.reload();
		}
	}
}

function editBook() {
	let btn = event.target;
    console.log(btn);
    var id=btn.id.substring('e_b_'.length);
    console.log(id);
    window.location.href='editBook/'+id;
}

function addListToTable(parentNode, list, getString) {
	let td = document.createElement('td');
    let ul = document.createElement('ul');
    for(let item of list) {
    	let li = document.createElement('li');
    	li.innerHTML = getString(item);
    	ul.appendChild(li);
    }
    td.appendChild(ul);
    parentNode.appendChild(td);
}

function addTableDef(row, value) {
    let td = document.createElement('td');
    td.innerHTML = value;
    row.appendChild(td);
}