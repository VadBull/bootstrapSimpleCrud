function getModalEdit(id) {

    fetch('http://localhost:8080/getUserById/' + id)
        .then(response => response.json())
        .then(user => {

            let adminSelect = "";
            let userSelect = "";

            for (let i = 0; i < user.roles.length; i++) {
                if (user.roles[i].roleName == "ADMIN") {
                    adminSelect = "selected";
                }
                if (user.roles[i].roleName == "USER") {
                    userSelect = "selected";
                }
            }

            let modal = document.getElementById('modalWindow');

            modal.innerHTML =
                '<div id="modalEdit" \n' +
                '     class="modal fade" tabindex="-1" role="dialog"\n' +
                '     aria-labelledby="TitleModalLabel" aria-hidden="true"\n' +
                '     data-backdrop="static" data-keyboard="false">\n' +
                '    <div class="modal-dialog modal-dialog-scrollable">\n' +
                '        <div class="modal-content">\n' +
                '            <div class="modal-header">\n' +
                '                <h5 class="modal-title" id="TitleModalLabel">Edit user</h5>\n' +
                '                <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
                '                    <span aria-hidden="true">&times;</span>\n' +
                '                </button>\n' +
                '            </div>\n' +
                '            <div class="modal-body bg-white">\n' +
                '                <form id="formEditUser" style="width: 200px;" ' +
                '                       class="form-signin mx-auto font-weight-bold text-center">\n' +
                '                    <p>\n' +
                '                        <label>ID</label>\n' +
                '                        <input class="form-control form-control-sm" type="text"\n' +
                '                               id="editID" name="id" value="' + user.id + '" readonly>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>First name</label>\n' +
                '                        <input class="form-control form-control-sm" type="text"\n' +
                '                               id="editName" value="' + user.name + '"\n' +
                '                               placeholder="First name" required>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Last name</label>\n' +
                '                        <input class="form-control form-control-sm" type="text"\n' +
                '                               id="editLastName" value="' + user.lastName + '" ' +
                '                               placeholder="Last name" required>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Age</label>\n' +
                '                        <input class="form-control form-control-sm" type="number"\n ' +
                '                               id="editAge" value="' + user.age + '"\n ' +
                '                               placeholder="Age" required>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Email</label>\n' +
                '                        <input class="form-control form-control-sm" type="email"\n' +
                '                               id="editEmail" value="' + user.email + '"\n' +
                '                               placeholder="Email" required>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Password</label>\n' +
                '                        <input class="form-control form-control-sm" type="password"\n' +
                '                               id="editPassword" placeholder="Password">\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Role</label>\n' +
                '                        <select id="editRoles" multiple size="2" required \n' +
                '                               class="form-control form-control-sm">\n' +
                '                            <option value="ADMIN"' + adminSelect + '>ADMIN</option>\n' +
                '                            <option value="USER"' + userSelect + '>USER</option>\n' +
                '                        </select>\n' +
                '                    </p>' +
                '                </form>\n' +
                '            </div>\n' +
                '            <div class="modal-footer">\n' +
                '                <button type="button" class="btn btn-secondary"\n' +
                '                        data-dismiss="modal">Close</button>\n' +
                '                <button class="btn btn-primary" data-dismiss="modal"\n' +
                '                        onclick="editUser()">Edit</button>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '</div>';

            $("#modalEdit").modal();

        });
}



