$(document).ready(function() {
   // on ready
});


async function iniciarSesion() {
  let datos = {};
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;

  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  let respuesta = await request;
    console.log(respuesta.status)
  if(respuesta.status == 200) {
     window.location.href = 'usuarios.html'
  }else{
       alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
 }
}
