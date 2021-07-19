showUserInfo();

function showUserInfo(user) {
    fetch('http://localhost:8080/getAuthorizedUser')
        .then(response => response.json())
        .then(user => {
            //заполняем таблицу информацией юзера
            let tBody = document.getElementById("user_info");
            tBody.innerHTML = "";

            var row = tBody.insertRow(0);
            var cell0 = row.insertCell(0);
            cell0.innerHTML = user.id;
            var cell1 = row.insertCell(1);
            cell1.innerHTML = user.name;
            var cell2 = row.insertCell(2);
            cell2.innerHTML = user.lastName;
            var cell3 = row.insertCell(3);
            cell3.innerHTML = user.age;
            var cell4 = row.insertCell(4);
            cell4.innerHTML = user.email;
            var cell5 = row.insertCell(5);
            cell5.innerHTML = getRolesFromUser(user).textContent;
        });

}