function getRolesFromUser(user) {
    //вытаскиваем из юзера список его ролей
    let rolesList = document.createElement('ul');

    for (let i = 0; i < user.roles.length; i++) {
        let role = document.createElement('li');
        role.textContent = user.roles[i].roleName + " ";
        rolesList.appendChild(role);
    }

    return rolesList;
}