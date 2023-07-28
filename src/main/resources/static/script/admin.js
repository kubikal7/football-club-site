function createBox(text){
    const box = document.createElement("div");
    box.id="box";
    box.style.width="100%";
    box.style.border="1px solid black";
    box.style.position="absolute";
    box.style.top="15px";
    box.style.left="50%";
    box.style.maxWidth="700px";
    box.style.transform="translate(-50%, 0)";
    box.style.backgroundColor="white";
    box.innerHTML=text;
    document.body.appendChild(box);
    }

function createBackground(){
    const background=document.createElement("div");
    background.style.backgroundColor="Black";
    background.style.position="absolute";
    background.style.height="100%";
    background.style.width="100%";
    background.style.top="0px";
    background.id="background";
    background.style.opacity="0.5";
    document.body.appendChild(background);
}

function returnDateObject(gotDate){
    const date = new Date(Date.parse(gotDate));
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const hour = String(date.getHours()).padStart(2, '0');
    const minute = String(date.getMinutes()).padStart(2, '0');

    dateObject = {
    year: year,
    month: month,
    day: day,
    fullDate: [year, month, day].join('-'),
    hour: hour,
    minute: minute,
    fullHour: [hour, minute].join(':')
    };

    return dateObject;
}

function setDisable(textName,radioName){
    if(document.getElementsByName(radioName)[0].checked==true){
        document.getElementsByName(textName)[0].disabled=false;
    }
    else{
        document.getElementsByName(textName)[0].disabled=true;
    }
}

function appearFormAdd(){
    text=`
    <input type="button" class="w3-button w3-black" value="X" style="float: right;" onclick="deleteBox()">
    <form id="addForm" action="/admin/players" method="post" class="w3-container">
        <label>Imie</label>
        <input type="text" name="name" class="w3-input w3-border w3-round-large" required>

        <label>Nazwisko</label>
        <input type="text" name="surname" class="w3-input w3-border w3-round-large" required>

        <label>Kraj</label>
        <input type="text" name="country" class="w3-input w3-border w3-round-large" required>

        <label>Pozycja</label><br>
        <input type="radio" name="position" value="B">
        <label>Bramkarz</label>
        <input type="radio" name="position" value="O" checked>
        <label>Obrońca</label>
        <input type="radio" name="position" value="P">
        <label>Pomocnik</label>
        <input type="radio" name="position" value="N">
        <label>Napastnik</label><br>

        <label>Wysokość</label>
        <input type="number" name="height" class="w3-input w3-border w3-round-large" required>

        <label>Waga</label>
        <input type="number" name="weight" class="w3-input w3-border w3-round-large" required>

        <label>Lepsza noga</label><br>
        <input type="radio" name="foot" value="Lewa">
        <label>Lewa</label>
        <input type="radio" name="foot" value="Prawa" checked>
        <label>Prawa</label><br>

        <label>Numer</label>
        <input type="number" name="number" min="1" max="99" class="w3-input w3-border w3-round-large" required>

        <label>URL zdjęcia</label>
        <input type="text" name="img" class="w3-input w3-border w3-round-large"><br>

        <input type="submit" class="w3-button w3-black" value="Dodaj" style="margin-bottom: 30px;">
    </form>`
    createBackground();
    createBox(text);
}

