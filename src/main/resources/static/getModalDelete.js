function getModalDelete(id) {

    fetch('http://localhost:8080/getUserById/' + id)
        .then(response => response.json())
        .then(user => {

            let modal = document.getElementById('modalWindow');

            modal.innerHTML =
                '<div id="modalDelete" \n' +
                '     class="modal fade" tabindex="-1" role="dialog"\n' +
                '     aria-labelledby="TitleModalLabel" aria-hidden="true"\n' +
                '     data-backdrop="static" data-keyboard="false">\n' +
                '    <div class="modal-dialog modal-dialog-scrollable">\n' +
                '        <div class="modal-content">\n' +
                '            <div class="modal-header">\n' +
                '                <h5 class="modal-title" id="TitleModalLabel">Delete user</h5>\n' +
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
                '                               name="id" value="' + user.id + '" readonly>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>First name</label>\n' +
                '                        <input class="form-control form-control-sm" type="text"\n' +
                '                               value="' + user.name + '" readonly>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Last name</label>\n' +
                '                        <input class="form-control form-control-sm" type="text"\n' +
                '                               value="' + user.lastName + '" readonly>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Age</label>\n' +
                '                        <input class="form-control form-control-sm" type="number"\n ' +
                '                               value="' + user.age + '" readonly>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Email</label>\n' +
                '                        <input class="form-control form-control-sm" type="email"\n' +
                '                               value="' + user.email + '" readonly>\n' +
                '                    </p>\n' +
                '                    <p>\n' +
                '                        <label>Role</label>\n' +
                '                        <select class="form-control form-control-sm" multiple size="2" readonly>\n' +
                '                            <option>ADMIN</option>\n' +
                '                            <option>USER</option>\n' +
                '                        </select>\n' +
                '                    </p>' +
                '                </form>\n' +
                '            </div>\n' +
                '            <div class="modal-footer">\n' +
                '                <button type="button" class="btn btn-secondary"\n' +
                '                        data-dismiss="modal">Close</button>\n' +
                '                <button class="btn btn-danger" data-dismiss="modal"\n' +
                '                        onclick="deleteUser(' + user.id + ')">Delete</button>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '</div>';

            $("#modalDelete").modal();

        });
}