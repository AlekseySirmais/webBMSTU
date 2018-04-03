
var l=[];//для проверки айди новости

window.onload = function () {
    fil();
}

function fil() {
    setInterval(addRow, 1000); // обновление каждую секунду(добавлние елсли появились новые новости)
}

function addRow() {
    var xhr = new XMLHttpRequest();// подходит для всех браузеров много библиотек!



    xhr.open('GET',"/admin",true);// послединй параметро про синхронность
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


    var idChec=jsonData.mID; // получаем айди новости
    var bool=true; // булева пременная для выполнения добавления новости
    for (var i=0;i<l.length;i++) { //проверяем наличие новости на странице
        if (l[i] == idChec) bool = false;

    }

    if (bool) l[l.length]=idChec;
    if (bool){


        var table = document.getElementById("admintable");
        var tr = document.createElement("tr");
        tr.setAttribute("id", jsonData.mID);
        var idd = document.createElement("td");
        idd.innerHTML = jsonData.mID;//смотри джейсон сроку!

        var password = document.createElement("td");
        password.innerHTML = jsonData.mPassword;//смотри джейсон сроку!
        var name = document.createElement("td");
        name.innerHTML = jsonData.mName;//смотри джейсон сроку!

        var email = document.createElement("td");
        email.innerHTML = jsonData.mEmail;//смотри джейсон сроку![{"mName":"alex","mPassword":"131313","mID":1,"mEmail":"@@@"},



        tr.appendChild(idd);
        tr.appendChild(name);
        tr.appendChild(password);
        tr.appendChild(email);
        table.appendChild(tr);


    }
}