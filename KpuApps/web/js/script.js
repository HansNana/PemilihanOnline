/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function checkCookieBeforeLoggedIn() {
    var username = getCookie("email");
    if (username == "") {
        alert("Mohon Maaf Untuk Mengakses Halaman Ini Anda Harus Login Terlebih Dahulu");
        window.open("Login.html", "_self")
    } else {
        document.getElementById("login").innerHTML = "Logged in As : Admin"
    }
}