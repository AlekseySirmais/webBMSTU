
var l=[];//для проверки айди новости

window.onload = function () {
    fil();
}

function fil() {
    setInterval(addRow, 500); // обновление каждую секунду(добавлние елсли появились новые новости)
}

function addRow() {
    var xhr = new XMLHttpRequest();// подходит для всех браузеров много библиотек!



    xhr.open('GET',"/table",true);// послединй параметро про синхронность
    xhr.onreadystatechange = function () {//
        if (xhr.readyState == 4) {//чекаем на соединение
            if (xhr.status == 200) {//
                var jsonResponse = JSON.parse(xhr.responseText);//парсим json строку
                for (var i = 0; i < jsonResponse.length; i++) {
                    insertData(jsonResponse[i]);//
                }
            }
        }
    };
    xhr.send(null);
}

function insertData(jsonData) {


 var idChec=jsonData.newsId; // получаем айди новости
var bool=true; // булева пременная для выполнения добавления новости
 for (var i=0;i<l.length;i++){ //проверяем наличие новости на странице
     if (l[i]==idChec) bool=false;

 }
    if (bool) l[l.length]=idChec;
 if (bool){

    var table = document.getElementById("maintable");
    var tr = document.createElement("tr");
    tr.setAttribute("id", jsonData.newsId);//
    var author = document.createElement("td");
    author.innerHTML = jsonData.author;//смотри джейсон сроку!
    var text = document.createElement("td");
    text.innerHTML = jsonData.text;//смотри джейсон сроку!
    var tittle = document.createElement("td");
    tittle.innerHTML = "<h2 align=\"center\" > <a href=oneNews.jsp?id="+jsonData.newsId+"&title="+jsonData.tittle+"&author="+jsonData.author+">"+jsonData.tittle+"</a>  </h2>";//смотри джейсон сроку!






    tr.appendChild(author);
    tr.appendChild(tittle);
    tr.appendChild(text);

    table.appendChild(tr);}
}