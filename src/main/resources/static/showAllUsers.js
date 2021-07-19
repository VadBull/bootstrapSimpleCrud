showAllUsers();

function showAllUsers(){
    let tBody = document.getElementById("tBody");
    tBody.innerHTML = "";

    fetch('http://localhost:8080/getAllUsers')
        .then(response => response.json())
        .then(users => {
            users.forEach(function (user) {

                //заполняем таблицу информацией юзера
                var row = tBody.insertRow();
                var cell0 = row.insertCell();
                cell0.innerHTML = user.id;
                var cell1 = row.insertCell();
                cell1.innerHTML = user.name;
                var cell2 = row.insertCell();
                cell2.innerHTML = user.lastName;
                var cell3 = row.insertCell();
                cell3.innerHTML = user.age;
                var cell4 = row.insertCell();
                cell4.innerHTML = user.email;
                var cell5 = row.insertCell();
                cell5.innerHTML = getRolesFromUser(user).textContent;

                var cell6 = row.insertCell();
                cell6.innerHTML =
                    '<button type="button" onclick="getModalEdit(' + user.id +')" class="btn btn-primary btn-sm">\n' +
                    '   Edit</button>\n';

                var cell7 = row.insertCell();
                cell7.innerHTML =
                    '<button type="button" onclick="getModalDelete(' + user.id +')" class="btn btn-danger btn-sm">' +
                    'Delete</button>\n';
            })
        });
}