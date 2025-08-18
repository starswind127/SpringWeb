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
const boardPrint = () => {
    console.log( "boardPrint() exe" )
    let option = { method : "GET" }
    fetch( "/board" , option )
        .then( response => response.json() )
        .then( data => { console.log(data)})
        .catch( error => {console.log(error)})
}

const boardDelete = () => {
    console.log("boardDelete() exe")
    let bno = 3;
    let option = { method : "DELETE"}
    fetch(`/board?bno=${bno}` , option)
        .then( response => response.json() )
        .then( data => { console.log(data)})
        .catch( error => {console.log(error)})
}

const boardUpdate = () => {
    console.log("boardUpdate() exe")
    let data = { "bno" : 37 , "bcontent" : "JS에서수정"}
    let option = {
        method : "PUT",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify( data )
    }
    fetch("/board" , option )
        .then( response => response.json() )
        .then( data => {console.log(data)})
        .catch( error => {console.log(error)}) 
}0