function appearFormEdit(player){
    text=`
    <input type="button" class="w3-button w3-black" value="X" style="float: right;" onclick="deleteBox()">
    <form id="addForm" action="/admin/players" method="post" class="w3-container">
    <input type="hidden" name="_method" value="put">
        <label>Id</label>
        <input type="number" name="id" class="w3-input w3-border w3-round-large" value="`+player.id+`" readonly>

        <label>Imie</label>
        <input type="text" name="name" class="w3-input w3-border w3-round-large" value="`+player.name+`" required>

        <label>Nazwisko</label>
        <input type="text" name="surname" class="w3-input w3-border w3-round-large" value="`+player.surname+`" required>

        <label>Kraj</label>
        <input type="text" name="country" class="w3-input w3-border w3-round-large" value="`+player.country+`" required>

        <label>Pozycja</label><br>
        <input type="radio" name="position" value="B">
        <label>Bramkarz</label>
        <input type="radio" name="position" value="O">
        <label>Obrońca</label>
        <input type="radio" name="position" value="P">
        <label>Pomocnik</label>
        <input type="radio" name="position" value="N">
        <label>Napastnik</label><br>

        <label>Wysokość</label>
        <input type="number" name="height" class="w3-input w3-border w3-round-large" value="`+player.height+`" required>

        <label>Waga</label>
        <input type="number" name="weight" class="w3-input w3-border w3-round-large" value="`+player.weight+`" required>

        <label>Lepsza noga</label><br>
        <input type="radio" name="foot" value="Lewa">
        <label>Lewa</label>
        <input type="radio" name="foot" value="Prawa">
        <label>Prawa</label><br>

        <label>Numer</label>
        <input type="number" name="number" min="1" max="99" class="w3-input w3-border w3-round-large" value="`+player.number+`" required>

        <label>URL zdjęcia</label>
        <input type="text" name="img" class="w3-input w3-border w3-round-large" value="`+player.img+`"><br>

        <input type="submit" class="w3-button w3-black" value="Edytuj" style="margin-bottom: 30px;">
    </form>`
    
    createBackground();
    createBox(text);
    positions = document.getElementsByName("position");
    for(i=0;i<positions.length;i++){
        if(positions[i].value==player.position){
            positions[i].checked=true;
        }
    }
    foots = document.getElementsByName("foot");
    for(i=0;i<foots.length;i++){
        if(foots[i].value==player.foot){
            foots[i].checked=true;
        }
    }
}

function deleteBox(){
    document.getElementById("box").remove();
    document.getElementById("background").remove();
}

function appearFormDeletePlayer(player){
    text=`
    <form id="addForm" action="/admin/players/`+player.id+`" method="post" class="w3-container">
    <input type="hidden" name="_method" value="delete">
        <p>Czy na pewno chcesz usunąć zawodnika `+player.name+" "+player.surname+" id: "+player.id+"?"+`</p>
        <input type="submit" class="w3-button w3-black" value="Usuń" style="margin-bottom: 30px;">
        <input type="button" class="w3-button w3-black" value="Anuluj" style="margin-bottom: 30px;" onclick="deleteBox()">
    </form>`
    createBackground();
    createBox(text);
}

function appearFormAddPost(){
    text=`
    <input type="button" class="w3-button w3-black" value="X" style="float: right;" onclick="deleteBox()">
    <form id="addForm" action="/admin/posts" method="post" class="w3-container">
        <label>Tytuł</label>
        <input type="text" name="title" class="w3-input w3-border w3-round-large" required>

        <label>Opis</label>
        <textarea name="description" class="w3-input w3-border w3-round-large" style="height: 100px; vertical-align=top;" maxlength="2000" required></textarea>

        <label>URL zdjęcia</label>
        <input type="text" name="img" class="w3-input w3-border w3-round-large" required><br>

        <input type="submit" class="w3-button w3-black" value="Dodaj" style="margin-bottom: 30px;">
    </form>`
    createBackground();
    createBox(text);
}

function appearFormEditPost(post){
    const date = returnDateObject(post.date);

    //alert(date.fullDate);
    text=`
    <input type="button" class="w3-button w3-black" value="X" style="float: right;" onclick="deleteBox()">
    <form id="addForm" action="/admin/posts" method="post" class="w3-container">
    <input type="hidden" name="_method" value="put">
        <label>Id</label>
        <input type="number" name="id" class="w3-input w3-border w3-round-large" value="`+post.id+`" readonly>

        <label>Tytuł</label>
        <input type="text" name="title" class="w3-input w3-border w3-round-large" value="`+post.title+`"required>

        <label>Opis</label>
        <textarea name="description" class="w3-input w3-border w3-round-large" style="height: 100px; vertical-align=top;" maxlength="2000" required>`+post.description+`</textarea>

        <label>Data</label>
        <input type="date" name="fullDate" value="`+date.fullDate+`"><input type="time" name="fullHour" value="`+date.fullHour+`"><br>

        <label>URL zdjęcia</label>
        <input type="text" name="img" class="w3-input w3-border w3-round-large" value="`+post.img+`"required><br>

        <input type="submit" class="w3-button w3-black" value="Dodaj" style="margin-bottom: 30px;">
    </form>`
    createBackground();
    createBox(text);
}

