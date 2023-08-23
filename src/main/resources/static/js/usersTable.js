// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#usersTables').DataTable();
});

async function loadUsers(){
    //Call the service
    const response = await fetch("user", {
        method: "GET", // *GET, POST, PUT, DELETE, etc.
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        //credentials: "same-origin", // include, *same-origin, omit
        headers: {
          "Content-Type": "application/json",
          //'Content-Type': 'application/x-www-form-urlencoded',
        },
        //body: JSON.stringify(data), // body data type must match "Content-Type" header
      });
      const users = await response.json();
      console.log(users);

      //Clear table data

          const tBody = document.getElementById("usersTables").getElementsByTagName("tbody")[0];
          const oldRows = tBody.getElementsByTagName("tr");
          var rowsSize = oldRows.length;
          for (var i=0;i<rowsSize;i++){
              tBody.removeChild(oldRows[0]);
          }

      //Fill the table with the records obtained from the service
      users.forEach(x => {
        console.log(x);
        var row = document.createElement('tr');

        var col1 = document.createElement('td');
        col1.append(x.id);
        var col2 = document.createElement('td');
        col2.append(x.name + " " +x.lastName);
        var col3 = document.createElement('td');
        col3.append(x.email);
        var col4 = document.createElement('td');
        col4.append(x.phone);
        var col5 = document.createElement('td');

        //Add delete button
        var buttonCont =  document.createElement("a");
        buttonCont.setAttribute("class","btn btn-danger btn-circle btn-sm");
        buttonCont.setAttribute("onClick","deleteUser("+x.id+")");

        var buttonInt = document.createElement("i");
        buttonInt.setAttribute("class","fas fa-trash");

        buttonCont.appendChild(buttonInt);
        col5.appendChild(buttonCont)

        row.appendChild(col1);
        row.appendChild(col2);
        row.appendChild(col3);
        row.appendChild(col4);
        row.appendChild(col5);

        $('#usersTables tbody').append(row);
      })
}

async function deleteUser(id){
    const response = await fetch("user/"+id, {
        method: "DELETE", // *GET, POST, PUT, DELETE, etc.
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        //credentials: "same-origin", // include, *same-origin, omit
        headers: {
          "Content-Type": "application/json",
          //'Content-Type': 'application/x-www-form-urlencoded',
        },
        //body: JSON.stringify(data), // body data type must match "Content-Type" header
      });
      if (response.ok){
        alert("Eliminado");
        loadUsers();
      }else{
        alert("Error al eliminar");
      }
      //const users = await response.json();
      //console.log(users);
}
