const url = "http://localhost:3000/"
document.getElementById("createbtn").addEventListener("click", createUser);

async function createUser() {
    //gather the user inputs from the login inputs
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("userpassword").value;
    let fname = document.getElementById("f_name").value;
    let lname = document.getElementById("l_name").value;
    let email = document.getElementById("email").value;
    let role = document.getElementById("role_id").value;
    console.log(email)
    //we want to send the user/pass as JSON, so we need a JS object to send
    let user = {
        username:usern,
        userpassword:userp,
        f_name:fname,
        l_name:lname,
        email:email,
        role_id:role

    }
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    console.log(user)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch (url + "users", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(user), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });
    if(response.status === 201) {
        //wipe our login row and welcome the user 
        let message = document.createElement("h2");
        message.innerText = "User Created successfully"
        document.body.appendChild(message);
    }else{
        let message = document.createElement("h2");
        message.innerText = "User could not be created"
        document.body.appendChild(message);
    }
        setTimeout(() => {
            window.location.href="manager.html"; 
        }, 3000);
}