function appearFormDeletePost(post){
    text=`
    <form id="addForm" action="/admin/posts/`+post.id+`" method="post" class="w3-container">
    <input type="hidden" name="_method" value="delete">
        <p>Czy na pewno chcesz usunąć post `+post.title+" id: "+post.id+"?"+`</p>
        <input type="submit" class="w3-button w3-black" value="Usuń" style="margin-bottom: 30px;">
        <input type="button" class="w3-button w3-black" value="Anuluj" style="margin-bottom: 30px;" onclick="deleteBox()">
    </form>`
    createBackground();
    createBox(text);
}

function appearFormAddGame(){
    text=`
    <input type="button" class="w3-button w3-black" value="X" style="float: right;" onclick="deleteBox()">
    <form id="addForm" action="/admin/games" method="post" class="w3-container">
        <label>Przeciwnik</label>
        <input type="text" name="opponent" class="w3-input w3-border w3-round-large" required>

        <label>Lokacja</label><br>
        <input type="radio" name="location" value="D" checked>
        <label>Dom</label>
        <input type="radio" name="location" value="W">
        <label>Wyjazd</label>
        <input type="radio" name="location" value="N">
        <label>Teren neutralny</label><br><br>

        <label>Data</label>
        <input type="date" name="fullDate" required><input type="time" name="fullHour" required><br><br>

        <label>Już rozegrany?</label>
        <input type="radio" name="finished" value="true" onchange="setDisable('result','finished')">
        <label>Tak</label>
        <input type="radio" name="finished" value="false" onchange="setDisable('result','finished')" checked>
        <label>Nie</label><br>
        <label>Jeżeli tak podaj wynik</label><input type="text" name="result" disabled><br><br>

        <input type="submit" class="w3-button w3-black" value="Dodaj" style="margin-bottom: 30px;">
    </form>`
    createBackground();
    createBox(text);
}

function appearFormEditGame(game){
    const date = returnDateObject(game.date);

    //alert(typeof game.location);
    text=`
    <input type="button" class="w3-button w3-black" value="X" style="float: right;" onclick="deleteBox()">
    <form id="addForm" action="/admin/games" method="post" class="w3-container">
    <input type="hidden" name="_method" value="put">
        <label>Id</label>
        <input type="number" name="id" class="w3-input w3-border w3-round-large" value="`+game.id+`" readonly>

        <label>Przeciwnik</label>
        <input type="text" name="opponent" class="w3-input w3-border w3-round-large" value="`+game.opponent+`" required>

        <label>Lokacja</label><br>
        <input type="radio" name="location" value="D">
        <label>Dom</label>
        <input type="radio" name="location" value="W">
        <label>Wyjazd</label>
        <input type="radio" name="location" value="N">
        <label>Teren neutralny</label><br><br>

        <label>Data</label>
        <input type="date" name="fullDate" value="`+date.fullDate+`" required><input type="time" name="fullHour" value="`+date.fullHour+`" required><br><br>

        <label>Już rozegrany?</label>
        <input type="radio" name="finished" value="true" onchange="setDisable('result','finished')">
        <label>Tak</label>
        <input type="radio" name="finished" value="false" onchange="setDisable('result','finished')" checked>
        <label>Nie</label><br>
        <label>Jeżeli tak podaj wynik</label><input type="text" name="result" disabled><br><br>

        <input type="submit" class="w3-button w3-black" value="Edytuj" style="margin-bottom: 30px;">
    </form>`
    createBackground();
    createBox(text);

    locations = document.getElementsByName("location");
    for(i=0;i<locations.length;i++){
        if(locations[i].value==game.location){
            locations[i].checked=true;
        }
    }
}

function appearFormDeleteGame(game){
    text=`
    <form id="addForm" action="/admin/games/`+game.id+`" method="post" class="w3-container">
    <input type="hidden" name="_method" value="delete">
        <p>Czy na pewno chcesz usunąć mecz vs `+game.opponent+" id: "+game.id+"?"+`</p>
        <input type="submit" class="w3-button w3-black" value="Usuń" style="margin-bottom: 30px;">
        <input type="button" class="w3-button w3-black" value="Anuluj" style="margin-bottom: 30px;" onclick="deleteBox()">
    </form>`
    createBackground();
    createBox(text);
}