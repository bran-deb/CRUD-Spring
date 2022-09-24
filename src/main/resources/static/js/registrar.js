
// Call the dataTables jQuery plugin
$(document).ready(function () {
    //on ready
});


async function registrarUsuario() {

    const request = await fetch("api/usuario", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
}
