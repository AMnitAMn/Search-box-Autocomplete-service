function fetchSuggestions() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {

        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("suggestions").innerHTML = '';
            if(this.responseText!="null" && this.responseText!=""){
                var response = JSON.parse(this.responseText);
                createDropdown(response);
            }
        }
    };

    var searchText = document.getElementById("searchBox").value;

    if (/^[a-zA-Z]+$/.test(searchText)){
        xhttp.open("GET", "http://localhost:8080/search?q=" + searchText, true);
        xhttp.send();
    }
}

function selectVal(value){
    document.getElementById("searchBox").value = value;
    fetchSuggestions();
}

function createDropdown(response){
    var ul = document.getElementById("suggestions");
    for (const val of response) {
        var li = document.createElement('li');
        li.appendChild(document.createTextNode(val));
        li.className = 'dynamic-li';
        li.setAttribute("onclick", "selectVal('" + val + "')");

        ul.appendChild(li);
    }
}