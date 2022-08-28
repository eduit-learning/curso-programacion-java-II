function getUsers() {
        const xhr = new XMLHttpRequest();
        searchCriteria = document.getElementById('searchCriteria').value;
        searchCriteria = searchCriteria == null || searchCriteria == 'undefined' ? "" : searchCriteria;
        var queryString = '?searchCriteria=' + searchCriteria;
        xhr.open('GET', `${baseUrl}/usersdb${queryString}`, true);

        xhr.onload = (event) => {
            var messageLabel = document.getElementById('message-label');
            var tbody = document.getElementById('user-list-body');
            tbody.innerHTML = '';
            var response = JSON.parse(xhr.responseText);

            if (response.statusCode == 200) {
                messageLabel.style.color = "green";
                messageLabel.innerHTML = response.message;
                response.content.forEach((item) => {
                    var pl = 'No Definido!';
                    var rol = 'No Definido!'
                    if (item.programmingLanguages != 'undefined' && item.programmingLanguages != null) {
                        item.programmingLanguages.forEach((plItem) => {
                            pl = `<ul><li>${plItem}</li></ul>`
                        });
                    }

                    if (item.roles != 'undefined' && item.roles != null) {
                        item.roles.forEach((rlItem) => {
                            rol = `<ul><li>${rlItem}</li></ul>`
                        });
                    }

                    tbody.innerHTML += `<tr><td>${item.userID}</td><td>${item.name}</td><td>${item.lastName}</td>
                    <td>${item.email}</td><td>${item.userName}</td>
                    <td>${item.country == `undefined` || item.country == null ? `No Definido!` : item.country}</td>
                    <td>${pl}</td><td>${rol}</td>
                    <td>${item.language == `undefined` || item.language == null ? `No Definido!` : item.language}</td>
                    <td><a href="${baseUrl}/User/DeleteUser.html?userID=${item.userID}">Eliminar usuario</a> <br/>
                    <a href="${baseUrl}/User/UpdateUser.html?userID=${item.userID}">Actualizar usuario</a></td></tr>`
                });
                var timeout = window.setTimeout(function () {
                    messageLabel.innerHTML = '';
                    clearTimeout(timeout);
                }, 10000);
            } else {
                messageLabel.style.color = "red";
                messageLabel.innerHTML = response.message;
            }
        };

        xhr.onerror = (event) => {
            alert('Ocurrió un error al intentar hacer la petición: ' + event.message);
        }

        xhr.send();
    }