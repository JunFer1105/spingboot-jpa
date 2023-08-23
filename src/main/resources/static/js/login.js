async function login(){
    //Get user object
    let user = {};
    user.email = document.getElementById("email").value;
    user.password = document.getElementById("password").value;

    console.log(user);
    //Call the service
    const response = await fetch("auth/login", {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        //credentials: "same-origin", // include, *same-origin, omit
        headers: {
          "Content-Type": "application/json",
          //'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(user), // body data type must match "Content-Type" header
      });
      //var confirmation = await response.json();
      var responseTxt = await response.text();
      if (responseTxt == "OK"){
        window.location.replace("index.html");
      }else{
        alert("Invalid login")
      }
}