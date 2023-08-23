async function registerUser(){
    //Validate
    if (document.getElementById("password").value != document.getElementById("password2").value){
        alert("Validate that the passwords match");
        return;
    };
    //Get user object
    let user = {};
    user.name = document.getElementById("firstName").value;
    user.lastName = document.getElementById("lastName").value;
    user.email = document.getElementById("email").value;
    user.phone = document.getElementById("phone").value;
    user.password = document.getElementById("password").value;

    console.log(user);
    //Call the service
    const response = await fetch("user", {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        //credentials: "same-origin", // include, *same-origin, omit
        headers: {
          "Content-Type": "application/json",
          //'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: JSON.stringify(user), // body data type must match "Content-Type" header
      });
      console.log(response);
      //Redirect
      if (response.ok){
        window.location.replace("login.html");
      }
}