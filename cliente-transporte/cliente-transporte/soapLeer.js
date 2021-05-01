var mensaje

function ini() {
    mensaje = '<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">' +
    '<Body>'+
    '<ListaDeCarrosRequest xmlns="http://equipo8.me/transporte">' +
  
    '</ListaDeCarrosRequest>' +
    '</Body>' +
    '</Envelope>'
}
function soap() {
  ini();
  axios
    .post("http://localhost:8080/ws/transporte", mensaje, {
      headers: {
        "Content-Type": "text/xml",
      },
    })

    .then(function (response) {
      console.log(response.data);
      document.getElementById("r").value = resul(response.data);
    })
    .catch((err) => console.log(err));
}

function resul(rXml){
  var txt ='';
  var id,nombre,cantidad,unidad,precio;
  var parser = new DOMParser();
  var xmlDoc = parser.parseFromString(rXml, "text/xml");
  var res = xmlDoc.getElementsByTagName("ns2:producto");
  var resul = res.length;
  for(i=0; i<resul;i++){
    id = xmlDoc.getElementsByTagName("ns2:id")[i].childNodes[0].nodeValue;
    nombre = xmlDoc.getElementsByTagName("ns2:nombre")[i].childNodes[0].nodeValue;
    cantidad = xmlDoc.getElementsByTagName("ns2:cantidad")[i].childNodes[0].nodeValue;
    unidad = xmlDoc.getElementsByTagName("ns2:unidad")[i].childNodes[0].nodeValue;
    precio = xmlDoc.getElementsByTagName("ns2:precio")[i].childNodes[0].nodeValue;
    console.log("Id: "+id+ " nombre: "+nombre+ " cantidad: "+cantidad+ " unidad: "+unidad+ " precio: "+precio);
    txt+= "Id: "+id+ " nombre: "+nombre+ " cantidad: "+cantidad+ " unidad: "+unidad+ " precio: "+precio+ "<br>";
  }
  document.getElementById("r").innerHTML = txt;
  return "tengo "+ resul +" articulos registrados";
}