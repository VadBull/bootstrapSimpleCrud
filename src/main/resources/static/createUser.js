function createUser() {

    fetch('http://localhost:8080/create', {
        method: 'POST',
        body: JSON.stringify({
            name: window.formNewUser.newName.value,
            lastName: window.formNewUser.newLastName.value,
            age: window.formNewUser.newAge.value,
            email: window.formNewUser.newEmail.value,
            password: window.formNewUser.newPassword.value,
            roles: window.formNewUser.newRoles.value
        }),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
        .then(response => {
            window.formNewUser.newName.value = "";
            window.formNewUser.newLastName.value = "";
            window.formNewUser.newAge.value = "";
            window.formNewUser.newEmail.value = "";
            window.formNewUser.newPassword.value = "";
            window.formNewUser.newRoles.value = "";

            showAllUsers();
            $('#successful').modal();
        });
}