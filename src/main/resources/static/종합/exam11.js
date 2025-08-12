console.log("exam11.js");

const boardWrite = ( ) => {
    console.log("boardWrite() exe")
    let data = { "bcontent" : "JS테스트중" , "bwriter" : "유재석"}
    let option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify( data )
    }
    fetch("/board" , option )
    .then( response => response.json() )
    .then( data => {console.log(data)})
    .catch( error => {console.log(error)})
}