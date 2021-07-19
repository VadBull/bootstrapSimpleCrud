function deleteUser(id) {

    fetch('http://localhost:8080/delete/' + id, {
        method: 'DELETE',
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
        .then(response => {
            showAllUsers();
        });
}