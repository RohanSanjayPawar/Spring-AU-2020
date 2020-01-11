function validate() {
    var username = document.getElementById('uname').value;
    var password = document.getElementById('pwd').value;
    var confirm_password = document.getElementById('con_pwd').value;

    var reg1 = /[0-9]+/;
    var reg2 = /[a-z]+/;
    var reg3 = /[A-Z]+/;
    var reg4 = /[@$*]/;
    var reg5 = /abc/;

    var count = 0;

    document.getElementById('username').style.display='none';
    document.getElementById('same').style.display='none';
    document.getElementById('minLength').style.display='none';
    document.getElementById('numeric').style.display='none';
    document.getElementById('lower').style.display='none';
    document.getElementById('upper').style.display='none';
    document.getElementById('special').style.display='none';
    document.getElementById('abc').style.display='none';
    document.getElementById('normal').style.display='none';

    if(password != confirm_password){
        document.getElementById('same').style.display='block';
        count++;

    }
    else if(password.length < 8 || password.length > 50){
        document.getElementById('minLength').style.display='block';
        count++;
    }
    if(username.length < 8 || username.length > 50) {
        document.getElementById('username').style.display='block';
        count++;
    }
    if(!reg1.test(password)){
        document.getElementById('numeric').style.display='block';
        count++;
    }
    if(!reg2.test(password)){
        document.getElementById('lower').style.display='block';
        count++;
    }
    if(!reg3.test(password)){
        document.getElementById('upper').style.display='block';
        count++;
    }
    if(!reg4.test(password)){
        document.getElementById('special').style.display='block';
        count++;
    }
    if(!reg5.test(password)){
        document.getElementById('abc').style.display='block';
        count++;
    }
    console.log(count);
    if(count == 0){
        console.log(username+" "+password);
        document.getElementById('normal').style.display='block';
        document.getElementById('normal').textContent = "Username is: "+username+" and Password is: "+password;
    }
    else    
        console.log("WRONG");
}
