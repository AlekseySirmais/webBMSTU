
var l=[];//для проверки айди комента

window.onload = function () {
    fil();
}

function fil() {
    setInterval(addRow, 500); // обновление каждую секунду(добавлние елсли появились новые новости)
}

function addRow() {
    var xhr = new XMLHttpRequest();// подходит для всех браузеров много библиотек!



    xhr.open('GET',"/oneNews",true);// послединй параметро про синхронность
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










function getUrlVar(){
    var urlVar = window.location.search; // получаем параметры из урла
    var arrayVar = []; // массив для хранения переменных
    var valueAndKey = []; // массив для временного хранения значения и имени переменной
    var resultArray = []; // массив для хранения переменных
    arrayVar = (urlVar.substr(1)).split('&'); // разбираем урл на параметры
    if(arrayVar[0]=="") return false; // если нет переменных в урле
    for (i = 0; i < arrayVar.length; i ++) { // перебираем все переменные из урла
        valueAndKey = arrayVar[i].split('='); // пишем в массив имя переменной и ее значение
        resultArray[valueAndKey[0]] = valueAndKey[1]; // пишем в итоговый массив имя переменной и ее значение
    }
    return resultArray; // возвращаем результат
}



function insertData(jsonData) {


    var result = getUrlVar();
   var  par777 =(result['id']);


if (par777==jsonData.idnews){


    var idChec=jsonData.id; // получаем айди новости
    var bool=true; // булева пременная для выполнения добавления новости
    for (var i=0;i<l.length;i++){ //проверяем наличие новости на странице
        if (l[i]==idChec) bool=false;

    }
    if (bool) l[l.length]=idChec;// для простого понимания используется два одинаковых условия (удобно так разложить)
    if (bool){




        var table = document.getElementById("commentstable");
        var tr = document.createElement("tr");
        tr.setAttribute("id", jsonData.id);
        var idd = document.createElement("td");
        idd.innerHTML = jsonData.id;

        var password = document.createElement("td");
        password.innerHTML = jsonData.author;
        var name = document.createElement("td");
        name.innerHTML = jsonData.text;


        tr.appendChild(name)//author
        tr.appendChild(password);//text
        table.appendChild(tr);
  }}
}